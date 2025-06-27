package hahingNparsing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

//내가 풀 때 map 구조 세개 쓰는건 납득했는데 투표한걸 그냥 map에 저장하면 덮어쓰기가 된다는걸 까먹음 
public class P5T {
    public String solution(String[] votes, int k){
        String answer = " ";
        HashMap<String, HashSet<String>> voteMap = new HashMap<>();
        HashMap<String, Integer> candidate = new HashMap<>();
        HashMap<String, Integer> present = new HashMap<>();

        for(String x : votes){
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            voteMap.putIfAbsent(a, new HashSet<>());
            voteMap.get(a).add(b);
            candidate.put(b, candidate.getOrDefault(b, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for(String a : voteMap.keySet()){
            int cnt = 0;
            for(String b : voteMap.get(a)){
                if(candidate.get(b) >= k) cnt++;
            }
            present.put(a, cnt);
            max = Math.max(max, cnt);
        }

        ArrayList<String> tmp = new ArrayList<>();
        for(String name : present.keySet()){
            if(present.get(name) == max) tmp.add(name); //max가 여러 개 있을 때 처리
        }
        Collections.sort(tmp);
        answer = tmp.get(0);
        return answer;
    }

    public static void main(String[] args){
        P5T T = new P5T();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}
