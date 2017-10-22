package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.SidukMapper;
import com.example.model.PendudukModel;
import com.example.model.KeluargaModel;
import com.example.model.KelurahanModel;
import com.example.model.KecamatanModel;
import com.example.model.KotaModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SidukServiceDatabase implements SidukService {
	@Autowired
	private SidukMapper sidukMapper;

	// method view penduduk
	@Override
	public PendudukModel selectPenduduk(String nik) {
		log.info("select penduduk with nik {}", nik);
		return sidukMapper.selectPenduduk(nik);
	}

	// method select view penduduk get data keluarga
	@Override
	public KeluargaModel selectKeluargaById(int id_keluarga) {
		log.info("select keluarga with id {}", id_keluarga);
		return sidukMapper.selectKeluargaById(id_keluarga);
	}

	// method select view penduduk get data keluarga, kelurahan
	@Override
	public KelurahanModel selectKelurahanById(int id_kelurahan) {
		log.info("select kelurahan with id {}", id_kelurahan);
		return sidukMapper.selectKelurahanById(id_kelurahan);
	}

	// method select view penduduk get data keluarga, kelurahan, kecamatan
	@Override
	public KecamatanModel selectKecamatanById(int id_kecamatan) {
		log.info("select kecamatan with id {}", id_kecamatan);
		return sidukMapper.selectKecamatanById(id_kecamatan);
	}

	// method select view penduduk get data keluarga, kelurahan, kecamatan, kota
	@Override
	public KotaModel selectKotaById(int id_kota) {
		log.info("select kota with id {}", id_kota);
		return sidukMapper.selectKotaById(id_kota);
	}

	// method select nik untuk di cek
	public String getCekNIK(String ceknik) {
		return sidukMapper.getCekNIK(ceknik);
	}

	// method add penduduk
	@Override
	public void addPenduduk(PendudukModel penduduk) {
		sidukMapper.addPenduduk(penduduk);
	}
	
	// method update penduduk
	public void updatePenduduk(PendudukModel penduduk) {
		sidukMapper.updatePenduduk(penduduk);
	}

	// method view keluarga
	@Override
	public KeluargaModel selectKeluarga(String nomor_kk) {
		log.info("select keluarga with nomor_kk {}", nomor_kk);
		return sidukMapper.selectKeluarga(nomor_kk);
	}

	// method select view anggota keluarga penduduk di keluarga
	@Override
	public List<PendudukModel> selectPendudukById(int id_keluarga) {
		log.info("select penduduk with id_keluarga {}", id_keluarga);
		return sidukMapper.selectPendudukById(id_keluarga);
	}

	// method add keluarga
	@Override
	public void addKeluarga(KeluargaModel keluarga) {
		sidukMapper.addKeluarga(keluarga);
	}

	// method update keluarga
	@Override
	public void updateKeluarga(KeluargaModel keluarga) {
		sidukMapper.updateKeluarga(keluarga);
	}

	// method select kode by nama
	@Override
	public KelurahanModel getNamaKelurahan(String nama_kelurahan) {
		return sidukMapper.getNamaKelurahan(nama_kelurahan);
	}

	// method select kode by nama
	@Override
	public KecamatanModel getNamaKecamatan(String nama_kecamatan) {
		return sidukMapper.getNamaKecamatan(nama_kecamatan);
	}

	// method select kode by nama
	@Override
	public KotaModel getNamaKota(String nama_kota) {
		return sidukMapper.getNamaKota(nama_kota);
	}
	
	// method select nkk untuk di cek
	@Override
	public String getCekNKK(String ceknkk) {
		return sidukMapper.getCekNKK(ceknkk);
	}
	
	// method get kode kelurahan
	@Override
	public int getKodeKelurahan(String kode_kelurahan) {
		return sidukMapper.getKodeKelurahan(kode_kelurahan);
	}
	
	// method update status kematian penduduk
	@Override
	public void updatePendudukStatus(String nik) {
		sidukMapper.updatePendudukStatus(nik);
	}
	
	// method update status berlaku penduduk
	@Override
	public void updateStatusBerlaku(int id_keluarga) {
		sidukMapper.updateStatusBerlaku(id_keluarga);
	}
	
	// method select list kota
	@Override
	public List<KotaModel> selectListKota() {
		return sidukMapper.selectListKota();
	}
	
	// method select list kecamatan by kota
	@Override
	public List<KecamatanModel> selectListKecamatan(String nama_kota) {
		return sidukMapper.selectListKecamatan(nama_kota);
	}
	
	// method select list kelurahan by kecamatan
	@Override
	public List<KelurahanModel> selectListKelurahan(String nama_kecamatan) {
		return sidukMapper.selectListKelurahan(nama_kecamatan);
	}
	
	// method select list penduduk by kelurahan
	@Override
	public List<PendudukModel> selectPendudukByIdKelurahan(int id_kelurahan) {
		return sidukMapper.selectPendudukByIdKelurahan(id_kelurahan);
	}
}
