package UserControl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Validate;
import XoSoDAO.DAO;

/**
 * Servlet implementation class addUserControl
 */
@WebServlet("/addUser")
public class addUserControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addUserControl() {
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
		try {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");
		   
		   
			String tk1=request.getParameter("tk");
			String mk1=request.getParameter("mk");
			String ht1=request.getParameter("ht");
			String dc1=request.getParameter("dc");
			String sdt1=request.getParameter("sdt");
			String isUser=request.getParameter("isUser");
			

			String md5Mk=dao.getMd5(mk1);
			Validate val=new Validate();
	if(val.check(tk1)  ) {
				
		String s= "tài khoản không thể để trống";
		request.setAttribute("error", s);
		request.getRequestDispatcher("PangdingUser").forward(request, response);
	} else if(val.check(mk1)) {
		String s= "mk không thể để trống";
		request.setAttribute("error", s);
		request.getRequestDispatcher("PangdingUser").forward(request, response);
	}
	else if(val.check(ht1)) {
		String s= "ht không thể để trống";
		request.setAttribute("error", s);
		request.getRequestDispatcher("PangdingUser").forward(request, response);
	}
	else if(val.check(dc1)) {
		String s= "dc không thể để trống";
		request.setAttribute("error", s);
		request.getRequestDispatcher("PangdingUser").forward(request, response);
	}
	else if(val.check(sdt1)) {
		String s= "sdt không thể để trống";
		request.setAttribute("error", s);
		request.getRequestDispatcher("PangdingUser").forward(request, response);
	}
	else {
		
		
		dao.insertTaiKhoan(tk1, md5Mk, ht1, dc1, sdt1,isUser);
		response.sendRedirect("PangdingUser");
	}
					
	
		} catch (Exception e) {
			
			
		}
	}

}
