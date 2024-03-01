package org.example.service;

import org.example.exception.ClimbingStairException;

public class ClimbingStairService {
    public int climbStairs(int n) throws ClimbingStairException {
        if (n == 1 || n == 2) {
            return n;
        }
        if (1 <= n && n <= 45) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        } else {
            throw new ClimbingStairException("1 <= n <= 45");
        }

    }
}
