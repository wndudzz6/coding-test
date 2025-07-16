package graph;

import java.util.*;

//위상정렬이라는 것을 모르고 내가 혼자 해본 것
// 후수->선수 기준 그래프, 모든 그래프를 리스트에 넣기 위한 큐, 출력할 리스트
//조건 분기와 반복 제어에 논리 오류 때문에 제대로 된 답은 안나옴 -- 고침
//while 안에 들어있는 for문에서 continue하면 for문에서만 적용된다.
//시간 복잡도 O(n^2)
public class P6 {
    public String[] solution(String[] subjects, String[] course){
        int n = subjects.length; //course 개수가 n이라고 단정X
        String[] answer = new String[n];
        HashMap<String, HashSet<String>> graph  = new HashMap<>(); //후수->선수
        Queue<String> Q = new LinkedList<>();
        ArrayList<String> list = new ArrayList<>();

        for(String x : course){
            String after = x.split(" ")[0];
            String before = x.split(" ")[1];
            graph.putIfAbsent(after, new HashSet<>());
            graph.get(after).add(before);
            Q.offer(before);
            Q.offer(after);
        }

        while(!Q.isEmpty()){
            String s = Q.poll();
            if(list.contains(s)) continue;
            if(graph.get(s) != null){
                HashSet<String> hs = graph.get(s);
                boolean allDone = true;
                for(String x : hs){
                    if(!list.contains(x)){
                        allDone = false;
                        break;
                    }
                }
                if(!allDone){
                    Q.offer(s);
                    continue;
                }
            }
            list.add(s);
        }
        for(int i = 0; i<n; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args){
        P6 T = new P6();

        System.out.println(Arrays.toString(T.solution(
                new String[]{"english", "math", "physics", "art", "music"},
                new String[]{"art math", "physics art", "art music", "physics math", "english physics"}
        )));
        //System.out.println(T.solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"}));
        //System.out.println(T.solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"})[0]);
        //System.out.println(T.solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"}));
    }
}
