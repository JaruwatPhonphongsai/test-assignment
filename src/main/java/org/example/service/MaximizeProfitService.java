package org.example.service;

import org.example.exception.MaximizeProfitException;

public class MaximizeProfitService {

    public int maxProfit(int[] prices) throws MaximizeProfitException {
        int maxLength = (int) Math.pow(10, 5);
        int maxPrice = (int) Math.pow(10, 4);
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        if (1 <= prices.length && prices.length <= maxLength) {
            for (int price : prices) {
                if (0 <= price && price <= maxPrice) {
                    if (price < minPrice) {
                        minPrice = price;
                    } else if (price - minPrice > maxProfit) {
                        maxProfit = price - minPrice;
                    }
                } else {
                    throw new MaximizeProfitException("0 <= prices[i] <= 10^4");
                }
            }
        } else {
            throw new MaximizeProfitException("1 <= prices.length <= 10^5");
        }

        return maxProfit;
    }
}
