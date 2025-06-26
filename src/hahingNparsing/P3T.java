package hahingNparsing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//서로 다른 빈도수 만들기
public class P3T {
    public int solution(String s){
        int answer = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        Set<Integer> ch = new HashSet<>();
        for(char c : s.toCharArray()){
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        for(char key : hm.keySet()){
            while(ch.contains(hm.get(key))){
                answer++;
                hm.put(key, hm.get(key) - 1);
            }
            if(hm.get(key) == 0) continue;
            ch.add(hm.get(key));
        }

        return answer;
    }

    public static void main(String[] args){
        P3T T = new P3T();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}
