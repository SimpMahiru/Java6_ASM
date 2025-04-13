package com.example.demo.service;

import com.example.demo.model.SanPhamEntity;
import com.example.demo.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    public SanPhamEntity createSanPham(SanPhamEntity sanPham) {
        return sanPhamRepository.save(sanPham);
    }

    public List<SanPhamEntity> getAllSanPham() {
        return sanPhamRepository.findAll();
    }

    public Optional<SanPhamEntity> getSanPhamById(Integer id) {
        return sanPhamRepository.findById(id);
    }

    public SanPhamEntity updateSanPham(Integer id, SanPhamEntity sanPham) {
        if (sanPhamRepository.existsById(id)) {
            sanPham.setId(id);
            return sanPhamRepository.save(sanPham);
        }
        return null;
    }

    public boolean deleteSanPham(Integer id) {
        if (sanPhamRepository.existsById(id)) {
            sanPhamRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
