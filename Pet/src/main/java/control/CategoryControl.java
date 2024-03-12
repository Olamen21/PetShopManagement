package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.Category;


/**
 * Servlet implementation class Category
 */
@WebServlet("/categoryControl")
public class CategoryControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CategoryControl() {
        super();
       
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
        DAO dao = new DAO();
		List<Category> list = dao.getAllCategory();
        
        //b2: set data to jsp
        request.setAttribute("listC", list);
        request.getRequestDispatcher("category.jsp").forward(request, response);
        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
