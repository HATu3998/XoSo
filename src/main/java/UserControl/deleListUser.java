package UserControl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import XoSoDAO.DAO;

/**
 * Servlet implementation class deleListUser
 */
@WebServlet("/deleListUser")
public class deleListUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleListUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] id = request.getParameterValues("sMaVe");
		
		DAO dao=new DAO();
		for(int i=0;i<id.length;i++) {
			int tk=dao.checkIsAdmin(id[i]);
			
			if(tk==1) {
				String er="không thể xóa admin";
			
				request.setAttribute("error", er);
				request.getRequestDispatcher("PangdingUser").forward(request, response);
				return;
				
			}
			else {
				dao.deleListUser(id);
				response.sendRedirect("PangdingUser");
				}
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
