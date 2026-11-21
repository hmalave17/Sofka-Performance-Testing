package co.com.sofka.certification.utils;

public class Utils {

    private Utils (){}

    public static String getValueOrEmpty(String value) {
        return value == null ? "" : value;
    }

}
