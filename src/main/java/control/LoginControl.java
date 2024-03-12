package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.User;

@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String user = request.getParameter("your_name");
			String pass = request.getParameter("your_pass");
			DAO dao = new DAO();
			User u = dao.checkLogin(user, pass);
			if(u==null) {
				response.sendRedirect("login.jsp");
			}else {
				response.sendRedirect("CustomerControl");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
