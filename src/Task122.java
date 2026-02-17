public class Task122 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int maxProfit = 0;
        int profit = 0;
        boolean have = false;
        int start = 0;
        while ((start < prices.length - 2) && prices[start + 1] <= prices[start]) {
            start++;
        }
        profit = 0;
        int lastPrice = prices[start];
        have = true;
        int bestPrice = prices[start + 1];
        for (int index = start + 1; index < prices.length; index++) {
            if (have) {
                if (prices[index] >= bestPrice) {
                    bestPrice = prices[index];
                    if (index == prices.length - 1) {
                        profit += bestPrice - lastPrice;
                    }
                } else {
                    profit += bestPrice - lastPrice;
                    lastPrice = bestPrice;
                    have = false;
                    bestPrice = prices[index];
                }

            } else {
                if (prices[index] <= bestPrice) {
                    bestPrice = prices[index];
                } else {
                    lastPrice = bestPrice;
                    bestPrice = prices[index];
                    have = true;
                    if (index == prices.length - 1) {
                        profit += bestPrice - lastPrice;
                    }
                }
            }

        }
        maxProfit = Math.max(maxProfit, profit);
        return maxProfit;
    }
}
