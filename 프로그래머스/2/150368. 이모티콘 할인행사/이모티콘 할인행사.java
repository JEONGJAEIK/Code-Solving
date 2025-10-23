
import java.util.Arrays;

class Solution {
    private int[][] users;
    private int[] emoticons;
    private final int[] DISCOUNT_RATES = {10, 20, 30, 40};
    private int maxSubscriber, maxRevenue;

    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        maxSubscriber = 0;
        maxRevenue = 0;

        combination(0, new int[emoticons.length]);
        return new int[]{maxSubscriber, maxRevenue};
    }

        private void combination(int depth, int[] discounts) {
        if (depth == emoticons.length) {
            evaluate(discounts);
            return;
        }

        for (int rate : DISCOUNT_RATES) {
            discounts[depth] = rate;
            combination(depth + 1, discounts);
        }
    }

    private void evaluate(int[] discounts) {
        int subscriberCount = 0, revenue = 0;

        for (int[] user : users) {
            int minDiscount = user[0];
            int threshold = user[1];
            int total = 0;

            for (int i = 0; i < emoticons.length; i++) {
                if (discounts[i] >= minDiscount) {
                    int price = emoticons[i] * (100 - discounts[i]) / 100;
                    total += price;
                }
            }

            if (total >= threshold) subscriberCount++;
            else revenue += total;
        }

        if (subscriberCount > maxSubscriber || 
            (subscriberCount == maxSubscriber && revenue > maxRevenue)) {
            maxSubscriber = subscriberCount;
            maxRevenue = revenue;
        }
    }
}
