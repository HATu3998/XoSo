package Model;

import java.sql.Date;

public class KetQuaTinh {
	private int MaVe;
	private String MaTinh;
	private Date ngay;
	private int GiaiTam;
	private int GiaiBay;
	private String GiaiSau;
	private int GiaiNam;
	private String GiaiBon;
	private String GiaiBa;
	private int GiaiHai;
	private int GiaiMot;
	private int GiaiDB;
	private String MaTinh2;
	private String TenTinh;
	private String Mien;
	
	
	
	public KetQuaTinh() {
		super();
	}
	public int getMaVe() {
		return MaVe;
	}
	public void setMaVe(int maVe) {
		MaVe = maVe;
	}
	public String getMaTinh() {
		return MaTinh;
	}
	public void setMaTinh(String maTinh) {
		MaTinh = maTinh;
	}
	public Date getNgay() {
		return ngay;
	}
	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}
	public int getGiaiTam() {
		return GiaiTam;
	}
	public void setGiaiTam(int giaiTam) {
		GiaiTam = giaiTam;
	}
	public int getGiaiBay() {
		return GiaiBay;
	}
	public void setGiaiBay(int giaiBay) {
		GiaiBay = giaiBay;
	}
	public String getGiaiSau() {
		return GiaiSau;
	}
	public void setGiaiSau(String giaiSau) {
		GiaiSau = giaiSau;
	}
	public int getGiaiNam() {
		return GiaiNam;
	}
	public void setGiaiNam(int giaiNam) {
		GiaiNam = giaiNam;
	}
	public String getGiaiBon() {
		return GiaiBon;
	}
	public void setGiaiBon(String giaiBon) {
		GiaiBon = giaiBon;
	}
	public String getGiaiBa() {
		return GiaiBa;
	}
	public void setGiaiBa(String giaiBa) {
		GiaiBa = giaiBa;
	}
	public int getGiaiHai() {
		return GiaiHai;
	}
	public void setGiaiHai(int giaiHai) {
		GiaiHai = giaiHai;
	}
	public int getGiaiMot() {
		return GiaiMot;
	}
	public void setGiaiMot(int giaiMot) {
		GiaiMot = giaiMot;
	}
	public int getGiaiDB() {
		return GiaiDB;
	}
	public void setGiaiDB(int giaiDB) {
		GiaiDB = giaiDB;
	}
	public String getMaTinh2() {
		return MaTinh2;
	}
	public void setMaTinh2(String maTinh2) {
		MaTinh2 = maTinh2;
	}
	public String getTenTinh() {
		return TenTinh;
	}
	public void setTenTinh(String tenTinh) {
		TenTinh = tenTinh;
	}
	public String getMien() {
		return Mien;
	}
	public void setMien(String mien) {
		Mien = mien;
	}
	public KetQuaTinh(int maVe, String maTinh, Date ngay, int giaiTam, int giaiBay, String giaiSau, int giaiNam,
			String giaiBon, String giaiBa, int giaiHai, int giaiMot, int giaiDB, String maTinh2, String tenTinh,
			String mien) {
		super();
		MaVe = maVe;
		MaTinh = maTinh;
		this.ngay = ngay;
		GiaiTam = giaiTam;
		GiaiBay = giaiBay;
		GiaiSau = giaiSau;
		GiaiNam = giaiNam;
		GiaiBon = giaiBon;
		GiaiBa = giaiBa;
		GiaiHai = giaiHai;
		GiaiMot = giaiMot;
		GiaiDB = giaiDB;
		MaTinh2 = maTinh2;
		TenTinh = tenTinh;
		Mien = mien;
	}
	
	
	
	
}
