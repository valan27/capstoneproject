package org.example.capstoneproject.admin.service;

import org.example.capstoneproject.admin.dto.Admin;
import org.example.capstoneproject.admin.exception.AdminNotFoundException;
import org.example.capstoneproject.customer.dto.Customer;
import org.example.capstoneproject.customer.exception.CustomerNotFoundException;

import java.util.List;

public interface AdminService {
    public Admin addAdmin(Admin admin);
    public Admin updateAdmin(int adId, Admin admin);
    public void deleteById(int adId);
    public Admin findById(int adId) throws AdminNotFoundException;
    public List<Admin> findByAdName(String adName);
    public List<Admin> findByAdCity(String adCity);
    public List<Admin> findByAdPinCode(int adPinCode);
    public List<Admin> findAll();
}
