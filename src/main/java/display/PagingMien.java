package display;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.KetQuaTinh;
import Model.Tinh;
import XoSoDAO.DAO;

/**
 * Servlet implementation class PagingMien
 */
@WebServlet("/PagingMien")
public class PagingMien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagingMien() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String index=request.getParameter("index");
		String s=request.getParameter("mien");
		if(index==null) {
			index="1";
		}
		int indexPage=Integer.parseInt(index);
		DAO dao=new DAO();
	List<KetQuaTinh> list=	dao.getPadingKqMB(s,indexPage);
	List<Tinh> listTinh=dao.getTinh();
	request.setAttribute("listTinh", listTinh);
	request.setAttribute("listPage", list);
	request.setAttribute("inde", indexPage);
	request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
