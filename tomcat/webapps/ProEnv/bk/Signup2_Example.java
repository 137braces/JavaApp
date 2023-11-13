
import java.util.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Signup2_Example {
    //入力された生年月日を年齢に変換する関数。
    public static String getAge (String birthday){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
            LocalDate localBirdhdate = LocalDate.parse(birthday, formatter);
            LocalDate nowDate = LocalDate.now();
            return Long.toString(ChronoUnit.YEARS.between(localBirdhdate, nowDate));
    }
    

    public static void main(String[] args) {
        String age = getAge("1996-7-13");
        System.out.println(age);

    }

}
