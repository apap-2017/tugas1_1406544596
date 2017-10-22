package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.PendudukModel;
import com.example.model.KeluargaModel;
import com.example.model.KelurahanModel;
import com.example.model.KecamatanModel;
import com.example.model.KotaModel;

@Mapper
public interface SidukMapper {
	/*************************
	 *  Mapper View Penduduk *
	 *************************/
	// select view penduduk
	@Select("select * from penduduk where nik = #{nik}")
	PendudukModel selectPenduduk(String nik);

	// select view penduduk get data di keluarga
	@Select("select * from keluarga where id = #{id_keluarga}")
	KeluargaModel selectKeluargaById(int id_keluarga);

	// select view penduduk get data di keluarga, kelurahan
	@Select("select * from kelurahan where id = #{id_kelurahan}")
	KelurahanModel selectKelurahanById(int id_kelurahan);

	// select view penduduk get data di keluarga, kelurahan, kecamatan
	@Select("select * from kecamatan where id = #{id_kecamatan}")
	KecamatanModel selectKecamatanById(int id_kecamatan);

	// select view penduduk get data di keluarga, kelurahan, kecamatan, kota
	@Select("select * from kota where id = #{id_kota}")
	KotaModel selectKotaById(int id_kota);
	
	/***********************
	 * Mapper Add Penduduk *
	 ***********************/
	// select nik untuk di cek
	@Select("select max(nik) from penduduk WHERE nik like concat(#{ceknik},'%')")
	String getCekNIK(String ceknik);

	// add penduduk
	@Insert("insert into penduduk (nik, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, is_wni, id_keluarga,"
			+ "agama, pekerjaan, status_perkawinan, status_dalam_keluarga, golongan_darah, is_wafat)"
			+ "values ('${nik}', '${nama}', '${tempat_lahir}', '${tanggal_lahir}', ${jenis_kelamin},"
			+ "${is_wni}, ${id_keluarga}, '${agama}', '${pekerjaan}', '${status_perkawinan}',"
			+ "'${status_dalam_keluarga}', '${golongan_darah}', ${is_wafat})")
	void addPenduduk(PendudukModel penduduk);
	
	/***********************
	 * Mapper Update Penduduk *
	 ***********************/
	// update penduduk
	@Update("update penduduk set nik = #{nik}, nama = #{nama}, tempat_lahir = #{tempat_lahir},"
			+ "tanggal_lahir = #{tanggal_lahir}, jenis_kelamin = #{jenis_kelamin}, is_wni = #{is_wni},"
			+ "id_keluarga = #{id_keluarga}, agama = #{agama}, pekerjaan = #{pekerjaan},"
			+ "status_perkawinan = #{status_perkawinan}, status_dalam_keluarga =#{status_dalam_keluarga},"
			+ "golongan_darah = #{golongan_darah}, is_wafat = #{is_wafat} where nik = #{nik}")
	void updatePenduduk(PendudukModel penduduk);

	/**************************
	 *  Mapper View Keluarga  *
	 **************************/
	// select view keluarga
	@Select("select * from keluarga where nomor_kk = #{nomor_kk}")
	KeluargaModel selectKeluarga(String nomor_kk);

	// select view anggota keluarga penduduk di keluarga
	@Select("select * from penduduk where id_keluarga = #{id}")
	List<PendudukModel> selectPendudukById(int id_keluarga);
	
	/***********************
	 * Mapper Add Keluarga *
	 ***********************/
	// select kode kelurahan
	@Select("select kode_kelurahan from kelurahan where nama_kelurahan=#{nama_kelurahan}")
	KelurahanModel getNamaKelurahan(@Param("nama_kelurahan") String nama_kelurahan);

	// select kode kecamatan
	@Select("select kode_kecamatan from kecamatan where nama_kecamatan=#{nama_kecamatan}")
	KecamatanModel getNamaKecamatan(@Param("nama_kecamatan") String nama_kecamatan);

	// select kode kota
	@Select("select kode_kota from kota where nama_kota=#{nama_kota}")
	KotaModel getNamaKota(@Param("nama_kota") String nama_kota);

	// select nkk untuk di cek
	@Select("select max(nomor_kk) from keluarga where nomor_kk like concat(#{ceknkk},'%')")
	String getCekNKK(String ceknkk);

	// select kode kelurahan untuk set id kelurahan
	@Select("select id from kelurahan where kode_kelurahan = #{kode_kelurahan}")
	int getKodeKelurahan(String kode_kelurahan);

	// add keluarga
	@Insert("insert into keluarga (nomor_kk, alamat, RT, RW, id_kelurahan, is_tidak_berlaku) values"
			+ "('${nomor_kk}', '${alamat}', '${RT}', '${RW}', ${id_kelurahan}, ${is_tidak_berlaku})")
	void addKeluarga(KeluargaModel keluarga);
	
	/**************************
	 * Mapper Update Keluarga *
	 **************************/
	// update keluarga
	@Update("update keluarga set nomor_kk = #{nomor_kk}, alamat = #{alamat},"
			+ "RT = #{RT}, RW = #{RW}, id_kelurahan = #{id_kelurahan},"
			+ "is_tidak_berlaku = #{is_tidak_berlaku} where nomor_kk = #{nomor_kk}")
	void updateKeluarga(KeluargaModel keluarga);
	
	/**********************************
	 *  Mapper Update Status Kematian *
	 **********************************/
	// update status kematian penduduk
	@Update("update penduduk set  is_wafat = 1 where nik = #{nik}")
	void updatePendudukStatus(String nik);

	// update status berlaku penduduk
	@Update("update keluarga set is_tidak_berlaku = 1 where id = #{id}")
	void updateStatusBerlaku(int id_keluarga);

	/*************************
	 *  Mapper Cari Penduduk *
	 *************************/
	// select list kota
	@Select("select * from kota")
	List<KotaModel> selectListKota();

	// select list kecamatan by kota
	@Select("select * from kecamatan join " + "(select id from kota where nama_kota = #{nama_kota}) as kota "
			+ "on kota.id = kecamatan.id_kota")
	List<KecamatanModel> selectListKecamatan(@Param("nama_kota") String nama_kota);

	// select kode kelurahan
	@Select("select id from kelurahan where kode_kelurahan = #{kode_kelurahan}")
	int getIdbyKodeKelurahan(String kode_kelurahan);

	// select list kelurahan by kecamatan
	@Select("select * from kelurahan join "
			+ "(select id from kecamatan where nama_kecamatan = #{nama_kecamatan}) as kecamatan "
			+ "on kecamatan.id = kelurahan.id_kecamatan")
	List<KelurahanModel> selectListKelurahan(@Param("nama_kecamatan") String nama_kecamatan);

	// select list penduduk by kelurahan
	@Select("select * from penduduk join "
			+ "(select id from keluarga where id_kelurahan = #{id_kelurahan}) as keluarga "
			+ "on keluarga.id = penduduk.id_keluarga")
	List<PendudukModel> selectPendudukByIdKelurahan(int id_kelurahan);
}
