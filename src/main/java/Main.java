import org.example.service.ClimbingStairService;
import org.example.service.CompareVersionService;
import org.example.service.MaximizeProfitService;

public class Main {

    public static void main(String[] args) {
        try {
            MaximizeProfitService maximizeProfitService = new MaximizeProfitService();
            CompareVersionService compareVersionService = new CompareVersionService();
            ClimbingStairService climbingStairService = new ClimbingStairService();
            int[] prices = {7, 1, 5, 3, 6, 4};
            System.out.println("Q1: " + maximizeProfitService.maxProfit(prices));
            System.out.println("Q2: " + compareVersionService.compareVersion("1.01", "1.001"));
            System.out.println("Q3: " + climbingStairService.climbStairs(3));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
