package com.example.demo.service;

import com.example.demo.model.DiaChi;
import com.example.demo.repository.DiaChiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiaChiService {

    @Autowired
    private DiaChiRepository diaChiRepository;

    public DiaChi save(DiaChi diaChi) {
        return diaChiRepository.save(diaChi);
    }

    public List<DiaChi> getAll() {
        return diaChiRepository.findAll();
    }

    public Optional<DiaChi> getById(Integer id) {
        return diaChiRepository.findById(id);
    }

    public DiaChi update(Integer id, DiaChi diaChi) {
        return diaChiRepository.findById(id)
                .map(existing -> {
                    existing.setMaDiaChi(diaChi.getMaDiaChi());
                    existing.setXa(diaChi.getXa());
                    existing.setHuyen(diaChi.getHuyen());
                    existing.setTinh(diaChi.getTinh());
                    existing.setTrangThai(diaChi.isTrangThai());
                    return diaChiRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Không tìm thấy địa chỉ với ID: " + id));
    }

    public void delete(Integer id) {
        diaChiRepository.deleteById(id);
    }
}