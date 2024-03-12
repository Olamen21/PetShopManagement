package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.Pet;


@WebServlet("/petControl")
public class PetControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PetControl() {
        super();
       
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
        DAO dao = new DAO();
		List<Pet> list = dao.getAllPet();
        
        //b2: set data to jsp
        request.setAttribute("listP", list);
        request.getRequestDispatcher("pet.jsp").forward(request, response);
        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
