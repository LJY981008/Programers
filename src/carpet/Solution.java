package carpet;

class Solution {
    public int[] solution(int brown, int yellow) {

        for(int i = 3; i <= brown / 2; i++){
            int tb = i * 2;
            int y = (brown - tb) / 2 + 2;
            if(i >= y && ((brown - tb) / 2) * (i - 2) == yellow){
                return new int[]{i, y};
            }
        }

        return new int[]{0,0};
    }
}