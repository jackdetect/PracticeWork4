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

    // Исправление email: @@ -> @, .. -> .
    static String fixEmail(String raw) {
        if (raw == null || raw.isBlank()) return "";
        raw = raw.trim();
        raw = raw.replaceAll("@{2,}", "@");
        raw = raw.replaceAll("\\.{2,}", ".");
        if (raw.matches("^[\\w.+-]+@[\\w-]+\\.[\\w.]{2,}$")) return raw;
        return "";
    }

    public static void main(String[] args) throws IOException {
        String inputFile  = "input.txt";
        String outputFile = "output.txt";

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
        PrintWriter writer = new PrintWriter(
                new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\|", -1);
            if (parts.length != 4) continue;
            String name  = fixName(parts[0]);
            String age   = fixAge(parts[1]);
            String phone = fixPhone(parts[2]);
            String email = fixEmail(parts[3]);
            String result = name + "|" + age + "|" + phone + "|" + email;
            writer.println(result);
            System.out.println("Вход:  " + line);
            System.out.println("Выход: " + result);
            System.out.println();
        }
        reader.close();
        writer.close();
        System.out.println("Готово! Результат записан в " + outputFile);
    }
}