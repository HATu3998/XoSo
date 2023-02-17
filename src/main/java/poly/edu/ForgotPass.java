package poly.edu;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.TaiKhoan;
import XoSoDAO.DAO;

/**
 * Servlet implementation class ForgotPass
 */
@WebServlet("/ForgotPass")
public class ForgotPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPass() {
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
		final String username="naganmei3997@gmail.com";
		final String password="efuhbykphntjkkbo";
		Properties prop =new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable","true");
		Session session = Session.getInstance(prop,new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
				return new javax.mail.PasswordAuthentication(username, password);
			}
		}); 
		//dang nhap email
		//String emailTo="sikigami2255@gmail.com";
		String emailTo=request.getParameter("tk");
		DAO dao=new DAO();
		String matkhau=dao.randomAlphaNumeric(8);
		String mkMD5=dao.getMd5(matkhau);
		String emailSubject="Thay đổi mật khẩu";
		String emailContent="Mật khẩu được đổi của bạn là: "+ matkhau;
		TaiKhoan a=dao.checkTkIsEmty(emailTo);
		
		if(a==null) {
			request.setAttribute("mess", "tài khoản không tồn tại");
			request.getRequestDispatcher("ForgotPass.jsp").forward(request, response);
		}else {
		dao.UpdatePassUser(emailTo, mkMD5);
		try {
			Message message=new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
			
			message.setSubject(emailSubject);
			message.setText(emailContent);
			Transport.send(message);
			System.out.print("Done");
			request.setAttribute("mess", "mật khẩu đã gửi vào email của bạn");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}
		}
	}

}
