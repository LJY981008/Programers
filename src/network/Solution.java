package network;

class Solution {
    public int solution(int n, int[][] computers) {
        int count = 0;
        boolean[] visible = new boolean[computers.length];
        for(int i = 0; i < n; i++){
            if(!visible[i]){
                count++;
                dfs(n, computers, visible, i);
            }
        }

        return count;
    }
    public void dfs(int n, int[][] arr, boolean[] visible, int index){
        if(!visible[index]) {
            visible[index] = true;
            for (int i = 0; i < n; i++) {
                if(arr[index][i] == 1) dfs(n, arr, visible, i);
            }
        }
    }
}