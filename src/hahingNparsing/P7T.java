package hahingNparsing;

import java.util.*;

//7. 경고 메일
public class P7T {
    public int getTime(String time){
        int h = Integer.parseInt(time.split(":")[0]);
        int m = Integer.parseInt(time.split(":")[1]);
        return h*60 + m;
    }

    public String[] solution(String[] reports, int time){
        HashMap<String, Integer> inT = new HashMap<>();
        HashMap<String, Integer> sumT = new HashMap<>();
        for(String x : reports){
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            String c = x.split(" ")[2];
            if(c.equals("in")) inT.put(a, getTime(b));
            else sumT.put(a, sumT.getOrDefault(a, 0)+(getTime(b)-inT.get(a)));
        }

        ArrayList<String> res = new ArrayList<>();
        for(String name : sumT.keySet()){
            if(sumT.get(name) > time) res.add(name);
        }
        Collections.sort(res);
        String[] answer = new String[res.size()];
        for(int i = 0; i<res.size(); i++){
            answer[i] = res.get(i);
        }

        return answer;
    }

    public static void main(String[] args){
        P7T T = new P7T();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }
}
