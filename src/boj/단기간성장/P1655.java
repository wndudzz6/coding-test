package boj.단기간성장;

import java.util.ArrayList;
import java.util.Scanner;

//가운데를 말해요 ~ 시간초과 N^2 log N
public class P1655 {

    static int[] solution(int n, int[] nums){
        int[] answer = new int[n];
        ArrayList<Integer> tmp = new ArrayList<>();

        for(int i = 1; i<=n; i++){
            tmp.add(nums[i]);
            tmp.sort((a,b)->a-b);
            if(i%2 ==0){ //2 01 / 4 0123 12
                int mid = tmp.size()/2;
                if(tmp.get(mid)>tmp.get(mid-1)) answer[i-1] = tmp.get(mid-1);
                else answer[i-1] = tmp.get(mid);
            }else{//홀수일 때 3-> 0[1]2 / 5 ->01[2]34 //
                int mid = tmp.size()/2;
                answer[i-1] = tmp.get(mid);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n+1];
        for(int i = 1; i<=n; i++){
            nums[i] = sc.nextInt();
        }
        sc.close();
        int[] answer = solution(n, nums);
        for(int x : answer) System.out.println(x);
    }
}
