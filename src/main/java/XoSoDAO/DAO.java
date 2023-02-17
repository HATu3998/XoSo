package XoSoDAO;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

import Connection.DBContext;
import Model.KetQua;
import Model.KetQuaTinh;
import Model.SaveSearch;
import Model.TaiKhoan;
import Model.Tinh;

public class DAO {
	Connection conn=null;
	PreparedStatement 	ps=null;
	ResultSet rs=null;
	private static final String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z 
private static final String alphaUpperCase = alpha.toUpperCase(); // A-Z   
private static final String digits = "0123456789"; // 0-9    
private static final String specials = "~=+%^*/()[]{}/!@#$?|";   
private static final String ALPHA_NUMERIC = alpha + alphaUpperCase + digits; 
private static final String ALL = alpha + alphaUpperCase + digits + specials;   
private static Random generator = new Random();

//hàm random mật khẩu
public String randomAlphaNumeric(int numberOfCharactor) {       
	StringBuilder sb = new StringBuilder();       
	for (int i = 0; i < numberOfCharactor; i++) {          
		int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);  
		char ch = ALPHA_NUMERIC.charAt(number);             sb.append(ch);         }     
	return sb.toString();     }     /**      * Random string password with at least 1 digit and 1 special character   
	 */     public String randomPassword(int numberOfCharactor) {    
		 List<String> result = new ArrayList<>();   
		 Consumer<String> appendChar = s -> {           
			 int number = randomNumber(0, s.length() - 1);       
			 result.add("" + s.charAt(number));         };      
			 appendChar.accept(digits);  
			 appendChar.accept(specials);   
			 while (result.size() < numberOfCharactor) {     
				 appendChar.accept(ALL);         }      
			 Collections.shuffle(result, generator);    
			 return String.join("", result);     }   
	 public static int randomNumber(int min, int max) {    
		 return generator.nextInt((max - min) + 1) + min;     } 
	 
	 
	 
	 
	//public List<KetQua> getAllKetQua(int start, int count){
	public List<KetQua> getAllKetQua(){
		List<KetQua> list=new ArrayList<>();
		String query="select * from KetQua";
		try {
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new KetQua(
						rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getInt(4),
						rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),
						rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getInt(12)
						));
				
				
