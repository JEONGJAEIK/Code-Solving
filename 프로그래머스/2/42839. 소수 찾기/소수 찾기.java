import java.util.*;


class Solution {
    static Set<Integer> numberSet = new HashSet<>();
    static boolean[] visited;
    
        public static int solution(String numbers) {
        visited = new boolean[numbers.length()];
        permutation("", numbers);

        int count = 0;
        for (int num : numberSet) {
            if (isPrime(num)) count++;
        }

        return count;
    }

    // 순열
    public static void permutation(String prefix, String numbers) {
        if (!prefix.isEmpty()) {
            numberSet.add(Integer.parseInt(prefix));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(prefix + numbers.charAt(i), numbers);
                visited[i] = false;
            }
        }
    }

    // 소수 판별
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    
}