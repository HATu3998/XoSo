package UserControl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.TaiKhoan;
import Model.Validate;
import XoSoDAO.DAO;

/**
 * Servlet implementation class Resister
 */
@WebServlet("/Resister")
public class Resister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Resister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		    DAO dao=new DAO();
			String tk1=request.getParameter("tk");
			String mk1=request.getParameter("mk");
			String ht1=request.getParameter("ht");
			String dc1=request.getParameter("dc");
			String sdt1=request.getParameter("sdt");
			String isUser=request.getParameter("isUser");
			TaiKhoan a=dao.checkTkIsEmty(tk1);
			
			String md5Mk=dao.getMd5(mk1);
			
			if(a==null) {
				try {
					
					dao.insertTaiKhoan(tk1, md5Mk, ht1, dc1, sdt1,isUser);
					String s= "đăng ký thành công";
					request.setAttribute("mess", s);
					request.getRequestDispatcher("Login.jsp").forward(request, response);
			
	
		
	} catch (Exception e) {
			
				e.printStackTrace();
				String s= "đăng kí không thành công";
				request.setAttribute("error", s);
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			}else {
				String s= "username already exists";
				request.setAttribute("error", s);
				request.getRequestDispatcher("Register .jsp").forward(request, response);
	
	}
	}
}