//				KetQua kq= new KetQua();
//				int mave=rs.getInt("MaVe"); kq.setMaVe(mave);
//				String MaTinh=rs.getString("MaTinh"); kq.setMaTinh(MaTinh);
//				Date ngay=rs.getDate("ngay"); kq.setNgay(ngay);
//				int giaitam=rs.getInt("GiaiTam"); kq.setMaVe(giaitam);
//				int giaibay=rs.getInt("GiaiBay"); kq.setMaVe(giaibay);
//				int giaisau=rs.getInt("GiaiSau"); kq.setMaVe(giaisau);
//				int giainam=rs.getInt("GiaiNam"); kq.setMaVe(giainam);
//				int giaiBon=rs.getInt("GiaiBon"); kq.setMaVe(giaiBon);
//				int giaiba=rs.getInt("GiaiBa"); kq.setMaVe(giaiba);
//				int giaihai=rs.getInt("GiaiHai"); kq.setMaVe(giaihai);
//				int giaimot=rs.getInt("GiaiMot"); kq.setMaVe(giaimot);
//				int giaidb=rs.getInt("GiaiDB"); kq.setMaVe(giaidb);
//				list.add(kq);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
		
	}
	public List<KetQua> getPading(int index){
		List<KetQua> list=new ArrayList<>();
		String query="select * from KetQua\r\n"
				+ "order by MaVe\r\n"
				+ "offset ? rows\r\n"
				+ "fetch first 5 rows only";
		try {
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setInt(1, (index-1)*5);
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new KetQua(
						rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getInt(4),
						rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),
						rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getInt(12)
						));
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;}
	
		public List<KetQuaTinh> getPadingKQT(int index){
			List<KetQuaTinh> list=new ArrayList<>();
			String query="SELECT * from KetQua INNER JOIN Tinh on KetQua.MaTinh=Tinh.MaTinh\r\n"
					+ "order by KetQua.MaVe\r\n"
					+ "offset ? rows\r\n"
					+ "fetch first 5 rows only";
			try {
				conn=new DBContext().getConnection();
				ps=conn.prepareStatement(query);
				ps.setInt(1, (index-1)*5);
				rs=ps.executeQuery();
				while(rs.next()) {
					list.add(new KetQuaTinh(
							rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getInt(4),
							rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),
							rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getInt(12),
							rs.getString(13),rs.getString(14),rs.getString(15)
							));
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		return list;
	}
		public List<KetQuaTinh> getPadingKqMB(String s,int index){
			List<KetQuaTinh> list=new ArrayList<>();
			String query="select * from ketqua k join tinh t on k.MaTinh=t.MaTinh\r\n"
					+ "where Mien=?\r\n"
					+ "order by k.MaVe\r\n"
					+ "offset ? rows\r\n"
					+ "fetch first 5 rows only";
			try {
				conn=new DBContext().getConnection();
				ps=conn.prepareStatement(query);
				ps.setString(1, s);
				ps.setInt(2, (index-1)*5);
				rs=ps.executeQuery();
				while(rs.next()) {
					list.add(new KetQuaTinh(
							rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getInt(4),
							rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),
							rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getInt(12),
							rs.getString(13),rs.getString(14),rs.getString(15)
							));
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		return list;
	}
	public List<TaiKhoan> getPadingUser(int index){
		List<TaiKhoan> list=new ArrayList<>();
		String query="select * from TaiKhoanDK\r\n"
				+ "order by MaUser\r\n"
				+ "offset ? rows\r\n"
				+ "fetch first 5 rows only";
		try {
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setInt(1, (index-1)*5);
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new TaiKhoan(
						rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getString(7)
						));
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
		
	}
	
	
	
	public void getId(String id) {
		String query="delete from KetQua\r\n"
				+ "where MaVe=?";
		try {
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
				
	}
	public TaiKhoan getIdUser(String id) {
		String query="select * from TaiKhoanDK where MaUser=?";
		try {
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setString(1, id);
		rs=	ps.executeQuery();
			while(rs.next()) {
				return new TaiKhoan(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;	
	
				
	}
	public KetQua getIdKq(String id) {
		String query="select * from KetQua where MaVe=?";
		try {
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setString(1, id);
		rs=	ps.executeQuery();
			while(rs.next()) {
				return new KetQua(
						rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getInt(4),
						rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),
						rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getInt(12)
						);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;	
	
				
	}
	public void insert(String MaTinh,String ngay,String GiaiTam,String GiaiBay,String GiaiSau,String GiaiNam,String GiaiBon,
	String GiaiBa,String GiaiHai,String GiaiMot,String GiaiDB) {
		String query="insert into KetQua values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setString(1, MaTinh);
			ps.setString(2, ngay);
			ps.setString(3, GiaiTam);
			ps.setString(4, GiaiBay);
			ps.setString(5, GiaiSau);
			ps.setString(6, GiaiNam);
			ps.setString(7, GiaiBon);
			ps.setString(8, GiaiBa);
			ps.setString(9, GiaiHai);
			ps.setString(10, GiaiMot);
			ps.setString(11, GiaiDB);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void insertTinh(String MaTinh,String tenTinh,String Mien) {
				String query="insert into tinh values(?,?,?)";
				try {
					conn=new DBContext().getConnection();
					ps=conn.prepareStatement(query);
					ps.setString(1, MaTinh);
					ps.setString(2, tenTinh);
					ps.setString(3, Mien);
					
					ps.executeUpdate();
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
	public void insertTaiKhoan(String taiKhoanKH,String matKhau,String hoten,String diachi,String sdt,String ad) {
				String query="insert into TaiKhoanDK values(\r\n"
						+ "?,?,?,?,?,?)";
				try {
					conn=new DBContext().getConnection();
					ps=conn.prepareStatement(query);
					ps.setString(1, taiKhoanKH);
					ps.setString(2, matKhau);
					ps.setString(3, "N"+hoten+"");
					ps.setString(4, diachi);
					ps.setString(5, sdt);
					ps.setString(6, ad);
					
					ps.executeUpdate();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	public void insertKQSearch(String maUser,String ngay,String tinh,String SoDo,String kq) {
				String query="insert into LichSuDoVe values(?,?,?,?,?)";
				try {
					conn=new DBContext().getConnection();
					ps=conn.prepareStatement(query);
					ps.setString(1, maUser);
					ps.setString(2, ngay);
					ps.setString(3, tinh);
					ps.setString(4, SoDo);
					ps.setString(5, kq);
					
					ps.executeUpdate();
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
	public void edit(String MaTinh,String ngay,String GiaiTam,String GiaiBay,String GiaiSau,String GiaiNam,String GiaiBon,
	String GiaiBa,String GiaiHai,String GiaiMot,String GiaiDB,String id) {
		String query="update KetQua set MaTinh=?,\r\n"
				+ "ngay =?,\r\n"
				+ "GiaiTam = ? , GiaiBay = ? , GiaiSau =? , GiaiNam=?,\r\n"
				+ "GiaiBon=?,GiaiBa=?, GiaiHai=?,GiaiNhat=?,GiaiDacBiet=?\r\n"
				+ "where MaVe=? ";
		try {
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setString(1, MaTinh);
			ps.setString(2, ngay);
			ps.setString(3, GiaiTam);
			ps.setString(4, GiaiBay);
			ps.setString(5, GiaiSau);
			ps.setString(6, GiaiNam);
			ps.setString(7, GiaiBon);
			ps.setString(8, GiaiBa);
			ps.setString(9, GiaiHai);
			ps.setString(10, GiaiMot);
			ps.setString(11, GiaiDB);
			ps.setString(12, id);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List<KetQua> search(String s) {
		List<KetQua> list=new ArrayList<>();
				String query="SELECT * from KetQua\r\n"
						+ "where giaitam like ? or giaibay like ? or\r\n"
						+ " GiaiSau like ? or\r\n"
						+ "  GiaiNam like ? or\r\n"
						+ "   GiaiBon like ? or\r\n"
						+ "    GiaiBa like ? or\r\n"
						+ "	GiaiHai like ? or\r\n"
						+ "	GiaiNhat like ? or\r\n"
						+ "	GiaiDacBiet like ? ";

				try {
					conn=new DBContext().getConnection();
					ps=conn.prepareStatement(query);
				
					ps.setString(1,"%" + s + "%");
					ps.setString(2,"%" + s + "%");
					ps.setString(3,"%" + s + "%");
					ps.setString(4,"%" + s + "%");
					ps.setString(5,"%" + s + "%");
					ps.setString(6,"%" + s + "%");
					ps.setString(7,"%" + s + "%");
					ps.setString(8,"%" + s + "%");
					ps.setString(9,"%" + s + "%");
					
					rs = ps.executeQuery();
					while(rs.next()) {
						list.add(new KetQua(
								rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getInt(4),
								rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),
								rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getInt(12)
								)); }
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				return list;
			}
	public KetQuaTinh searchIn(String s,String ngay,String tinh) {
		//List<KetQua> list=new ArrayList<>();
		String query="SELECT * from KetQua INNER JOIN Tinh on KetQua.MaTinh=Tinh.MaTinh where ngay=? and Tinh.TenTinh like ? and GiaiTam like ?\r\n"
						+ "or ngay=? and Tinh.TenTinh like ? and GiaiBay like ?\r\n"
						+ "or ngay=? and Tinh.TenTinh like ? and GiaiSau like ?\r\n"
						+ "or ngay=? and Tinh.TenTinh like ? and GiaiNam like ?\r\n"
						+ "or ngay=? and Tinh.TenTinh like ? and GiaiBon like ?\r\n"
						+ "or ngay=? and Tinh.TenTinh like ? and GiaiBa like ?\r\n"
						+ "or ngay=? and Tinh.TenTinh like ? and GiaiHai like ?\r\n"
						+ "or ngay=? and Tinh.TenTinh like ? and GiaiNhat like ?\r\n"
						+ "or ngay=? and Tinh.TenTinh like ? and GiaiDacBiet like ?";

				try {
					conn=new DBContext().getConnection();
					ps=conn.prepareStatement(query);
				
					ps.setString(1,ngay); ps.setString(2, "%" + tinh + "%" );ps.setString(3,"%" + s + "%");
					ps.setString(4,ngay); ps.setString(5,"%" + tinh + "%" );ps.setString(6,"%" + s + "%");
					ps.setString(7,ngay); ps.setString(8,"%" + tinh + "%" );ps.setString(9,"%" + s + "%");
					ps.setString(10,ngay);ps.setString(11,"%" + tinh + "%" );ps.setString(12,"%" + s + "%");
					ps.setString(13,ngay);ps.setString(14,"%" + tinh + "%" );ps.setString(15,"%" + s + "%");
					ps.setString(16,ngay);ps.setString(17,"%" + tinh + "%" );ps.setString(18,"%" + s + "%");
					ps.setString(19,ngay);ps.setString(20,"%" + tinh + "%" );ps.setString(21,"%" + s + "%");
					ps.setString(22,ngay);ps.setString(23,"%" + tinh + "%" );ps.setString(24,"%" + s + "%");
					ps.setString(25,ngay);ps.setString(26,"%" + tinh + "%" );ps.setString(27,"%" + s + "%");
					
					
					rs = ps.executeQuery();
					while(rs.next()) {
					return	new KetQuaTinh(
								rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getInt(4),
								rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),
								rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getInt(12),
								rs.getString(13),rs.getString(14),rs.getString(15)
								);
						
//					return	new KetQua(
//								rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getInt(4),
//								rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),
//								rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getInt(12)
//								); 
					}
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				return null;
			}
	public KetQua searchVe(String s) {
		//List<KetQua> list=new ArrayList<>();
				String query="SELECT * from KetQua\r\n"
						+ "where giaitam like ? or giaibay like ? or\r\n"
						+ " GiaiSau like ? or\r\n"
						+ "  GiaiNam like ? or\r\n"
						+ "   GiaiBon like ? or\r\n"
						+ "    GiaiBa like ? or\r\n"
						+ "	GiaiHai like ? or\r\n"
						+ "	GiaiNhat like ? or\r\n"
						+ "	GiaiDacBiet like ? ";

				try {
					conn=new DBContext().getConnection();
					ps=conn.prepareStatement(query);
				
					ps.setString(1,"%" + s + "%");
					ps.setString(2,"%" + s + "%");
					ps.setString(3,"%" + s + "%");
					ps.setString(4,"%" + s + "%");
					ps.setString(5,"%" + s + "%");
					ps.setString(6,"%" + s + "%");
					ps.setString(7,"%" + s + "%");
					ps.setString(8,"%" + s + "%");
					ps.setString(9,"%" + s + "%");
					
					rs = ps.executeQuery();
					while(rs.next()) {
						new KetQua(
								rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getInt(4),
								rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),
								rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getInt(12)
								); }
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				return null;
			}
	public KetQua searchNgay(String s) {
		//List<KetQua> list=new ArrayList<>();
				String query="select * from KetQua where ngay=?";

				try {
					conn=new DBContext().getConnection();
					ps=conn.prepareStatement(query);
				
					ps.setString(1,s );
					rs = ps.executeQuery();
					while(rs.next()) {
						new KetQua(
								rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getInt(4),
								rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),
								rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getInt(12)
								); }
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				return null;
			}
	public KetQua searchTinh(String s) {
		//List<KetQua> list=new ArrayList<>();
				String query="select * from KetQua where MaTinh=?";

				try {
					conn=new DBContext().getConnection();
					ps=conn.prepareStatement(query);
				
					ps.setString(1,s );
					rs = ps.executeQuery();
					while(rs.next()) {
						new KetQua(
								rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getInt(4),
								rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),
								rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getInt(12)
								); }
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				return null;
			}
	
	public List<TaiKhoan> searchUser(String s) {
		List<TaiKhoan> list=new ArrayList<>();
				String query="select * from TaiKhoanDK\r\n"
						+ "where Hoten like ?\r\n"
						+ "or SDT like ?";

				try {
					conn=new DBContext().getConnection();
					ps=conn.prepareStatement(query);
				
					ps.setString(1,"%" + s + "%");
					ps.setString(2,"%" + s + "%");
					
					
					rs = ps.executeQuery();
					while(rs.next()) {
						list.add(new TaiKhoan(
								rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
								rs.getString(5),rs.getString(6)
								)); }
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				return list;
			}
	
	
	public void deleteAll(String[] checked) {
		for(int i=0;i< checked.length;i++) {
		String query="delete from KetQua\r\n"
				+ "where MaVe=?";
		try {
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			
			ps.setNString(1, checked[i]);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
		}
	}
	public void deleteHistory(String[] checked) {
		for(int i=0;i< checked.length;i++) {
		String query="delete from LichSuDoVe where MaVeDaDo=?";
		try {
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			
			ps.setNString(1, checked[i]);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
		}
	}
	public void deleListUser(String[] checked) {
		for(int i=0;i< checked.length;i++) {
		String query="delete from TaiKhoanDK where MaUser=?";
		try {
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			
			ps.setString(1, checked[i]);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
		}
	}
	public void deleteUser(String checked) {
		
		String query="delete from TaiKhoanDK where MaUser=?";
		try {
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			
			ps.setString(1, checked);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
		
	}
public void UpdateUser(String hoTen,String Diachi,String sdt,String id,String ad) {
		
		String query=" update TaiKhoanDK set Hoten=?,\r\n"
				+ "  DiaChi=?,\r\n"
				+ "  SDT=?,\r\n"
				+ "  isAdmin =?\r\n"
				+ "  where MaUser=?";
		try {
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			
			ps.setString(1, hoTen);
			ps.setString(2, Diachi);
			ps.setString(3, sdt);
			ps.setString(4, ad);
			ps.setString(5, id);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
		
	}

public void UpdateIsAdmin(String tk,String ad) {
	
	String query="update TaiKhoanDK set isAdmin = ? where TaiKhoanKH=?";
	try {
		conn=new DBContext().getConnection();
		ps=conn.prepareStatement(query);
		
		ps.setString(1, ad);
		ps.setString(2, tk);
	
		ps.executeUpdate();
		
	} catch (Exception e) {
		// TODO: handle exception
	}		
	
}
public int checkIsAdmin(String id) {
	int in = 0;
	String query="select isAdmin from TaiKhoanDK where MaUser=?";
	try {
		conn=new DBContext().getConnection();
		ps=conn.prepareStatement(query);
		
		ps.setString(1, id);
	
		rs=ps.executeQuery();
		while(rs.next()) {
		 in= rs.getInt(1);}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return in;	

}
public int checkIsAdmin2(String id) {
	int in = 0;
	String query="select isAdmin from TaiKhoanDK where TaiKhoanKH =?";
	try {
		conn=new DBContext().getConnection();
		ps=conn.prepareStatement(query);
		
		ps.setString(1, id);
	
		rs=ps.executeQuery();
		while(rs.next()) {
		 in= rs.getInt(1);}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return in;	

}



public void UpdatePassUser(String tk,String mk) {
	
	String query="Update TaiKhoanDK set MatKhau=? where TaiKhoanKH=?";
	try {
		conn=new DBContext().getConnection();
		ps=conn.prepareStatement(query);
		
		ps.setString(1, mk);
		ps.setString(2, tk);
		
		ps.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();
	}		
	
}
	
	public List<TaiKhoan> getAllUser(){
		List<TaiKhoan> list=new ArrayList<>();
		String query="select * from TaiKhoanDK";
		try {
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new TaiKhoan(
						rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getString(7)
						));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}

	public List<Tinh> getTinh() {
		List<Tinh> list=new ArrayList<>();
		String query="select * from Tinh";
		try {
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new Tinh(
						rs.getString(1),rs.getString(2),rs.getString(3)
						));

				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	
	public int getNumPage() {
		String query="select count(*) from KetQua";
		try {
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				int total=rs.getInt(1);
				int count=0;
				count=total/5;
				
				if(total%5 != 0 ) {
					count++;
				}
				return count;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	return 0;
	}
	public int getNumPageUser() {
		String query="select count(*) from TaiKhoanDK";
		try {
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				int total=rs.getInt(1);
				int count=0;
				count=total/5;
				
				if(total%5 != 0 ) {
					count++;
				}
				return count;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	return 0;
	}
	public int getNumPageHistory() {
		String query="select count(*) from LichSuDoVe";
		try {
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				int total=rs.getInt(1);
				int count=0;
				count=total/5;
				
				if(total%5 != 0 ) {
					count++;
				}
				return count;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	return 0;
	}
	
	public static String getMd5(String input) 
    { 
        try { 
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    }
	
	
	public TaiKhoan  login(String user,String pass) {
		String query="select * from TaiKhoanDK where TaiKhoanKH =? and MatKhau=?";
		try {
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
		rs=	ps.executeQuery();
			while(rs.next()) {
				return new TaiKhoan(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;	
	
	}
	public TaiKhoan  loginAdmin(String user,String pass) {
		String query="select * from TaiKhoanDK where TaiKhoanKH =? and MatKhau=? and isAdmin=1";
		try {
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
		rs=	ps.executeQuery();
			while(rs.next()) {
				return new TaiKhoan(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;	
	
	}
	
	public TaiKhoan  checkTkIsEmty(String user) {
		String query="select * from TaiKhoanDK where TaiKhoanKH =? ";
		try {
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setString(1, user);
	
		rs=	ps.executeQuery();
			while(rs.next()) {
				return new TaiKhoan(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;	
	
	}
	public TaiKhoan  checkMkIsEmty(String pass) {
		String query="select * from TaiKhoanDK where MatKhau=? ";
		try {
			conn=new DBContext().getConnection();
			ps=conn.prepareStatement(query);
			ps.setString(1, pass);
	
		rs=	ps.executeQuery();
			while(rs.next()) {
				return new TaiKhoan(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;	
	
	}
	
	public List<SaveSearch> history(String id,int index) {
		List<SaveSearch> list=new ArrayList<>();
				String query="select * from LichSuDoVe where MaUser=?\r\n"
						+ "order by MaVeDaDo\r\n"
						+ "offset ? rows\r\n"
						+ "fetch first 5 rows only";

				try {
					conn=new DBContext().getConnection();
					ps=conn.prepareStatement(query);
					ps.setString(1, id);
					
					ps.setInt(2, (index-1)*5);
					rs=ps.executeQuery();
					while(rs.next()) {
						list.add(new SaveSearch(
								rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getString(4),rs.getInt(5),rs.getInt(6)
								));}
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				return list;}
}
