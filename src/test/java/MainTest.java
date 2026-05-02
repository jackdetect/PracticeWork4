import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void testFixName_validWithSpace() {
        assertEquals("Иван Иванов", Main.fixName("Иван Иванов"));
    }

    @Test
    void testFixName_mergedName() {
        assertEquals("Иван Иванов", Main.fixName("ИванИванов"));
    }

    @Test
    void testFixName_blank() {
        assertEquals("", Main.fixName(""));
    }

    @Test
    void testFixName_null() {
        assertEquals("", Main.fixName(null));
    }

    @Test
    void testFixName_invalid() {
        assertEquals("", Main.fixName("12345"));
    }

    @Test
    void testFixAge_valid() {
        assertEquals("27", Main.fixAge("27"));
    }

    @Test
    void testFixAge_withSpaces() {
        assertEquals("27", Main.fixAge(" 27 "));
    }

    @Test
    void testFixAge_tooOld() {
        assertEquals("", Main.fixAge("200"));
    }

    @Test
    void testFixAge_blank() {
        assertEquals("", Main.fixAge(""));
    }

    @Test
    void testFixAge_null() {
        assertEquals("", Main.fixAge(null));
    }

    @Test
    void testFixAge_withLetters() {
        assertEquals("25", Main.fixAge("2a5"));
    }

    @Test
    void testFixPhone_validWithSpaces() {
        assertEquals("+7 (999) 000-11-11", Main.fixPhone("+7999000 1 1 11"));
    }

    @Test
    void testFixPhone_startsWith8() {
        assertEquals("+7 (999) 123-45-67", Main.fixPhone("89991234567"));
    }

    @Test
    void testFixPhone_tooShort() {
        assertEquals("", Main.fixPhone("12345"));
    }

    @Test
    void testFixPhone_blank() {
        assertEquals("", Main.fixPhone(""));
    }

    @Test
    void testFixPhone_null() {
        assertEquals("", Main.fixPhone(null));
    }

    @Test
    void testFixEmail_valid() {
        assertEquals("test@mail.ru", Main.fixEmail("test@mail.ru"));
    }

    @Test
    void testFixEmail_doubleAt() {
        assertEquals("example@yandex.ru", Main.fixEmail("example@@yandex.ru"));
    }

    @Test
    void testFixEmail_doubleDot() {
        assertEquals("example@yandex.ru", Main.fixEmail("example@yandex..ru"));
    }

    @Test
    void testFixEmail_bothErrors() {
        assertEquals("example@yandex.ru", Main.fixEmail("example@@yandex..ru"));
    }

    @Test
    void testFixEmail_blank() {
        assertEquals("", Main.fixEmail(""));
    }

    @Test
    void testFixEmail_null() {
        assertEquals("", Main.fixEmail(null));
    }

    @Test
    void testFixEmail_invalid() {
        assertEquals("", Main.fixEmail("not-an-email"));
    }
}