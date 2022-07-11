package jdbcServletConnection;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class DBConnection {
		private String url="jdbc:mysql://localhost:3306/data1";
		private String userId="root";
		private String password="Dgp@9019";
		
		private Connection connection;
		//private DriverManager DriverManage;
		
		public DBConnection()
		{
			try {
				//step1:Register Driver
				Class .forName("com.mysql.cj.jdbc.Driver");
				
				//step2:Get Connection Object
				this.connection=java.sql.DriverManager.getConnection(url,userId,password);
			}catch(ClassNotFoundException e)
			{
	         e.printStackTrace();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		public Connection getConnection()
		{
			return this.connection;
			
		}
}
