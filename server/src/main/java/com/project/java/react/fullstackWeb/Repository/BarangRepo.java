package com.project.java.react.fullstackWeb.Repository;

import com.project.java.react.fullstackWeb.Model.Barang;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BarangRepo {
    List<Barang> lihatBarang();
    Barang tambahBarang(Barang barang);



    Barang getBarangByNama(String namaBarang);

    Barang updateDataByNamaBarang(String namaBarang, Barang barang);

    void deleteBarangByNama(String namaBarang);
}
