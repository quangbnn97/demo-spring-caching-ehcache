package vn.tcx.demo.springcaching.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.tcx.demo.springcaching.domain.NhanVien;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Long>{

}
