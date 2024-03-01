import org.example.service.ClimbingStairService;
import org.example.exception.ClimbingStairException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClimbingStairServiceTest {

    private final ClimbingStairService climbingStairService = new ClimbingStairService();

    @Test
    void climbingStairsEx1Test() throws ClimbingStairException {
        assertEquals(2, climbingStairService.climbStairs(2));
    }

    @Test
    void climbingStairsEx2Test() throws ClimbingStairException {
        assertEquals(3, climbingStairService.climbStairs(3));
    }

    @Test
    void climbingStairsEx3Test() throws ClimbingStairException {
        assertEquals(5, climbingStairService.climbStairs(4));
    }

    @Test
    void climbingStairsEx4Test() throws ClimbingStairException {
        assertEquals(8, climbingStairService.climbStairs(5));
    }

    @Test
    void exceptionClimbingStairsEx5Test() {
        Exception exception = assertThrows(ClimbingStairException.class, () -> climbingStairService.climbStairs(0));
        assertEquals("1 <= n <= 45", exception.getMessage());
    }

    @Test
    void exceptionClimbingStairsEx6Test() {
        Exception exception = assertThrows(ClimbingStairException.class, () -> climbingStairService.climbStairs(46));
        assertEquals("1 <= n <= 45", exception.getMessage());
    }
}
