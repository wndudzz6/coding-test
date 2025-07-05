package greedy.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

//조건별 누적합 최적화 정렬 + 누적 + 그룹핑 캐싱
public class Game {
    static class Student implements Comparable<Student> {
        int idx;
        char team;
        int power;
        Student(int idx, char team, int power){
            this.idx = idx;
            this.team = team;
            this.power = power;
        }
        @Override
        public int compareTo(Student o) {
            return this.power - o.power;
        }
    }
    public int[] solution(String[] students){
        int n = students.length;
        int[] answer = new int[n];
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char a = students[i].charAt(0);
            int b = Integer.parseInt(students[i].split(" ")[1]);
            list.add(new Student(i, a, b));
        }

        Collections.sort(list);
        HashMap<Character, Integer> map = new HashMap<>();

        int total = 0, j =0;
        for(int i = 1; i<n ; i++){
            for(; j<n; j++){
                if(list.get(i).power>list.get(j).power){
                    total+=list.get(j).power;
                    map.put(list.get(j).team, map.getOrDefault(list.get(j).team, 0) + list.get(j).power);
                }else break;
            }
            answer[list.get(i).idx] = total-map.getOrDefault(list.get(i).team, 0);
        }

        return answer;
    }

    public static void main(String[] args){
        Game T = new Game();
        System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
    }
}
