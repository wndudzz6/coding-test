package greedy;

import java.util.Arrays;

public class P4 {
    public int solution(int[] plantTime, int[] growTime){
        int answer = 0;
        int n = plantTime.length;
        int plant = 0;
        int[][] flower = new int[n][2];
        for(int i = 0; i < n; i++){
            flower[i][0] = plantTime[i];
            flower[i][1] = growTime[i];
            plant += flower[i][0];
        }
        Arrays.sort(flower, (a, b)->b[1]-a[1]); //피는 기간 내림차
        int[] days = new int[plant];
        int idx = 0;
        for(int i = 0; i < n; i++){
            int day = flower[i][0];
            while(day>0){ //사실 day배열은 크게 의미가 없다.
                days[idx++] = i;
                day--;
            }
            answer = Math.max(answer, idx+flower[i][1]);
        }
        return answer;
    }

    public static void main(String[] args){
        P4 T = new P4();
        System.out.println(T.solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
        System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
        System.out.println(T.solution(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
        System.out.println(T.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
    }
}
