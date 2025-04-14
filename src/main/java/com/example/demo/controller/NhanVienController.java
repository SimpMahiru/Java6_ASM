package com.example.demo.controller;

import com.example.demo.model.NhanVien;
import com.example.demo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nhanvien")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @PostMapping
    public NhanVien createNhanVien(@RequestBody NhanVien nhanVien) {
        return nhanVienService.saveNhanVien(nhanVien);
    }

    @GetMapping
    public List<NhanVien> getAllNhanVien() {
        return nhanVienService.getAllNhanVien();
    }

    @GetMapping("/{id}")
    public NhanVien getNhanVienById(@PathVariable Integer id) {
        return nhanVienService.getNhanVienById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy nhân viên với ID: " + id));
    }

    @PutMapping("/{id}")
    public NhanVien updateNhanVien(@PathVariable Integer id, @RequestBody NhanVien nhanVien) {
        return nhanVienService.updateNhanVien(id, nhanVien);
    }

    @DeleteMapping("/{id}")
    public void deleteNhanVien(@PathVariable Integer id) {
        nhanVienService.deleteNhanVien(id);
    }
}