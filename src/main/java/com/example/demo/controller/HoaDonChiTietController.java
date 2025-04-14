package com.example.demo.controller;

import com.example.demo.model.HoaDonChiTiet;
import com.example.demo.service.HoaDonChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hoa-don-chi-tiet")
public class HoaDonChiTietController {

    @Autowired
    private HoaDonChiTietService service;

    @GetMapping
    public ResponseEntity<List<HoaDonChiTiet>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HoaDonChiTiet> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/hoa-don/{hoaDonId}")
    public ResponseEntity<List<HoaDonChiTiet>> getByHoaDonId(@PathVariable Integer hoaDonId) {
        return ResponseEntity.ok(service.getByHoaDonId(hoaDonId));
    }

    @PostMapping
    public ResponseEntity<HoaDonChiTiet> create(@RequestBody HoaDonChiTiet chiTiet) {
        return ResponseEntity.ok(service.create(chiTiet));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HoaDonChiTiet> update(@PathVariable Integer id, @RequestBody HoaDonChiTiet chiTiet) {
        HoaDonChiTiet updated = service.update(id, chiTiet);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (service.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
