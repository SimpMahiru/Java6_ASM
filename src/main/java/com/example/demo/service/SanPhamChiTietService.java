package com.example.demo.service;

import com.example.demo.model.SanPhamChiTietEntity;
import com.example.demo.repository.SanPhamChiTietRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SanPhamChiTietService {
    @Autowired
    private SanPhamChiTietRepo sanPhamChiTietRepository;

    public SanPhamChiTietEntity createSanPhamChiTiet(SanPhamChiTietEntity sanPhamChiTiet) {
        return sanPhamChiTietRepository.save(sanPhamChiTiet);
    }

    public List<SanPhamChiTietEntity> getAllSanPhamChiTiet() {
        return sanPhamChiTietRepository.findAll();
    }

    public Optional<SanPhamChiTietEntity> getSanPhamChiTietById(Integer id) {
        return sanPhamChiTietRepository.findById(id);
    }

    public SanPhamChiTietEntity updateSanPhamChiTiet(Integer id, SanPhamChiTietEntity sanPhamChiTiet) {
        if (sanPhamChiTietRepository.existsById(id)) {
            sanPhamChiTiet.setId(id);
            return sanPhamChiTietRepository.save(sanPhamChiTiet);
        }
        return null;
    }

    public boolean deleteSanPhamChiTiet(Integer id) {
        if (sanPhamChiTietRepository.existsById(id)) {
            sanPhamChiTietRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
