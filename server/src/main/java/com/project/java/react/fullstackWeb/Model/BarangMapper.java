package com.project.java.react.fullstackWeb.Model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BarangMapper implements RowMapper<Barang> {
    @Override
    public Barang mapRow(ResultSet rs, int rowNum) throws SQLException {
        Barang barang = new Barang();

        barang.setBarangId(rs.getInt("barang_id"));
        barang.setNamaBarang(rs.getString("nama_barang"));
        barang.setKategori(rs.getString("kategori"));
        barang.setSatuan(rs.getInt("satuan"));
        barang.setHarga(rs.getLong("harga"));

        return barang;
    }
}
