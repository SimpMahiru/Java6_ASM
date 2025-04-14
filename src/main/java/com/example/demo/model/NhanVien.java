package com.example.demo.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "nhan_vien")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name ="ma_nhan_vien")
    private String maNV;

    @Column(name= "ho_ten_nhan_vien")
    private String hotenNV;

    @Column(name="so_dien_thoai")
    private String sdt;

    @ManyToOne
    @JoinColumn(name = "id_dia_chi", referencedColumnName = "id")
    private dia_chi diaChi;

    @Column(name="ngay_thang_nam_sinh")
    private String ngaySinh;

    @Column(name= "gioi_tinh")
    private boolean gioiTinh;

    @Column(name="chuc_vu")
    private String chucVu;

    @Column(name=" luong")
    private float luong;

    @Column(name="ngay_tuyen_dung")
    private String ngayTuyenDung;

    @Column(name="tai_khoan")
    private String taiKhoan;

    @Column(name="mat_khau")
    private String matKhau;

    @Column(name="trang_thai")
    private boolean trangThai;
}
