class Solution {
    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
            long answer = 0;
            int deliverRemain = 0;
            int pickupRemain = 0;

            // 뒤에서부터 탐색
            for (int i = n - 1; i >= 0; i--) {
                deliverRemain += deliveries[i];
                pickupRemain += pickups[i];

                // 이번 위치에서 남은 배달/수거가 모두 0이 될 때까지 이동
                while (deliverRemain > 0 || pickupRemain > 0) {
                    deliverRemain -= cap;
                    pickupRemain -= cap;
                    answer += (i + 1) * 2L;  // 왕복 거리
                }
            }
            return answer;
        }
    }
