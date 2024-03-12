package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.Customer;

/**
 * Servlet implementation class UpdateCustomerControl
 */
@WebServlet("/updateCustomer")
public class UpdateCustomerControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("cid");
		DAO custDao = new DAO();
		Customer c = custDao.getCustomerById(id);
		request.setAttribute("ctm", c);
		request.getRequestDispatcher("CustomerUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		String cname = request.getParameter("cname");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		DAO custDao = new DAO();
		custDao.updateCustomer(cid, cname, address, phone);
		response.sendRedirect("CustomerControl");
		
	}


}
