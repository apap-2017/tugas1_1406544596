package com.example.service;

import java.util.List;

import com.example.model.KecamatanModel;
import com.example.model.KeluargaModel;
import com.example.model.KelurahanModel;
import com.example.model.KotaModel;
import com.example.model.PendudukModel;

public interface SidukService {
	/*************************
	 * Service View Penduduk *
	 *************************/
	// view penduduk
	PendudukModel selectPenduduk(String nik);

	// select view penduduk get data di keluarga
	KeluargaModel selectKeluargaById(int id_keluarga);

	// select view penduduk get data di keluarga, kelurahan
	KelurahanModel selectKelurahanById(int id_kelurahan);

	// select view penduduk get data di keluarga, kelurahan, kecamatan
	KecamatanModel selectKecamatanById(int id_kecamatan);

	// select view penduduk get data di keluarga, kelurahan, kecamatan
	KotaModel selectKotaById(int id_kota);

	// select nik untuk di cek
	String getCekNIK(String ceknik);

	/************************
	 * Service Add Penduduk *
	 ************************/
	// add penduduk
	void addPenduduk(PendudukModel penduduk);

	// Service Update Penduduk
	// update penduduk
	void updatePenduduk(PendudukModel penduduk);

	/*************************
	 * Service View Keluarga *
	 *************************/
	// view keluarga
	KeluargaModel selectKeluarga(String nomor_kk);

	// select view anggota keluarga penduduk di keluarga
	List<PendudukModel> selectPendudukById(int id_keluarga);

	// select kode by nama
	KelurahanModel getNamaKelurahan(String nama_kelurahan);

	// select kode by nama
	KecamatanModel getNamaKecamatan(String nama_kecamatan);

	// select kode by nama
	KotaModel getNamaKota(String nama_kota);

	// select nkk untuk di cek
	String getCekNKK(String nkkbaru);

	// select kode kelurahan untuk set id kelurahan
	int getKodeKelurahan(String kode_kelurahan);

	/************************
	 * Service Add Keluarga *
	 ************************/
	// add keluarga
	void addKeluarga(KeluargaModel keluarga);

	/***************************
	 * Service Update Keluarga *
	 ***************************/
	// update keluarga
	void updateKeluarga(KeluargaModel keluarga);

	/**********************************
	 * Service Update Status Kematian *
	 **********************************/
	// update status kematian penduduk
	void updatePendudukStatus(String nik);

	// update status berlaku penduduk
	void updateStatusBerlaku(int id_keluarga);

	/*************************
	 * Service Find Keluarga *
	 *************************/
	// select list kota
	List<KotaModel> selectListKota();

	// select list kecamatan
	List<KecamatanModel> selectListKecamatan(String nama_kota);

	// select list kelurahan
	List<KelurahanModel> selectListKelurahan(String nama_kecamatan);

	// select list penduduk berdasarkan id kelurahan
	List<PendudukModel> selectPendudukByIdKelurahan(int id_kelurahan);

}
