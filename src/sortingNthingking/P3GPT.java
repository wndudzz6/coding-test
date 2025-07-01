package sortingNthingking;

import java.util.Arrays;

//3. 카드 가져가기 ~ 재도전
public class P3GPT {
    public int solution(int[] nums, int k){
        int answer = 0;
        int n = nums.length;
        Arrays.sort(nums); //오름차순 정렬이니 그냥 뒤부터 접근할까

        int idx =0;
        int[][] dist = new int[n/2][2];
        for(int i = 0; i < n/2; i++){
            dist[i][0] = nums[idx+1] - nums[idx];
            dist[i][1] = i;
            idx+=2;
        }




        return answer;
    }

    public static void main(String[] args){
        P3GPT T = new P3GPT();
        System.out.println(T.solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2));
        System.out.println(T.solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2));
        System.out.println(T.solution(new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7}, 3));
        System.out.println(T.solution(new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12}, 3));
        System.out.println(T.solution(new int[]{14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19}, 3));
    }
}
