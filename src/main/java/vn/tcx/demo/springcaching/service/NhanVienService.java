package vn.tcx.demo.springcaching.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import vn.tcx.demo.springcaching.domain.NhanVien;
import vn.tcx.demo.springcaching.repository.NhanVienRepository;

@Service
public class NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Cacheable(value = "nhanVienCache")
    public List<NhanVien> getDsNhanVien() {
        System.out.println("Get Ds Nhan Vien... ");

        return nhanVienRepository.findAll();
    }

    @Cacheable(value = "nhanVienCache", key = "#id")
    public Optional<NhanVien> getNhanVienById(Long id) {
        System.out.println("Get Nhan Vien... ");

        return nhanVienRepository.findById(id);
    }

    @CacheEvict(value = "nhanVienCache")
    public void clearCache() {
        System.out.println("Clear cache Ds Nhan Vien... ");
    }

    @CachePut(value = "nhanVienCache")
    public NhanVien updateNhanVienById(NhanVien nhanVien, String tenNhanVien) {
        nhanVien.setTenNhanVien(tenNhanVien);
        nhanVienRepository.save(nhanVien);

        return nhanVien;
    }
}
