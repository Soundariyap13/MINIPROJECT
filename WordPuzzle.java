import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class WordPuzzle {
		String dbUrl="jdbc:mysql://localhost:3306/ngpdb";
		String dbUname="root";
		String dbPassword="";
		String dbDriver="com.mysql.cj.jdbc.Driver";
        String count,email;
        WordPuzzle(String count,String email){
        	this.count=count;
        	this.email=email;
        }
         void score(){
        	Connection con = null;
    		try {
    			Class.forName(dbDriver);  //class not found exception
    			con = DriverManager.getConnection(dbUrl,dbUname,dbPassword);
    			Statement s = con.createStatement();
    			String sql1 ="insert into student_table (Score)"
    					+ "values('"+count+"')"+"where Email='"+email+"'";
	    		s = con.createStatement();
	     		s.execute(sql1);
			   	con.close();
    		} catch (Exception e){
    			e.printStackTrace();
    		}
        }
}