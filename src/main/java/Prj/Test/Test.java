package Prj.Test;

import java.util.List;

import Model.KetQua;
import Model.TaiKhoan;
import XoSoDAO.DAO;
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
	    System.out.print("Input password: ");
	    Scanner kb = new Scanner(System.in);
	    String pass = kb.nextLine();
	    DAO dao=new DAO();
	    System.out.println("Your Password generated by MD5 is: " + dao.getMd5(pass));
	    kb.close();
	  }
	  
	}