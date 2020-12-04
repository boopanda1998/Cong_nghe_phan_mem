import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  
import java.time.temporal.ChronoField;
import java.util.Date;
public class Clocktest{  
public static void main(String[] args) throws ParseException {      
////    System.out.println(a.get(ChronoField.DAY_OF_WEEK));  
//    System.out.println(a.get(ChronoField.DAY_OF_MONTH));  
//    System.out.println(a.get(ChronoField.MONTH_OF_YEAR));  
//    System.out.println(a.get(ChronoField.YEAR));  
//    System.out.println(a.get(ChronoField.HOUR_OF_DAY));  
//    System.out.println(a.get(ChronoField.MINUTE_OF_HOUR));
//    System.out.println(a.get(ChronoField.SECOND_OF_MINUTE));
    //
    LocalDateTime datetime = LocalDateTime.now();
  DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
  String formatDateTime = datetime.format(format);   
  System.out.println("After Formatting: " + formatDateTime ); 
  String str = formatDateTime.toString();
  System.out.println("After Formatting00: " + str); 
  
  //
  System.out.println("After Formatting:22 " + str); 
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
    System.out.println(dateTime.get(ChronoField.SECOND_OF_MINUTE));
            

 
}  
}  
