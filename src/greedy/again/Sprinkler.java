package greedy.again;

import java.util.Arrays;

public class Sprinkler {
    public int solution(int n, int[] nums){
        int answer = 0;
        int[][] line = new int[n+1][2];
        for(int i = 0; i <= n; i++){
            line[i][0] = i-nums[i];
            line[i][1] = i+nums[i];
            if(line[i][0] < 0) line[i][0] = 0;
            if(line[i][1] > n) line[i][1] = n;
        }
        Arrays.sort(line, (a,b)->a[0]-b[0]);
        int start = 0, end = 0, i = 0;
        if(line[0][0] != 0) return -1;

        while(i<line.length){
            while(i<line.length && line[i][0]<= start) {
                end = Math.max(end, line[i][1]);
                i++;
            }
            answer++;

            if(end == n) return answer;
            if(start == end) return -1;

            start = end;
        }

        return answer;
    }

    public static void main(String[] args){
        Sprinkler T = new  Sprinkler();
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}
