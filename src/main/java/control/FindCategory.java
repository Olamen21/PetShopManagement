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


@WebServlet("/findCategory")
public class FindCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FindCategory() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String find = request.getParameter("search");
	     DAO dao = new DAO();
		List<Category> list = dao.findCategory(find);
		request.setAttribute("list", list);
        request.getRequestDispatcher("FindCategory.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
