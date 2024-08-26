package org.example.capstoneproject.admin.controller;

import org.example.capstoneproject.admin.dto.Admin;
import org.example.capstoneproject.admin.exception.AdminNotFoundException;
import org.example.capstoneproject.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shop/admins")
public class AdminController {
    @Autowired
    AdminService adminService;


    @GetMapping
    public List<Admin> findAll(){
        return adminService.findAll();
    }

    @GetMapping("/adName/{adName}")
    public List<Admin> findByAdName(@PathVariable("adName")String adName){
        return adminService.findByAdName(adName);
    }
    @GetMapping("/adCity/{adCity}")
    public List<Admin> findByAdCity(@PathVariable("adCity") String adCity){
        return adminService.findByAdCity(adCity);
    }

    @GetMapping("/adPinCode/{adPinCode}")
    public List<Admin> findByAdPinCode(@PathVariable("adPinCode")int adPinCode){
        return adminService.findByAdPinCode(adPinCode);
    }

    @GetMapping("/find/{adId}")
    public Admin findById(@PathVariable("adId")int adId) throws AdminNotFoundException {
        return adminService.findById(adId);
    }

    @DeleteMapping("/delete/{adId}")
    public void deleteById(@PathVariable("adId")int adId){
        adminService.deleteById(adId);
    }

    @PutMapping("/update/{adId}")
    public Admin updateAdmin(@PathVariable int adId, @RequestBody Admin admin){
        return adminService.updateAdmin(adId, admin);
    }

    @PostMapping("/add")
    public Admin addAdmin(@RequestBody Admin admin){
        return adminService.addAdmin(admin);
    }



}
