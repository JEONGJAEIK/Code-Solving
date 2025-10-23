import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            // 2진수 변경
            String binary = Long.toBinaryString(numbers[i]);
            
            int treeDepth = 0;
            int binarylength = binary.length();
            
            while(Math.pow(2, treeDepth) - 1 < binarylength) {
                treeDepth++;
            }
            
            int addSize = (int) (Math.pow(2, treeDepth) - 1) - binarylength;
            String newBinary = "0".repeat(addSize) + binary;
            
            answer[i] = checkBinary(newBinary);
        }
        return answer;
    }
    
    private int checkBinary(String newBinary) {
        int newBinaryLength = newBinary.length();
        int mid = newBinaryLength / 2;
        String leftChildren = newBinary.substring(0, mid);
        String rightChildren = newBinary.substring(mid + 1, newBinaryLength);
        char parent = newBinary.charAt(mid);
        
        if (parent == '0') {
            if (leftChildren.charAt(mid / 2) == '1' || rightChildren.charAt(mid / 2) == '1') {
                return 0;
            }
        }
        
        if (leftChildren.length() >= 3) {
            if (checkBinary(leftChildren) == 0) {
                return 0;
            };
        }
        
        if (rightChildren.length() >= 3) {
            if (checkBinary(rightChildren) == 0) {
                return 0;
            };
        }
        
        return 1;
    }
}