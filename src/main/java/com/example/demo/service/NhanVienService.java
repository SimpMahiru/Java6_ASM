package com.example.demo.service;

import com.example.demo.model.NhanVien;
import com.example.demo.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    public NhanVien saveNhanVien(NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    public List<NhanVien> getAllNhanVien() {
        return nhanVienRepository.findAll();
    }

    public Optional<NhanVien> getNhanVienById(Integer id) {
        return nhanVienRepository.findById(id);
    }

    public NhanVien updateNhanVien(Integer id, NhanVien nhanVien) {
        return nhanVienRepository.findById(id)
                .map(existing -> {
                    existing.setMaNV(nhanVien.getMaNV());
                    existing.setHotenNV(nhanVien.getHotenNV());
                    existing.setSdt(nhanVien.getSdt());
                    existing.setDiaChi(nhanVien.getDiaChi());
                    existing.setNgaySinh(nhanVien.getNgaySinh());
                    existing.setGioiTinh(nhanVien.isGioiTinh());
                    existing.setChucVu(nhanVien.getChucVu());
                    existing.setLuong(nhanVien.getLuong());
                    existing.setNgayTuyenDung(nhanVien.getNgayTuyenDung());
                    existing.setTaiKhoan(nhanVien.getTaiKhoan());
                    existing.setMatKhau(nhanVien.getMatKhau());
                    existing.setTrangThai(nhanVien.isTrangThai());
                    return nhanVienRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Không tìm thấy nhân viên với ID: " + id));
    }

    public void deleteNhanVien(Integer id) {
        nhanVienRepository.deleteById(id);
    }
}