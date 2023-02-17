package UserControl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import XoSoDAO.DAO;

/**
 * Servlet implementation class isAdmin
 */
@WebServlet("/isAdmin")
public class isAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public isAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tkh=request.getParameter("tk");
		String ad=request.getParameter("ad");
		
		DAO dao=new DAO();
		int check=dao.checkIsAdmin2(tkh);
		
		if(check==1) {
      String er="không thể cập nhật admin thành tài khoản khách";
			
			request.setAttribute("error", er);
			request.getRequestDispatcher("error.jsp").forward(request, response);
			
		}	else if(check==0) {
			dao.UpdateIsAdmin(tkh,ad);
			String er="cập nhật thành công";
			request.setAttribute("error", er);
			response.sendRedirect("PangdingUser");
			}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
