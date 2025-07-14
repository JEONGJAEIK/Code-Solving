class Solution {
    static int count = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        int answer = count;
        return answer;
    }
    static void dfs(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            if (sum == target) {
                count++;
            }
            return;
        }
        dfs(numbers, target, index + 1, sum + numbers[index]);
        dfs(numbers, target, index + 1, sum - numbers[index]);
    }
}