package display;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.SaveSearch;
import Model.Tinh;
import XoSoDAO.DAO;

/**
 * Servlet implementation class history
 */
@WebServlet("/history")
public class history extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public history() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String index=request.getParameter("index");
		String id=request.getParameter("id");
		if(index==null) {
			index="1";
		}
		int indexPage=Integer.parseInt(index);
		
		DAO dao=new DAO();
		List<SaveSearch> list=dao.history(id,indexPage);
		request.setAttribute("inde", indexPage);
		request.setAttribute("listPage", list);
		request.getRequestDispatcher("History.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
