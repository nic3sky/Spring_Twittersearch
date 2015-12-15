package masterSpring.date;

import org.springframework.expression.ParseException;
import org.springframework.format.Formatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class ReLocalDateFormat implements Formatter<LocalDate>{
    public  static final    String  US_PARTTERN = "MM/dd/yyyy";
    public static final     String  NORMAL_PARTTEN ="dd/MM/yyyy";

    @Override   public LocalDate    parse(String text , Locale  locale)
        throws ParseException{
        return LocalDate.parse(text, DateTimeFormatter.ofPattern(getPattern(locale)));
    }

    @Override   public String   print(LocalDate object, Locale locale){
        return  DateTimeFormatter.ofPattern(getPattern(locale)).format(object);
    }

    public static String getPattern(Locale locale) {
        return isUSA(locale) ? US_PARTTERN : NORMAL_PARTTEN;
    }
    private static boolean  isUSA(Locale locale){
        return  Locale.US.getCountry().equals(locale.getCountry());
    }

}
