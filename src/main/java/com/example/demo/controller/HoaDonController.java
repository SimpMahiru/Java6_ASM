package com.example.demo.controller;

import com.example.demo.model.HoaDon;
import com.example.demo.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hoa-don")
public class HoaDonController {
    @Autowired
    private HoaDonService hoaDonService;

    // Lấy tất cả hóa đơn
    @GetMapping
    public ResponseEntity<List<HoaDon>> getAllHoaDon() {
        return ResponseEntity.ok(hoaDonService.getAllHoaDon());
    }

    // Lấy hóa đơn theo ID
    @GetMapping("/{id}")
    public ResponseEntity<HoaDon> getHoaDonById(@PathVariable Integer id) {
        Optional<HoaDon> hoaDon = hoaDonService.getHoaDonById(id);
        return hoaDon.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Tạo hóa đơn mới
    @PostMapping
    public ResponseEntity<HoaDon> createHoaDon(@RequestBody HoaDon hoaDon) {
        HoaDon created = hoaDonService.createHoaDon(hoaDon);
        return ResponseEntity.ok(created);
    }

    // Cập nhật hóa đơn
    @PutMapping("/{id}")
    public ResponseEntity<HoaDon> updateHoaDon(@PathVariable Integer id, @RequestBody HoaDon hoaDon) {
        Optional<HoaDon> updated = hoaDonService.updateHoaDon(id, hoaDon);
        return updated.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Xóa hóa đơn
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHoaDon(@PathVariable Integer id) {
        if (hoaDonService.deleteHoaDon(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
