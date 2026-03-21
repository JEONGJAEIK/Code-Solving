class Solution {
    public int solution(int[][] cost, int[][] hint) {
        int n = cost.length;
        int bundleCount = n - 1;
        int minTotal = Integer.MAX_VALUE;

        for (int mask = 0; mask < (1 << bundleCount); mask++) {
            int[] hintCount = new int[n];
            int bundleCost = 0;

            for (int i = 0; i < bundleCount; i++) {
                if ((mask & (1 << i)) != 0) {
                    bundleCost += hint[i][0];
                    for (int j = 1; j < hint[i].length; j++) {
                        hintCount[hint[i][j] - 1]++;
                    }
                }
            }

            int totalCost = bundleCost;
            for (int i = 0; i < n; i++) {
                totalCost += cost[i][Math.min(hintCount[i], n - 1)];
            }
            minTotal = Math.min(minTotal, totalCost);
        }
        return minTotal;
    }
}