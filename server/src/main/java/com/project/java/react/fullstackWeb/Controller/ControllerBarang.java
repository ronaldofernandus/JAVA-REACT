package com.project.java.react.fullstackWeb.Controller;






import com.project.java.react.fullstackWeb.Model.Barang;
import com.project.java.react.fullstackWeb.Service.ServiceBarang;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
public class ControllerBarang {

    Logger logger = LoggerFactory.getLogger(ControllerBarang.class);

    @Autowired


    ServiceBarang serviceBarang;


    @Operation(summary = "Get a tutorial object by title", description = "Api to return list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success retrived"),
            @ApiResponse(responseCode = "404", description = "Not found")

    })



    @GetMapping("/barang")
    public ResponseEntity<List<Barang>> lihatBarang()  {
        List<Barang> customer = serviceBarang.lihatBarang().stream().toList();
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }


    @PostMapping("/barang")

    public ResponseEntity<Barang> tambahBarang (@RequestBody  Barang barang) {
        logger.debug("tambahBarang={} nama_barang={}",barang);

        return new ResponseEntity<Barang>(serviceBarang.tambahBarang(barang), HttpStatus.CREATED);
    }

    @PutMapping("/barang/{namaBarang}")
    public ResponseEntity<Barang> updateBarang(@PathVariable("namaBarang") String namaBarang, @RequestBody Barang barang) {
        logger.debug("Update barang with namaBarang {}: {}", namaBarang, barang);

        Barang updatedBarang = serviceBarang.updateDataByNamaBarang(namaBarang, barang);

        if (updatedBarang == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedBarang);
    }





    @DeleteMapping("/barang/{namaBarang}")
    public ResponseEntity<String> deleteBarangByNama(@PathVariable("namaBarang") String namaBarang) {
        logger.debug("Delete barang with namaBarang: {}", namaBarang);
        serviceBarang.deleteBarangByNama(namaBarang);
        return ResponseEntity.ok().body("Barang berhasil dihapus");
    }

    @GetMapping("/barang/nama/{namaBarang}")
    public ResponseEntity<Barang> getBarangByNama(@PathVariable String namaBarang) {
        logger.debug("Get barang with namaBarang: {}", namaBarang);
        Barang barang = serviceBarang.getBarangByNama(namaBarang);
        if (barang == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(barang);
    }



}

