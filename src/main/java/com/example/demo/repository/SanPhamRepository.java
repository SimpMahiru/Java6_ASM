package com.example.demo.repository;

import com.example.demo.model.SanPhamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPhamEntity, Integer> {
}
