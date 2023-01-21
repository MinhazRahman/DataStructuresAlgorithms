package date.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class SplittingCurrentDate {

    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String strDate = formatter.format(now);
        System.out.println(strDate);

        // split the date string
        String[] strings = strDate.split("/");
        String month = strings[0];
        String day = strings[1];
        String year = strings[2];

        System.out.println(month);
        System.out.println(day);
        System.out.println(year);

    }
}
