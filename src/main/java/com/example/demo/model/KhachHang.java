package com.example.demo.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "khach_hang")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name ="ma_khach_hang")
    private String maNV;

    @Column(name= "ho_ten_khach_hang")
    private String hotenNV;

    @Column(name="so_dien_thoai")
    private String sdt;

    @ManyToOne
    @JoinColumn(name = "id_dia_chi", referencedColumnName = "id")
    private DiaChi diaChi;

    @Column(name="ngay_sinh")
    private String ngaySinh;

    @Column(name= "gioi_tinh")
    private boolean gioiTinh;

    @Column(name="trang_thai")
    private boolean trangThai;
}
