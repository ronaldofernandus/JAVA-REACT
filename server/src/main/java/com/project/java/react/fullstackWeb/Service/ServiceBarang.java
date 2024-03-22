package com.project.java.react.fullstackWeb.Service;

import com.project.java.react.fullstackWeb.Model.Barang;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ServiceBarang {
    List<Barang> lihatBarang();
    Barang tambahBarang(Barang barang);



    Barang getBarangByNama(String namaBarang);

    Barang updateDataByNamaBarang(String namaBarang, Barang barang);

    void deleteBarangByNama(String namaBarang);
}
