import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
    public static String getNowTime() {
        LocalDateTime now = LocalDateTime.now();
        return now.format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"));
    }
}
