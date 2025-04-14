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

    // Lấy tất cả hóa đơn
    public List<HoaDon> getAllHoaDon() {
        return hoaDonRepository.findAll();
    }

    // Lấy hóa đơn theo ID
    public Optional<HoaDon> getHoaDonById(Integer id) {
        return hoaDonRepository.findById(id);
    }

    // Thêm hóa đơn mới
    public HoaDon createHoaDon(HoaDon hoaDon) {
        // Gắn hoaDon vào các chi tiết để đảm bảo mappedBy hoạt động đúng
        if (hoaDon.getHoaDonChiTiet() != null) {
            hoaDon.getHoaDonChiTiet().forEach(ct -> ct.setHoaDon(hoaDon));
        }
        return hoaDonRepository.save(hoaDon);
    }

    // Cập nhật hóa đơn
    public Optional<HoaDon> updateHoaDon(Integer id, HoaDon updatedHoaDon) {
        return hoaDonRepository.findById(id).map(existing -> {
            existing.setMaHoaDon(updatedHoaDon.getMaHoaDon());
            existing.setNgayTao(updatedHoaDon.getNgayTao());
            existing.setGhiChu(updatedHoaDon.getGhiChu());
            existing.setTienGiam(updatedHoaDon.getTienGiam());
            existing.setTongTien(updatedHoaDon.getTongTien());
            existing.setTrangThai(updatedHoaDon.getTrangThai());
            existing.setNhanVien(updatedHoaDon.getNhanVien());
            existing.setKhachHang(updatedHoaDon.getKhachHang());

            // Cập nhật chi tiết hóa đơn
            if (updatedHoaDon.getHoaDonChiTiet() != null) {
                updatedHoaDon.getHoaDonChiTiet().forEach(ct -> ct.setHoaDon(existing));
                existing.setHoaDonChiTiet(updatedHoaDon.getHoaDonChiTiet());
            }

            return hoaDonRepository.save(existing);
        });
    }

    // Xóa hóa đơn
    public boolean deleteHoaDon(Integer id) {
        if (hoaDonRepository.existsById(id)) {
            hoaDonRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
