package com.example.demo.service;

import com.example.demo.model.KhachHang;
import com.example.demo.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepo;

    public KhachHang createKhachHang(KhachHang khachHang) {
        return khachHangRepo.save(khachHang);
    }

    public List<KhachHang> getAllKhachHang() {
        return khachHangRepo.findAll();
    }

    public Optional<KhachHang> getKhachHangById(Integer id) {
        return khachHangRepo.findById(id);
    }

    public KhachHang updateKhachHang(Integer id, KhachHang khachHang) {
        if (khachHangRepo.existsById(id)) {
            khachHang.setId(id);
            return khachHangRepo.save(khachHang);
        }
        return null;
    }

    public boolean deleteKhachHang(Integer id) {
        if (khachHangRepo.existsById(id)) {
            khachHangRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
