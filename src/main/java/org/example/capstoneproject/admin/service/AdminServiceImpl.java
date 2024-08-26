package org.example.capstoneproject.admin.service;

import org.example.capstoneproject.admin.dto.Admin;
import org.example.capstoneproject.admin.exception.AdminNotFoundException;
import org.example.capstoneproject.admin.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminRepo adminRepo;
    @Override
    public Admin addAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

    @Override
    public Admin updateAdmin(int adId, Admin admin) {
        if(adminRepo.existsById(adId)){
            admin.setAdId(adId);
            return adminRepo.save(admin);
        }
        return null;
    }

    @Override
    public void deleteById(int adId) {
        adminRepo.deleteById(adId);
    }

    @Override
    public Admin findById(int adId) throws AdminNotFoundException {
        Optional<Admin> admin = adminRepo.findById(adId);
        if(admin.isEmpty()){
            throw new AdminNotFoundException(adId);
        }
        return admin.get();
    }

    @Override
    public List<Admin> findByAdName(String adName) {
        return adminRepo.findByAdName(adName);
    }

    @Override
    public List<Admin> findByAdCity(String adCity) {
        return adminRepo.findByAdCity(adCity);
    }

    @Override
    public List<Admin> findByAdPinCode(int adPinCode) {
        return adminRepo.findByAdPinCode(adPinCode);
    }

    @Override
    public List<Admin> findAll() {
        return adminRepo.findAll();
    }
}
