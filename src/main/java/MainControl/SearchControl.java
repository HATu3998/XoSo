package MainControl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.KetQua;
import XoSoDAO.DAO;

/**
 * Servlet implementation class SearchControl
 */
@WebServlet(name = "SearchControll", urlPatterns = { "/search" })
public class SearchControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s=request.getParameter("txt");
		DAO dao=new DAO();
		List<KetQua> list=dao.search(s);
		if(list==null) {
			String st="Không tìm thấy kết quả";
			request.setAttribute("error", st);
			request.setAttribute("listPage", list);
			request.getRequestDispatcher("Search.jsp").forward(request, response);
		}else {
			
			request.setAttribute("listPage", list);
			request.getRequestDispatcher("Search.jsp").forward(request, response);
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
