package UserControl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import XoSoDAO.DAO;

/**
 * Servlet implementation class UpdateUserAdmin
 */
@WebServlet("/UpdateUserAdmin")
public class UpdateUserAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserAdmin() {
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
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("sid");
		String tkh=request.getParameter("stk");
		String hoten=request.getParameter("shoten");
		String diachi=request.getParameter("sdiachi");
		String sdt=request.getParameter("sSdt");
		String ad=request.getParameter("ad");
		
		
		DAO dao=new DAO();
		
		if(ad.equals("0")) {
			String er="không thể cập nhật admin thành tài khoản khách ";
			
			request.setAttribute("error", er);
			request.getRequestDispatcher("error.jsp").forward(request, response);
		} else {
			dao.UpdateUser(hoten, diachi, sdt, id,ad);
			String er="cập nhật thành công";
			request.setAttribute("error", er);
			response.sendRedirect("PangdingUser");
		}
	}

}
