package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.Pet;
import entity.User;

/**
 * Servlet implementation class UpdatePet
 */
@WebServlet("/updatePet")
public class UpdatePet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		DAO dao = new DAO();
		Pet p = dao.getPetById(id);
		request.setAttribute("p", p);
		request.getRequestDispatcher("PetUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("pid");
		String pname = request.getParameter("pname");
		String pcate = request.getParameter("pcate");
		String price = request.getParameter("price");
		DAO dao = new DAO();
		dao.updatePet(id, pname, pcate, price);
		response.sendRedirect("petControl");
	}

}
