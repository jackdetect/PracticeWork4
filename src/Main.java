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

    // Исправление возраста: убираем минус, проверяем диапазон 0-130
    static String fixAge(String raw) {
        if (raw == null || raw.isBlank()) return "";
        String digits = raw.trim().replaceAll("[^0-9]", "");
        if (digits.isEmpty()) return "";
        int age = Integer.parseInt(digits);
        if (age < 0 || age > 130) return "";
        return String.valueOf(age);
    }

    // Форматирование телефона -> +7 (XXX) XXX-XX-XX
    static String fixPhone(String raw) {
        if (raw == null || raw.isBlank()) return "";
        String digits = raw.trim().replaceAll("[^0-9]", "");
        if (digits.startsWith("7") || digits.startsWith("8"))
            digits = digits.substring(1);
        if (digits.length() != 10) return "";
        return String.format("+7 (%s) %s-%s-%s",
                digits.substring(0, 3), digits.substring(3, 6),
                digits.substring(6, 8), digits.substring(8, 10));
    }

    public static void main(String[] args) throws IOException {
        String inputFile  = "input.txt";
        String outputFile = "output.txt";
        System.out.println("Программа запущена");
    }
}