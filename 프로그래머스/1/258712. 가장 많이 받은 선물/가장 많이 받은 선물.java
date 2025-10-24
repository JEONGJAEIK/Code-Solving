import java.util.*;

class Solution {
    static Map<String, Integer> map = new HashMap<>();
    static int[] nextMonthGift;
    
    public int solution(String[] friends, String[] gifts) {
        int friendCount = friends.length;
        nextMonthGift = new int[friendCount];
        
        for (int i = 0; i < friendCount; i++) {
            map.put(friends[i], i);
        }
        
        int[][] giftCount = new int[friendCount][friendCount];
        int[] giftScore = new int[friendCount];
        
        for (String gift : gifts) {
            String[] arr = gift.split(" ");
            int from = map.get(arr[0]);
            int to = map.get(arr[1]);
            giftCount[from][to]++;
        }
        
        for (int i = 0; i < friendCount; i++) {
            int receiveScore = 0;
            int sendScore = 0;
            for (int j = 0; j < friendCount; j++) {
                sendScore += giftCount[i][j];
                receiveScore += giftCount[j][i];
            }
            giftScore[i] = sendScore - receiveScore;
        }
        
        for (int i = 0; i < friendCount; i++) {
            for (int j = i + 1; j < friendCount; j++) {
                if (giftCount[i][j] > giftCount[j][i]) {
                    nextMonthGift[i]++;
                } else if (giftCount[i][j] < giftCount[j][i]) {
                    nextMonthGift[j]++;
                } else {
                    if (giftScore[i] > giftScore[j]) {
                        nextMonthGift[i]++;
                    } else if (giftScore[i] < giftScore[j]) {
                        nextMonthGift[j]++;
                    } else {
                        continue;
                        }
                    }
                }
            }
        return Arrays.stream(nextMonthGift).max().getAsInt();
        }
    }
