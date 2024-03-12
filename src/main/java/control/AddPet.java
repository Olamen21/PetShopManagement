package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;


@WebServlet("/AddPet")
public class AddPet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddPet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("pname");
		String category = request.getParameter("pcate");
		String price = request.getParameter("price");
		DAO dao = new DAO();
		dao.insertPet(name, category, price);
		response.sendRedirect("petControl");
	}

}
