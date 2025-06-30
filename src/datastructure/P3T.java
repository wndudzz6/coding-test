package datastructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//3. 현관문 출입순서
public class P3T {
    public int[] solution(int[] arrival, int[] state){
        int n = arrival.length;
        int[] answer = new int[n];
        Queue<Integer> enter = new LinkedList<>();
        Queue<Integer> exit = new LinkedList<>();
        int prev = 1;
        for(int t =0, i=0, cnt = 0; ;t++){
            //건너뛰기
            if(enter.isEmpty() && exit.isEmpty() && i<n){
                t = arrival[i];
                prev = 1;
            }
            while(i<n && t >= arrival[i]){
                if(state[i] == 0){
                    enter.offer(i);
                }else{
                    exit.offer(i);
                }
                i++;
            }
            if(prev == 1){
                if(!exit.isEmpty()){
                    answer[exit.poll()] = t;
                    prev = 1;
                }else{
                    answer[enter.poll()] = t;
                    prev = 1;
                }
            }else if(prev == 0){
                if(!enter.isEmpty()){
                    answer[enter.poll()] = t;
                    prev = 0;
                }else{
                    answer[exit.poll()] = t;
                    prev = 1;
                }
            }
            cnt++;
            if(cnt == n) break;
        }

        return answer;
    }

    public static void main(String[] args){
        P3T T = new P3T();
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }
}
