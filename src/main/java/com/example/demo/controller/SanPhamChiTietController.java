package com.example.demo.controller;


import com.example.demo.model.SanPhamChiTietEntity;
import com.example.demo.service.SanPhamChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sanphamchitiet")
public class SanPhamChiTietController {
    private final SanPhamChiTietService sanPhamChiTietService;

    @Autowired
    public SanPhamChiTietController(SanPhamChiTietService sanPhamChiTietService) {
        this.sanPhamChiTietService = sanPhamChiTietService;
    }

    // Lấy danh sách tất cả sản phẩm chi tiết
    @GetMapping
    public List<SanPhamChiTietEntity> getAll() {
        return sanPhamChiTietService.getAllSanPhamChiTiet();
    }

    // Lấy chi tiết theo ID
    @GetMapping("/{id}")
    public ResponseEntity<SanPhamChiTietEntity> getById(@PathVariable Integer id) {
        Optional<SanPhamChiTietEntity> chiTiet = sanPhamChiTietService.getSanPhamChiTietById(id);
        return chiTiet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Thêm mới
    @PostMapping
    public ResponseEntity<SanPhamChiTietEntity> create(@RequestBody SanPhamChiTietEntity sanPhamChiTiet) {
        SanPhamChiTietEntity created = sanPhamChiTietService.createSanPhamChiTiet(sanPhamChiTiet);
        return ResponseEntity.status(201).body(created);
    }

    // Cập nhật
    @PutMapping("/{id}")
    public ResponseEntity<SanPhamChiTietEntity> update(@PathVariable Integer id, @RequestBody SanPhamChiTietEntity sanPhamChiTiet) {
        SanPhamChiTietEntity updated = sanPhamChiTietService.updateSanPhamChiTiet(id, sanPhamChiTiet);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // Xoá
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        boolean deleted = sanPhamChiTietService.deleteSanPhamChiTiet(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
