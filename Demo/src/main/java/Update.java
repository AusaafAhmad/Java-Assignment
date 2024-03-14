
import java.sql.SQLException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Enumeration;
import jakarta.servlet.http.HttpSession;
import database.Getval;
import database.SetCity;
/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getAttribute("city"));
		HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user_val");
        String name = (String) session.getAttribute("name_val");
        
        request.setAttribute("user", user);
        request.setAttribute("name", name);
        RequestDispatcher rd = request.getRequestDispatcher("/updateCity.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user_val");
        String newcity = request.getParameter("city");
        try {
        	SetCity.setnew(user, newcity);
        	String[] val = Getval.getinfo(user);
        	request.setAttribute("name", val[0]);
        	request.setAttribute("city",val[1] );
        	request.setAttribute("user",val[2] );
            RequestDispatcher rd = request.getRequestDispatcher("/Profile.jsp");
            rd.forward(request, response);
		} catch(SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }
    	
        
	}

}
