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
 * Servlet implementation class Subjectlist
 */
@WebServlet("/Subjectlist")
public class Subjectlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Subjectlist() {
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
			ResultSet rs= stmt.executeQuery("select * from data1.subjects");
			
			PrintWriter out=response.getWriter();
			out.println("<html><body>");
			out.println("<h2>This table show the all details about Subjects</h2>");
			out.println("</br>");
			out.println("<table><tr> <th>SubjecttName</th> <th>ShortCut</th></tr></table>");
			
			
			while(rs.next())
			{
			out.println("<table><tr><td>");
		   String SubjectName=rs.getString("SubjectName");
		   String ShortCut=rs.getString("ShortCut");
			
				
			
			out.println(SubjectName+"  ");
			out.println(ShortCut+" ");
					
			out.println("</br>");
			out.println("</tr></td></table>");
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
