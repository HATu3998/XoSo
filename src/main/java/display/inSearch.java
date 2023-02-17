package display;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.KetQua;
import Model.KetQuaTinh;
import XoSoDAO.DAO;

/**
 * Servlet implementation class inSearch
 */
@WebServlet("/inSearch")
public class inSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String ngay=request.getParameter("ngay");
		String veso=request.getParameter("veso");
		String tinh=request.getParameter("tinh");
		String maU=request.getParameter("maUse");
		
		
		DAO dao=new DAO();
		KetQuaTinh list=dao.searchIn(veso, ngay, tinh);
		if(list==null) {
			dao.insertKQSearch(maU, ngay,tinh, veso,"0");
			request.setAttribute("error", "ko tìm thấy kq");
			
			request.getRequestDispatcher("display.jsp").forward(request, response);
		}else if(list !=null) {
			dao.insertKQSearch(maU, ngay,tinh, veso,"1");
			request.setAttribute("listPage", list);
			
			request.getRequestDispatcher("display.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String ngay=request.getParameter("ngay");
		String veso=request.getParameter("veso");
		String tinh=request.getParameter("tinh");
		
		DAO dao=new DAO();
		//List<KetQua> list=dao.searchIn(veso, ngay, tinh);
		KetQuaTinh list=dao.searchIn(veso, ngay, tinh);
		if(list==null) {
			
			request.setAttribute("error", "ko tìm thấy kq");
			
			request.getRequestDispatcher("display.jsp").forward(request, response);
		}else if(list !=null) {
			request.setAttribute("error", "chúc mừng trúng giải");
			request.setAttribute("listPage", list);
			
			request.getRequestDispatcher("display.jsp").forward(request, response);
		}
		
		
		}
		
	
	}


