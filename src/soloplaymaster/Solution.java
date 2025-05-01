package soloplaymaster;

public class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        int length = cards.length;
        int boxCount1 = Integer.MIN_VALUE;
        int boxCount2 = Integer.MIN_VALUE;
        boolean[] visited = new boolean[length];
        for(int i = 0; i < length; i++){
            if(!visited[i]){
                int count = dfs(cards, visited, i, 1);
                if(boxCount1 >= boxCount2){
                    boxCount2 = Math.max(boxCount2, count);
                }else{
                    boxCount1 = Math.max(boxCount1, count);
                }
            }
        }
        if(boxCount2 == Integer.MIN_VALUE) return 0;

        return boxCount1 * boxCount2;
    }
    public int dfs(int[] arr, boolean[] visited, int start, int count){
        if(visited[start]){
            return count - 1;
        }

        int target = arr[start] - 1;
        visited[start] = true;
        count = dfs(arr, visited, target, count + 1);

        return count;
    }

}