package com.example.demo.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dia_chi")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class DiaChi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="ma_dia_chi")
    private String maDiaChi;

    @Column(name="xa")
    private String xa;

    @Column(name="huyen")
    private String huyen;

    @Column(name="tinh")
    private String tinh;

    @Column(name="trang_thai")
    private boolean trangThai;
}