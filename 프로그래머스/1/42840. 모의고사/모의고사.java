import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[][] patterns = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        int[] scores = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < patterns.length; j++) {
                if (answers[i] == patterns[j][i % patterns[j].length]) {
                   scores[j]++; 
                }
            }
        }
        
        int maxScore = 0;
        for (int score : scores) {
            if (score > maxScore) {
                maxScore = score;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                result.add(i + 1);
            }
        }
        int[] realResult = new int[result.size()];
        
        for (int i = 0; i < result.size(); i++) {
            realResult[i] = result.get(i);
        }
        
        
        return realResult;
    
    }
}