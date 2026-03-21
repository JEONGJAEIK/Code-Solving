import java.util.*;

class Solution {
    int[] parent;
    public int solution(int n, int[][] computers) {
        parent = new int[computers.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers.length; j++) {
                if (computers[i][j] != 0 && computers[i][j] == computers[j][i]) {
                    union(i, j);   
                }
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i : parent) {
            set.add(find(i));
        }
        int count = set.size();
        
        return count;
    }
    
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
    
    public int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        
        return parent[x] = find(parent[x]);
    }
}