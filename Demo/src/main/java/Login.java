
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.SQLException;

import database.*;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("user");
		String pwd = request.getParameter("pass");
		String actpass =null;
		
		try {
		actpass = Dbconnect.getpassword(userId);
		
		if(actpass==null)
        {
        	response.setContentType("text/html");	
			out.println("!!!Wrong Username!!!");
			RequestDispatcher rd = request.getRequestDispatcher("/NewFile.html");
			rd.include(request, response);
        }
		if(pwd.equals(actpass)) {
			String[] val = Getval.getinfo(userId);
		    RequestDispatcher rd = request.getRequestDispatcher("/Profile.jsp");
		    	request.setAttribute("name", val[0]);
		    	request.setAttribute("city",val[1] );
		    	request.setAttribute("user",val[2] );
				rd.forward(request, response);
			} else {
				response.setContentType("text/html");
				out.println("Wrong Password!!!");
				RequestDispatcher rd = request.getRequestDispatcher("/NewFile.html");
				rd.include(request, response);
			}
		}
		 catch(SQLException|ClassNotFoundException e) {
	            e.printStackTrace();
	        }
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
