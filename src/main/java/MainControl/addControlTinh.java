package MainControl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Validate;
import XoSoDAO.DAO;

/**
 * Servlet implementation class addControlTinh
 */
@WebServlet("/addControlTinh")
public class addControlTinh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addControlTinh() {
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
		String matinh=request.getParameter("matinh");
		String tentinh=request.getParameter("tentinh");
		String mien=request.getParameter("tinh");
		
		Validate val=new Validate();

			DAO dao=new DAO();
			dao.insertTinh(matinh, tentinh, mien);
			response.sendRedirect("PagingControl");
			
			
	
	}
}
