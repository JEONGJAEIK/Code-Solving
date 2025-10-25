import java.util.*;

class Solution {
    static int diceCount;
    static int[][] dice;
    static int[] bestPick;
    static double bestWinRate = -1;
    
    public int[] solution(int[][] dice) {    
        this.dice = dice;
        diceCount = dice.length / 2;
        bestPick = new int[diceCount];
        dfs(new ArrayList<>(), 0);
        return bestPick;
    }
    
    private void dfs(List<Integer> aPick, int depth) {
        if (aPick.size() == diceCount) {
            simulate(aPick);
        }
        
        for (int i = depth; i < dice.length; i++) {
            aPick.add(i);
            dfs(aPick, i + 1);
            aPick.remove(aPick.size() - 1);
        }
    }
    
    private void simulate(List<Integer> aPick) {
        List<Integer> bPick = new ArrayList<>();
        
        for(int i = 0; i < dice.length; i++) {
            if (!aPick.contains(i)) {
                bPick.add(i);
            }
        }
        
        List<Integer> aSums = backtrackSum(0, 0, aPick, new ArrayList<>());
        List<Integer> bSums = backtrackSum(0, 0, bPick, new ArrayList<>());

        Collections.sort(aSums);
        Collections.sort(bSums);
        
        long win = 0, draw = 0, lose = 0;
        int j = 0;
        for (int a : aSums) {
            while (j < bSums.size() && bSums.get(j) < a) j++;
            win += j;
        }
        
        double total = (double) aSums.size() * bSums.size();
        double winRate = win / total;

        if (winRate > bestWinRate) {
            bestWinRate = winRate;
            for (int i = 0; i < aPick.size(); i++) {
                bestPick[i] = aPick.get(i) + 1;
            }
        }
    }
    
    private List<Integer> backtrackSum(int depth, int sum, List<Integer> pick, List<Integer> sums) {
        if (pick.size() == depth) {
            sums.add(sum);
            return sums;
        }
        
        int[] curDice = dice[pick.get(depth)];
        for (int num : curDice) {
            backtrackSum(depth + 1, sum + num, pick, sums);
        }
        return sums;
    }
}