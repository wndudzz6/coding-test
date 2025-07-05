package greedy;

import java.util.Arrays;

//2.이동횟수
//2,3 범위 만드는데에 꽂혀서 좀 복잡하게 만듦 P2T가 낫다.
public class P2 {
    public int solution(int[] nums){
        int answer = 0;
        Arrays.sort(nums);
        int idx = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]>3) {
                idx = i-1;
                break;
            }
        }
        int lt = 0; int rt = idx;
        //2~3만 있음 3,3이 될 때만 넘어감
        for(int i = idx+1; i<nums.length; i++) answer++;
        while(lt<=rt){
            if(nums[lt]+nums[rt] <= 5){
                answer++;
                lt++; rt--;
            }else{
                //3+3일 때
                answer++;
                rt--;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        P2 T = new P2();
        System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(T.solution(new int[]{2, 3, 4, 5}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
    }
}
