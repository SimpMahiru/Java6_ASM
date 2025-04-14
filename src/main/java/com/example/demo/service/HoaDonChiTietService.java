package com.example.demo.service;

import com.example.demo.model.HoaDonChiTiet;
import com.example.demo.repository.HoaDonChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoaDonChiTietService {

    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietRepository;

    public HoaDonChiTiet create(HoaDonChiTiet chiTiet) {
        return hoaDonChiTietRepository.save(chiTiet);
    }

    public List<HoaDonChiTiet> getAll() {
        return hoaDonChiTietRepository.findAll();
    }

    public Optional<HoaDonChiTiet> getById(Integer id) {
        return hoaDonChiTietRepository.findById(id);
    }

    public List<HoaDonChiTiet> getByHoaDonId(Integer hoaDonId) {
        return hoaDonChiTietRepository.findByHoaDon_Id(hoaDonId);
    }

    public HoaDonChiTiet update(Integer id, HoaDonChiTiet chiTiet) {
        if (hoaDonChiTietRepository.existsById(id)) {
            chiTiet.setId(id);
            return hoaDonChiTietRepository.save(chiTiet);
        }
        return null;
    }

    public boolean delete(Integer id) {
        if (hoaDonChiTietRepository.existsById(id)) {
            hoaDonChiTietRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
