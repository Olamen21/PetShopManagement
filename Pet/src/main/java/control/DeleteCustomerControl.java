package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;

/**
 * Servlet implementation class DeleteCustomerControl
 */
@WebServlet(name="deleteCustomer", urlPatterns = { "/deleteCustomer" })
public class DeleteCustomerControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   
    public DeleteCustomerControl() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get cid from jsp
		String id = request.getParameter("cid");
		DAO custDao = new DAO();
		custDao.deleteCustomer(id);
		response.sendRedirect("CustomerControl");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
