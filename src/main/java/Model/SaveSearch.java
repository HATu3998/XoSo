package Model;

import java.sql.Date;

public class SaveSearch {
	private int maVeDo;
	private int maUser;
	private Date ngay;
	private String TenTinh;
	private int SoDo;
	private int KetQua;
	public SaveSearch() {
		super();
	}
	
	
	public SaveSearch(int maVeDo,int maUser, Date ngay, String tenTinh, int soDo, int ketQua) {
		super();
		this.maVeDo=maVeDo;
		this.maUser = maUser;
		this.ngay = ngay;
		TenTinh = tenTinh;
		SoDo = soDo;
		KetQua = ketQua;
	}
	
	public int getMaVeDo() {
		return maVeDo;
	}


	public void setMaVeDo(int maVeDo) {
		this.maVeDo = maVeDo;
	}


	public int getMaUser() {
		return maUser;
	}
	public void setMaUser(int maUser) {
		this.maUser = maUser;
	}
	public Date getNgay() {
		return ngay;
	}
	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}
	public String getTenTinh() {
		return TenTinh;
	}
	public void setTenTinh(String tenTinh) {
		TenTinh = tenTinh;
	}
	public int getSoDo() {
		return SoDo;
	}
	public void setSoDo(int soDo) {
		SoDo = soDo;
	}
	public int getKetQua() {
		return KetQua;
	}
	public void setKetQua(int ketQua) {
		KetQua = ketQua;
	}
	
	
	

}
