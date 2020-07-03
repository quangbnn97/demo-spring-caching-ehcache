package vn.tcx.demo.springcaching.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "nhan_vien")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NhanVien implements Serializable{

    private static final long serialVersionUID = 3678709154688738557L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ma_nhan_vien")
    private String maNhanVien;

    @Column(name = "ten_nhan_vien")
    private String tenNhanVien;

    @Column(name = "email")
    private String email;

    @Column(name = "so_dien_thoai")
    private Long soDienThoai;
}
