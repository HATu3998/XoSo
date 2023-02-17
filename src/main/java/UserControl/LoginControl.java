package UserControl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.TaiKhoan;
import XoSoDAO.DAO;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet("/login")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControl() {
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
	String user=request.getParameter("username");
	String pass=request.getParameter("password");
	DAO dao=new DAO();
	String passMD5=dao.getMd5(pass);
	TaiKhoan a=dao.login(user, passMD5);
	TaiKhoan b=dao.loginAdmin(user,passMD5);
	if(a==null) { //tk ko đúng
		request.setAttribute("mess", "nhap sai Tai Khoan hoac Mat khau");
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}
	else { //tk đúng, check xem có phải admin ko
		HttpSession session =request.getSession();
		
		
		if(b==null) {
			session.setAttribute("acc", a);
			request.getRequestDispatcher("PagingIndex").forward(request, response);
		}else {
			session.setAttribute("accAdmin", b);
		request.getRequestDispatcher("adminPage.jsp").forward(request, response);}
	}
	}

}
