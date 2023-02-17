package UserControl;

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
import XoSoDAO.DAO;

/**
 * Servlet implementation class PangdingUser
 */
@WebServlet("/PangdingUser")
public class PangdingUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PangdingUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String index=request.getParameter("index");
		if(index==null) {
			index="1";
		}
		int indexPage=Integer.parseInt(index);
		DAO dao=new DAO();
		List<TaiKhoan> listTK=dao.getAllUser();
		request.setAttribute("listKQ", listTK);
		
	List<TaiKhoan> list=dao.getPadingUser(indexPage);
	request.setAttribute("listPage", list);
	request.setAttribute("inde", indexPage);
	request.getRequestDispatcher("ad-user.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
