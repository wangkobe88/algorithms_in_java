package array;

/**
 * Created by kewang on 8/11/18.
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfitDP(int[] prices) {
        int result[] = new int[prices.length];
        int maxProfit = Integer.MIN_VALUE;
        int minPrice = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
            result[i] = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit,result[i]);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
    public int maxProfitBruceForce(int[] prices) {
        int result = 0;
        for(int i = 0; i < prices.length; i++) {
            for(int j = i + 1; j < prices.length; j++) {
                result = Math.max(prices[j] - prices[i], result);
            }
        }
        return result;
    }

    public int maxProfit(int[] prices) {
        int result = 0;
        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            result = Math.max(result, prices[i] - minValue);
            minValue = Math.min(minValue,prices[i]);
        }
        return result;
    }

}
