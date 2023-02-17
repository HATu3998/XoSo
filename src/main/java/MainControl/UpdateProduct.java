package MainControl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.KetQua;
import Model.TaiKhoan;
import Model.Tinh;
import Model.Validate;
import XoSoDAO.DAO;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/Update")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s=request.getParameter("sMaVe");
		DAO dao=new DAO();
		KetQua t=dao.getIdKq(s);
		request.setAttribute("updat", t);
		List<Tinh> list=dao.getTinh();
		request.setAttribute("listTinh", list); //đẩy list lên listSP
		request.getRequestDispatcher("UpdateKq.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("sMaVe");
		DAO dao=new DAO();
		
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
//	Validate val=new Validate();
//if(val.check(tinh) && val.check(ngay) && val.check(tam) && val.check(bay) && val.check(sau) && val.check(nam) && val.check(bon)
//	&& val.check(ba) && val.check(hai) && val.check(mot) && val.check(db)) {
	
		dao.edit(tinh, ngay, tam, bay, sau, nam, bon, ba, hai, mot, db, id);
		response.sendRedirect("PagingControl");
		


//} 
	}

}
