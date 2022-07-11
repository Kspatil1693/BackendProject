package ClassServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbcServletConnection.DBConnection;

/**
 * Servlet implementation class teacherlist
 */
@WebServlet("/teacherlist")
public class teacherlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teacherlist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		DBConnection dbconnection= new DBConnection();
		Connection connection=dbconnection.getConnection();
	
	//step 3: Create Statement object
		try {
			
			Statement stmt=connection.createStatement();
			
			//step4:Execute query
			ResultSet rs= stmt.executeQuery("select * from data1.teachers");
			
			PrintWriter out=response.getWriter();
			out.println("<html><body>");
			out.println("<h2>This table show the all details about Teachers</h2>");
			out.println("</br>");
			out.println("<table><tr> <th>FirstName</th> <th>LastName</th> <th>Age</th></tr></table>");
			
			
			while(rs.next())
			{
		   String FirstName=rs.getString("FirstName");
		   String LastName=rs.getString("LastName");
			Integer Age =rs.getInt("Age");
			
		
			
			out.println(FirstName+" ");
			out.println(LastName+"");
			out.println(Age+"");
			
			out.println("</br>");
			}
			out.println("</body></html>");
			//step 5: closing connection query
			stmt.close();
			connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
