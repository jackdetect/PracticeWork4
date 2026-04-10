package steps;

import io.cucumber.java.ru.*;
import static org.junit.Assert.*;

public class ValidationSteps {

    private String inputLine;
    private String result;

    @Дано("входная строка {string}")
    public void входная_строка(String line) {
        this.inputLine = line;
    }

    @Когда("программа обрабатывает строку")
    public void программа_обрабатывает_строку() {
        String[] parts = inputLine.split("\\|", -1);
        String name  = Main.fixName(parts[0]);
        String age   = Main.fixAge(parts[1]);
        String phone = Main.fixPhone(parts[2]);
        String email = Main.fixEmail(parts[3]);
        this.result = name + "|" + age + "|" + phone + "|" + email;
    }

    @Тогда("результат должен быть {string}")
    public void результат_должен_быть(String expected) {
        assertEquals(expected, result);
    }
}