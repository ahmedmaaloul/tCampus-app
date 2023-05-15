
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*hi

*/
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        
       
   
        Connection connection = null;

        try {
            // Establish connection
            String url = "jdbc:mysql://localhost:3306/tcampus?zeroDateTimeBehavior=CONVERT_TO_NULL"; 
            String username = "root";
            String password = "root"; 
            connection = DriverManager.getConnection(url, username, password);
            
           
            /*
            Statement st=connection.createStatement();
             ResultSet rs=st.executeQuery("select * from role");
             
             while(rs.next()){
                 
                 System.out.println(rs.getString("id")+","+rs.getString("nom")+","+rs.getString("Description"));
                 
             }

            */

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any errors that may occur
        } finally {
            // Close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
           
        
    }
}

        
        new DashboardFrame();
    }
}
