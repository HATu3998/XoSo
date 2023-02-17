package Model;

public class TaiKhoan {
private int maUser;
private String taiKhoanKH;
private String matKhau;
private String hoTen;
private String diaChi;
private String sdt;
private String isAdmin;



public TaiKhoan() {
	super();
}


public TaiKhoan(int maUser, String taiKhoanKH, String matKhau, String hoTen, String diaChi, String sdt,String isAdmin) {
	super();
	this.maUser = maUser;
	this.taiKhoanKH = taiKhoanKH;
	this.matKhau = matKhau;
	this.hoTen = hoTen;
	this.diaChi = diaChi;
	this.sdt = sdt;
	this.isAdmin = isAdmin;
}


public TaiKhoan(int maUser, String taiKhoanKH, String matKhau, String hoTen, String diaChi, String sdt) {
	super();
	this.maUser = maUser;
	this.taiKhoanKH = taiKhoanKH;
	this.matKhau = matKhau;
	this.hoTen = hoTen;
	this.diaChi = diaChi;
	this.sdt = sdt;
}



public String getIsAdmin() {
	return isAdmin;
}
public void setIsAdmin(String isAdmin) {
	this.isAdmin = isAdmin;
}
public int getMaUser() {
	return maUser;
}
public void setMaUser(int maUser) {
	this.maUser = maUser;
}
public String getTaiKhoanKH() {
	return taiKhoanKH;
}
public void setTaiKhoanKH(String taiKhoanKH) {
	this.taiKhoanKH = taiKhoanKH;
}
public String getMatKhau() {
	return matKhau;
}
public void setMatKhau(String matKhau) {
	this.matKhau = matKhau;
}
public String getHoTen() {
	return hoTen;
}
public void setHoTen(String hoTen) {
	this.hoTen = hoTen;
}
public String getDiaChi() {
	return diaChi;
}
public void setDiaChi(String diaChi) {
	this.diaChi = diaChi;
}
public String getSdt() {
	return sdt;
}
public void setSdt(String sdt) {
	this.sdt = sdt;
}
@Override
public String toString() {
	return "TaiKhoan [maUser=" + maUser + ", taiKhoanKH=" + taiKhoanKH + ", matKhau=" + matKhau + ", hoTen=" + hoTen
			+ ", diaChi=" + diaChi + ", sdt=" + sdt + "]";
}


}
