package com.example.demo.controller;

import com.example.demo.model.SanPhamEntity;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sanpham")
public class SanPhamController {
    private final SanPhamService sanPhamService;

    @Autowired
    public SanPhamController(SanPhamService sanPhamService) {
        this.sanPhamService = sanPhamService;
    }

    // Lấy tất cả sản phẩm
    @GetMapping
    public List<SanPhamEntity> getAllSanPham() {
        return sanPhamService.getAllSanPham();
    }

    // Lấy sản phẩm theo ID
    @GetMapping("/{id}")
    public ResponseEntity<SanPhamEntity> getSanPhamById(@PathVariable Integer id) {
        Optional<SanPhamEntity> sanPham = sanPhamService.getSanPhamById(id);
        return sanPham.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Thêm mới sản phẩm
    @PostMapping
    public ResponseEntity<SanPhamEntity> createSanPham(@RequestBody SanPhamEntity sanPham) {
        SanPhamEntity createdSanPham = sanPhamService.createSanPham(sanPham);
        return new ResponseEntity<>(createdSanPham, HttpStatus.CREATED);
    }

    // Cập nhật sản phẩm
    @PutMapping("/{id}")
    public ResponseEntity<SanPhamEntity> updateSanPham(@PathVariable Integer id, @RequestBody SanPhamEntity sanPham) {
        SanPhamEntity updatedSanPham = sanPhamService.updateSanPham(id, sanPham);
        return updatedSanPham != null ? ResponseEntity.ok(updatedSanPham) : ResponseEntity.notFound().build();
    }

    // Xóa sản phẩm
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSanPham(@PathVariable Integer id) {
        boolean isDeleted = sanPhamService.deleteSanPham(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
