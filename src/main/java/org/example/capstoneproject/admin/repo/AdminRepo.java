package org.example.capstoneproject.admin.repo;

import org.example.capstoneproject.admin.dto.Admin;
import org.example.capstoneproject.customer.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {
    List<Admin> findByAdName(String adName);
    List<Admin> findByAdCity(String adCity);
    List<Admin> findByAdPinCode(int adPinCode);
}
