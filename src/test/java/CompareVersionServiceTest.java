import org.example.service.CompareVersionService;
import org.example.exception.CompareVersionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CompareVersionServiceTest {

    private final CompareVersionService compareVersionService = new CompareVersionService();

    @Test
    void compareVersionEx1Test() throws CompareVersionException {
        assertEquals(0, compareVersionService.compareVersion("1.01", "1.001"));
    }

    @Test
    void compareVersionEx2Test() throws CompareVersionException {
        assertEquals(0, compareVersionService.compareVersion("1.0", "1.0.0"));
    }

    @Test
    void compareVersionEx3Test() throws CompareVersionException {
        assertEquals(-1, compareVersionService.compareVersion("0.1", "1.1"));
    }

    @Test
    void compareVersionEx4Test() throws CompareVersionException {
        assertEquals(1, compareVersionService.compareVersion("1.2", "1.1"));
    }

    @Test
    void exceptionCompareVersionEx5Test() {
        Exception exception = assertThrows(CompareVersionException.class, () -> compareVersionService.compareVersion("ab.12", "1.113.1asd"));
        assertEquals("version1 and version2 only contain digits and '.'", exception.getMessage());
    }

    @Test
    void exceptionCompareVersionEx6Test() {
        Exception exception = assertThrows(CompareVersionException.class, () -> compareVersionService.compareVersion("", "0.5"));
        assertEquals("1 <= version1.length, version2.length <= 500", exception.getMessage());
    }

    @Test
    void exceptionCompareVersionEx7Test() {
        Exception exception = assertThrows(CompareVersionException.class, () -> compareVersionService.compareVersion("1", "0.5"));
        assertEquals("version1 and version2 are valid version numbers.", exception.getMessage());
    }
}
