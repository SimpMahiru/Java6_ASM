package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "hoa_don")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HoaDonChiTiet> hoaDonChiTiet;

    @ManyToOne
    @JoinColumn(name = "nhan_vien")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "khach_hang")
    private KhachHang khachHang;

    @Column(name = "ma_hoa_don")
    private String maHoaDon;

    @Column(name = "tien_giam")
    private Double tienGiam;

    @Column(name = "ngay_tao")
    private LocalDate ngayTao;

    @Column(name = "ghi_chu")
    private String ghiChu;

    @Column(name = "trang_thai")
    private Boolean trangThai;

    @Column(name = "tong_tien")
    private Double tongTien;
}
