import java.io.*;
import java.util.regex.*;

public class Main {

    // Исправление имени: "ИванИванов" -> "Иван Иванов"
    static String fixName(String raw) {
        if (raw == null || raw.isBlank()) return "";
        raw = raw.trim();
        if (raw.matches("[А-ЯЁ][а-яё]+ [А-ЯЁ][а-яё]+")) return raw;
        String split = raw.replaceAll("([А-ЯЁ][а-яё]+)([А-ЯЁ])", "$1 $2");
        if (split.matches("[А-ЯЁ][а-яё]+ [А-ЯЁ][а-яё]+")) return split;
        return "";
    }

    public static void main(String[] args) throws IOException {
        String inputFile  = "input.txt";
        String outputFile = "output.txt";
        System.out.println("Программа запущена");
    }
}