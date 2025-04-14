package com.example.demo.service;

import com.example.demo.model.HoaDon;
import com.example.demo.repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoaDonService {

    @Autowired
    private HoaDonRepository hoaDonRepository;

    public HoaDon createHoaDon(HoaDon hoaDon) {
        if (hoaDon.getHoaDonChiTiet() != null) {
            hoaDon.getHoaDonChiTiet().forEach(ct -> ct.setHoaDon(hoaDon));
        }
        return hoaDonRepository.save(hoaDon);
    }

    public List<HoaDon> getAllHoaDon() {
        return hoaDonRepository.findAll();
    }

    public Optional<HoaDon> getHoaDonById(Integer id) {
        return hoaDonRepository.findById(id);
    }

    public Optional<HoaDon> updateHoaDon(Integer id, HoaDon hoaDon) {
        if (hoaDonRepository.existsById(id)) {
            hoaDon.setId(id);
            return Optional.of(hoaDonRepository.save(hoaDon));
        }
        return Optional.empty();
    }

    public boolean deleteHoaDon(Integer id) {
        if (hoaDonRepository.existsById(id)) {
            hoaDonRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
