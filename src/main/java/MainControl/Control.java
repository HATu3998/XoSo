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
 * Servlet implementation class Control
 */
@WebServlet("/control")
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Control() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao=new DAO();
		
//		String pageIdStr=request.getParameter("pageid");
//		int count = 7;
//		int pageid=Integer.parseInt(pageIdStr);
//		if(pageid==1) {}
//		else {
//			pageid= pageid-1;
//			pageid=pageid * count + 1;
//		}
		//List<KetQua> list=dao.getAllKetQua(pageid-1,count);
	
		List<KetQua> list=dao.getAllKetQua();
		request.setAttribute("listKQ", list); //đẩy list lên listSP

		//request.setAttribute("numPage",Integer.parseInt(pageIdStr));
		request.getRequestDispatcher("ad.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
