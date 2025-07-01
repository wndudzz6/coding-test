package sortingNthingking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//1. 이진수 정렬
public class P1 {
    static class Binary implements Comparable<Binary>{
        int num;
        int cnt;
        Binary(int num, int cnt){
            this.num = num;
            this.cnt= cnt;
        }

        @Override
        public int compareTo(Binary o) {
            if(o.cnt == this.cnt) return this.num - o.num;
            else return this.cnt-o.cnt;
        }
    }

    int count1(String s){
        int cnt = 0;
        for(char x : s.toCharArray()){
            if(x=='1') cnt++;
        }
        return cnt;
    }
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length];
        ArrayList<Binary> list = new ArrayList<>();
        for(int num : nums){
            String s = Integer.toBinaryString(num);
            int cnt = count1(s);
            list.add(new Binary(num, cnt));
        }
        Collections.sort(list);
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i).num;
        }

        return answer;
    }

    public static void main(String[] args){
        P1 T = new P1();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}
