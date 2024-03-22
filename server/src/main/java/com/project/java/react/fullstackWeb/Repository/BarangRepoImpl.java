package com.project.java.react.fullstackWeb.Repository;

import com.project.java.react.fullstackWeb.Model.Barang;
import com.project.java.react.fullstackWeb.Model.BarangMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BarangRepoImpl implements BarangRepo {

    private static final Logger LOG = LoggerFactory.getLogger(BarangRepoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Barang> lihatBarang() {
        String sql = "SELECT * FROM barangs";
        return jdbcTemplate.query(sql, new BarangMapper());
    }

    @Override
    public Barang tambahBarang(Barang barang) {
        String sql = "INSERT INTO barangs (nama_barang, kategori, satuan, harga) VALUES (?, ?, ?, ?) RETURNING barang_id";
        // Use PreparedStatement to retrieve the generated barangId
        Integer generatedBarangId = jdbcTemplate.queryForObject(sql, new Object[]{barang.getNamaBarang(), barang.getKategori(), barang.getSatuan(), barang.getHarga()}, Integer.class);
        LOG.info("Successfully inserted new Barang with barangId: {}", generatedBarangId);

        barang.setBarangId(generatedBarangId);

        return barang;
    }

    @Override
    public Barang getBarangByNama(String namaBarang) {
        String sql = "SELECT * FROM barangs WHERE nama_barang = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{namaBarang}, new BarangMapper());
    }

    @Override
    public Barang updateDataByNamaBarang(String namaBarang, Barang barang) {
        String sql = "UPDATE barangs SET kategori = ?, satuan = ?, harga = ? WHERE nama_barang = ?";
        int updatedRows = jdbcTemplate.update(sql, barang.getKategori(), barang.getSatuan(), barang.getHarga(), namaBarang);
        if (updatedRows == 0) {
            LOG.warn("No Barang found with namaBarang: {}", namaBarang);
            return null;
        }

        // Retrieve the updated Barang from the database
        Barang updatedBarang = getBarangByNama(namaBarang);
        LOG.debug("Updated Barang with namaBarang: {}", namaBarang);
        return updatedBarang;
    }

    @Override
    public void deleteBarangByNama(String namaBarang) {
        String sql = "DELETE FROM barangs WHERE nama_barang = ?";
        int deletedRows = jdbcTemplate.update(sql, namaBarang);
        LOG.debug("Deleted {} Barang(s) with namaBarang: {}", deletedRows, namaBarang);
    }





}
