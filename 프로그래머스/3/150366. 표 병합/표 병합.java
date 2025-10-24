import java.util.*;

class Solution {
    static int[] index = new int[2501];
    static String[] value = new String[2501];
    static List<String> tempResult = new ArrayList<>();
    
    public String[] solution(String[] commands) {
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
            value[i] = "";
        }
        
        for(int i = 0; i < commands.length; i++) {
            String[] command = commands[i].split(" ");
            if (command[0].equals("UPDATE")) {
                if (command.length == 4) {
                    updateValue(Integer.valueOf(command[1]), Integer.valueOf(command[2]), command[3]);
                } else {
                    updateTotalValue(command[1], command[2]);
                }
            } else if (command[0].equals("MERGE")) {
                mergeCell(Integer.valueOf(command[1]), Integer.valueOf(command[2]), 
                          Integer.valueOf(command[3]), Integer.valueOf(command[4]));
            } else if (command[0].equals("UNMERGE")) {
                unmerge(Integer.valueOf(command[1]), Integer.valueOf(command[2]));
            } else {
                printCell(Integer.valueOf(command[1]), Integer.valueOf(command[2]));
            }
        }
        String[] result = tempResult.toArray(new String[0]);
        return result;
    }
    
    
    private void updateValue(int y, int x, String newValue) {
        int targetIndex = (y - 1) * 50 + x;
        int target = find(targetIndex);
        for(int i = 0; i < index.length; i++) {
            if(index[i] == target) {
                value[i] = newValue;
            }
        }
    }
    
    private void updateTotalValue(String oldValue, String newValue) {
        for(int i = 0; i < value.length; i++) {
            if(value[i].equals(oldValue)) {
                value[i] = newValue;
            }
        }
    }
    
    private void mergeCell(int y1, int x1, int y2, int x2) {
        int targetIndex1 = (y1 - 1) * 50 + x1;
        int targetIndex2 = (y2 - 1) * 50 + x2;
        
        int target1 = find(targetIndex1);
        int target2 = find(targetIndex2);
        if (target1 != target2) {
            for(int i = 1; i < index.length; i++) {
                if (index[i] == target2) {
                    index[i] = target1;
                }
            }
            if (!value[target2].equals("") && value[target1].equals("")) {
                updateValue(Integer.valueOf(y2), Integer.valueOf(x2), value[target2]);
            } else {
                updateValue(Integer.valueOf(y2), Integer.valueOf(x2), value[target1]);
            }
        }
    }
    
    private void unmerge(int y, int x) {
        int targetIndex = (y - 1) * 50 + x;
        // 타겟 인덱스의 값을 가지고 있는 모든 인덱스를 찾는다.
        int parent = find(targetIndex);
        String oldValue = value[parent];
        for (int i = 0; i < index.length; i++) {
            if (find(i) == parent) {
                index[i] = i;
                value[i] = "";
            }
        }
        value[targetIndex] = oldValue;
    }
    
    private void printCell(int y, int x) {
        int targetIndex = (y - 1) * 50 + x;
        int parentIndex = find(targetIndex);
        String answer = value[parentIndex];
        if (answer.equals("")) {
            tempResult.add("EMPTY");
        } else {
            tempResult.add(answer);
        }
    }
    
    private int find(int idx) {
        if (index[idx] == idx) {
            return idx;
        } else {
            return index[idx] = find(index[idx]);
        }
    }
}