
class Solution {
    public int solution(int[][] sizes) {
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (int[] card : sizes) {
            int w = Math.max(card[0], card[1]);
            int h = Math.min(card[0], card[1]);
            
            if (w > maxX) maxX = w;
            if (h > maxY) maxY = h;
        }
        return maxX * maxY;
    }
}