package MainControl;

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
 * Servlet implementation class addControl
 */
@WebServlet("/add")
public class addControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		 response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		    
	String tinh=request.getParameter("tinh");
		String ngay=request.getParameter("ngay");
		String tam=request.getParameter("tam");
		String bay=request.getParameter("bay");
		String sau=request.getParameter("sau");
		String nam=request.getParameter("nam");
		String bon=request.getParameter("bon");
		String ba=request.getParameter("ba");
		String hai=request.getParameter("hai");
		String mot=request.getParameter("mot");
		String db=request.getParameter("db");
//		Validate val=new Validate();
//if( val.check(ngay) && val.check(tam) && val.check(bay) && val.check(sau) && val.check(nam) && val.check(bon)
//	&& val.check(ba) && val.check(hai) && val.check(mot) && val.check(db)) {
			DAO dao=new DAO();
			dao.insert(tinh, ngay, tam, bay, sau, nam, bon, ba, hai, mot, db);
			response.sendRedirect("PagingControl");
			

	
//} 
//else {
//	 out.print("thao tac khong thanh cong ");  
//     RequestDispatcher rd=request.getRequestDispatcher("error");  
//     rd.include(request,response);  
//}
				
out.close();  
	}
	}


