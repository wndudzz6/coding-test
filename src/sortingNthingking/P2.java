package sortingNthingking;

import java.util.Arrays;

//2. 수열찾기
//테스트 케이스는 통과했지만 논리적인 허점 존재
//같은 수 중복되거나, 2배 관계가 순서와 상관없이 여러 번 나타나는 경우 문제 생김
public class P2 {
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length / 2];
        int idx = 0;
        for(int i = 0; i<nums.length; i++){
            boolean flag = false;
            for(int j = 0; j<nums.length; j++){
                if(nums[i] * 2 == nums[j]){
                    flag = true;
                }
            }
            if(flag) answer[idx++] = nums[i];
        }
        Arrays.sort(answer);
        return answer;
    }

    public static void main(String[] args){
        P2 T = new P2();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}
