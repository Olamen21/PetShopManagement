package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.Customer;
import entity.User;

/**
 * Servlet implementation class UpdateUserControl
 */
@WebServlet("/updateUser")
public class UpdateUserControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		DAO dao = new DAO();
		User u = dao.getUserById(id);
		request.setAttribute("u", u);
		request.getRequestDispatcher("UserUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		DAO dao = new DAO();
		dao.updateUser(uid, uname, pass);
		response.sendRedirect("userControl");
	}

}
