import org.example.exception.MaximizeProfitException;
import org.example.service.MaximizeProfitService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MaximizeProfitServiceTest {

    private final MaximizeProfitService maximizeProfitService = new MaximizeProfitService();

    @Test
    void maximizeProfitEx1Test() throws MaximizeProfitException {
        int[] prices = {7, 1, 5, 3, 6, 4};
        assertEquals(5, maximizeProfitService.maxProfit(prices));
    }

    @Test
    void maximizeProfitEx2Test() throws MaximizeProfitException {
        int[] prices = {7, 6, 4, 3, 1};
        assertEquals(0, maximizeProfitService.maxProfit(prices));
    }

    @Test
    void maximizeProfitEx3Test() throws MaximizeProfitException {
        int[] prices = {7, 1, 5, 3, 6, 4, 10};
        assertEquals(9, maximizeProfitService.maxProfit(prices));
    }

    @Test
    void exceptionMaximizeProfitEx4Test() {
        int[] prices = {7, -1, 5, 3, 6, 4, 10};
        Exception exception = assertThrows(MaximizeProfitException.class, () -> maximizeProfitService.maxProfit(prices));
        assertEquals("0 <= prices[i] <= 10^4", exception.getMessage());
    }

    @Test
    void exceptionMaximizeProfitEx5Test() {
        int[] prices = {};
        Exception exception = assertThrows(MaximizeProfitException.class, () -> maximizeProfitService.maxProfit(prices));
        assertEquals("1 <= prices.length <= 10^5", exception.getMessage());
    }
}
