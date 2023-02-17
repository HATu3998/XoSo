package UserControl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.TaiKhoan;
import XoSoDAO.DAO;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String s=request.getParameter("sMaVe");
		String tkh=request.getParameter("stk");
		DAO dao=new DAO();
		int check=dao.checkIsAdmin2(tkh);
		TaiKhoan t=dao.getIdUser(s);
		request.setAttribute("updat", t);
		if(check==0) {
		request.getRequestDispatcher("UpdateUser.jsp").forward(request, response);}
		else	{
		request.getRequestDispatcher("UpdateUserAdmin.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("sid");
		String tkh=request.getParameter("stk");
		String hoten=request.getParameter("shoten");
		String diachi=request.getParameter("sdiachi");
		String sdt=request.getParameter("sSdt");
		String ad=request.getParameter("ad");
		
		
		DAO dao=new DAO();
		dao.UpdateUser(hoten, diachi, sdt, id,ad);
		String err="cập nhật thành công";
		request.setAttribute("error", err);
		response.sendRedirect("PangdingUser");
		
		
//		int check=dao.checkIsAdmin2(tkh);
//		if(ad.equals("1")) {
//		if(check==1) {
//			if(ad.equals("1")) {
//			String er="không thể cập nhật admin thành tài khoản khách ";
//						
//						request.setAttribute("error", er);
//						request.getRequestDispatcher("error.jsp").forward(request, response);}
//			else if(ad.equals("0")) {
//				dao.UpdateUser(hoten, diachi, sdt, id,ad);
//				String er="cập nhật thành công";
//				request.setAttribute("error", er);
//				response.sendRedirect("PangdingUser");
//				}
//					}	else if(check==0) {
//						dao.UpdateUser(hoten, diachi, sdt, id,ad);
//						String er="cập nhật thành công";
//						request.setAttribute("error", er);
//						response.sendRedirect("PangdingUser");
//						}
//		}else if(ad.equals("0")) {
//			if(check==1) {
//				String er="không thể cập nhật admin thành tài khoản khách 2";
//							
//							request.setAttribute("error", er);
//							request.getRequestDispatcher("error.jsp").forward(request, response);
//						}	else if(check==0) {
//							dao.UpdateUser(hoten, diachi, sdt, id,ad);
//							String er="cập nhật thành công";
//							request.setAttribute("error", er);
//							response.sendRedirect("PangdingUser");
//							}
//		}
	}

}
