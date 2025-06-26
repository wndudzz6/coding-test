package hahingNparsing;

import java.util.Arrays;
import java.util.HashMap;

public class P2 {
    public int[] solution(String s){
        int[] answer = new int[5];
        int max = 0;
        HashMap<Character, Integer> hm = new HashMap<>();

        for(char c : s.toCharArray()){
            hm.put(c, hm.getOrDefault(c, 0)+1);
        }

        //hashmap에서 빈도수로 볼 떄는 values()로 돌려야함
        for(int x : hm.values()){
            max = Math.max(max, x);
        }

        for(int i = 0; i<5; i++){
            char ch = (char)('a'+i);
            if(hm.containsKey(ch)){
                answer[i] = max - hm.get(ch);
            }else{
                answer[i] = max;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        P2 T = new P2();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
