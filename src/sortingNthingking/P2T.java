package sortingNthingking;

import java.util.Arrays;
import java.util.HashMap;

//이해는 되는데 다음번에 내가 자연스럽게 떠올려서 쓸 수 있을까?
public class P2T {
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length / 2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x : nums){
            map.put(x, map.getOrDefault(x,0)+1);
        }
        Arrays.sort(nums);
        int idx = 0;
        for(int x : nums){
            if(map.get(x) == 0) continue;

            answer[idx++] = x;

            //빈도수 기반 매칭 순차적으로 제어
            map.put(x, map.get(x)-1);
            map.put(x*2, map.get(x*2)-1);
        }

        return answer;
    }

    public static void main(String[] args){
        P2T T = new P2T();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}
