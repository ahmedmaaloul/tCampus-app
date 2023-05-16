
package classes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


class Utilisateur {
    
    
    public static void main(String[] args) {
      
        
       String dateString = "2023-05-16 10:30:00";
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = sdf.parse(dateString);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
    }
    

}
