package com.project.java.react.fullstackWeb.Service;

import com.project.java.react.fullstackWeb.Model.Barang;
import com.project.java.react.fullstackWeb.Repository.BarangRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceImplementation implements ServiceBarang {

    private static final Logger LOG = LoggerFactory.getLogger(ServiceImplementation.class);

    private final BarangRepo barangRepo;

    public ServiceImplementation(BarangRepo barangRepo) {
        this.barangRepo = barangRepo;
    }

    @Override
    public List<Barang> lihatBarang() {
        List<Barang> barangList = barangRepo.lihatBarang();

        LOG.debug("Daftar barang: {}", barangList);
        return barangList;
    }

    @Override
    public Barang tambahBarang(Barang barang) {
        LOG.debug("Create barang: {}", barang);
        return barangRepo.tambahBarang(barang);
    }

    @Override
    public Barang getBarangByNama(String namaBarang) {
        Barang barang = barangRepo.getBarangByNama(namaBarang);
        if (barang == null) {
            LOG.warn("No Barang found with namaBarang: {}", namaBarang);
        }
        return barang;
    }

    @Override
    public Barang updateDataByNamaBarang(String namaBarang, Barang barang) {
        Barang updatedBarang = barangRepo.updateDataByNamaBarang(namaBarang, barang);
        if (updatedBarang == null) {
            LOG.warn("No Barang found with namaBarang: {}", namaBarang);
        }
        return updatedBarang;
    }

    @Override
    public void deleteBarangByNama(String namaBarang) {
        barangRepo.deleteBarangByNama(namaBarang);
        LOG.debug("Deleted Barang with namaBarang: {}", namaBarang);
    }


}
