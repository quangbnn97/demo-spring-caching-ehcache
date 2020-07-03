package vn.tcx.demo.springcaching.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.tcx.demo.springcaching.domain.NhanVien;
import vn.tcx.demo.springcaching.service.NhanVienService;

@RestController
@RequestMapping(value = "/api/nhan-vien")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping
    public void getDsNhanVien() {
        for (int i = 0; i < 8; i++) {
            if (i == 4) {
                nhanVienService.clearCache();
            }

            List<NhanVien> listNhanVien = nhanVienService.getDsNhanVien();
            System.out.println("Size: " + listNhanVien.size());
        }
    }

    //    @GetMapping(value = "/{id}")
    //    @ResponseBody
    //    public ResponseEntity<NhanVien> getProductById(@PathVariable("id") Long id) {
    //
    //        for (int i = 0; i < 8; i++) {
    //            if (i == 4) {
    //                nhanVienService.clearCache();
    //            }
    //
    //            Optional<NhanVien> nhanVien = nhanVienService.getNhanVienById(id);
    //
    //            if (!nhanVien.isPresent()) {
    //                return new ResponseEntity<NhanVien>(HttpStatus.NOT_FOUND);
    //            }
    //            
    //            System.out.println("Size: " nhanVien.si);
    //        }
    //
    //        return new ResponseEntity<NhanVien>(nhanVien.get(), HttpStatus.OK);
    //    }
    //
    //    @PutMapping(value = "/{id}/{ten-nhan-vien}")
    //    public ResponseEntity<NhanVien> updateNhanVienById(@PathVariable("id") Long id,
    //            @PathVariable("ten-nhan-vien") String tenNhanVien) {
    //        Optional<NhanVien> nhanVien = nhanVienService.getNhanVienById(id);
    //        if (!nhanVien.isPresent())
    //            return new ResponseEntity<NhanVien>(HttpStatus.NOT_FOUND);
    //
    //        return new ResponseEntity<NhanVien>(
    //                nhanVienService.updateNhanVienById(nhanVien.get(), tenNhanVien), HttpStatus.OK);
    //    }
    //
    //    @DeleteMapping(value = "/{id}")
    //    public ResponseEntity<NhanVien> deleteNhanVienById(@PathVariable("id") Long id) {
    //        Optional<NhanVien> product = nhanVienService.getNhanVienById(id);
    //        if (!product.isPresent())
    //            return new ResponseEntity<NhanVien>(HttpStatus.NOT_FOUND);
    //
    //        nhanVienService.deleteNhanVienById(id);
    //        return new ResponseEntity<NhanVien>(HttpStatus.ACCEPTED);
    //    }
}
