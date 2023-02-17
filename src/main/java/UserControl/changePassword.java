package UserControl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.TaiKhoan;
import XoSoDAO.DAO;

/**
 * Servlet implementation class changePassword
 */
@WebServlet("/changePassword")
public class changePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tk=request.getParameter("tk");
		String mk=request.getParameter("mk");
		String mk2=request.getParameter("mk2");
		DAO dao=new DAO();
		String mkMD5=dao.getMd5(mk); //mk cũ
		String mk2MD5=dao.getMd5(mk2); //mk mới
		TaiKhoan a=dao.login(tk, mkMD5);
		TaiKhoan b=dao.checkMkIsEmty(mk2MD5);
		if(a==null) {
			request.setAttribute("mess", "tài khoản hoặc mật khẩu không đúng");
			request.getRequestDispatcher("changePassword.jsp").forward(request, response);
		}else {
			if(b==null) {
				dao.UpdatePassUser(tk, mk2MD5);
				request.setAttribute("mess", "tài khoản đổi mật khẩu thành công");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
			else {
				request.setAttribute("mess", "mật khẩu mới giống với mật khẩu cũ");
				request.getRequestDispatcher("changePassword.jsp").forward(request, response);
			}
		}
	}

}
