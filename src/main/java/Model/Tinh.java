package Model;

public class Tinh {
private String MaTinh;
private String TenTinh;
private String Mien;
public Tinh(String maTinh, String tenTinh, String mien) {
	super();
	MaTinh = maTinh;
	TenTinh = tenTinh;
	Mien = mien;
}
public String getMaTinh() {
	return MaTinh;
}
public void setMaTinh(String maTinh) {
	MaTinh = maTinh;
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
public Tinh() {
	super();
}


}
