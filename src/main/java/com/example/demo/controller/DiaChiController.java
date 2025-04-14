package com.example.demo.controller;

import com.example.demo.model.DiaChi;
import com.example.demo.service.DiaChiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diachi")
public class DiaChiController {

    @Autowired
    private DiaChiService diaChiService;

    @PostMapping
    public DiaChi create(@RequestBody DiaChi diaChi) {
        return diaChiService.save(diaChi);
    }

    @GetMapping
    public List<DiaChi> getAll() {
        return diaChiService.getAll();
    }

    @GetMapping("/{id}")
    public DiaChi getById(@PathVariable Integer id) {
        return diaChiService.getById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy địa chỉ với ID: " + id));
    }

    @PutMapping("/{id}")
    public DiaChi update(@PathVariable Integer id, @RequestBody DiaChi diaChi) {
        return diaChiService.update(id, diaChi);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        diaChiService.delete(id);
    }
}