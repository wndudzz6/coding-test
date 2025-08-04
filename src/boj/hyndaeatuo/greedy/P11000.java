package boj.hyndaeatuo.greedy;

import java.util.*;

//강의실 배정 - 스위핑 풀이 복습 필수 (까먹음) 
public class P11000 {

    static class Time implements Comparable<Time>{
        int time;
        char state;
        Time(int time, char state){
            this.time = time;
            this.state = state;
        }
        @Override
        public int compareTo(Time o){
            if(this.time == o.time) return this.state - o.state; //e부터
            return this.time-o.time; //time 오름차
        }
    }

    static int solution(int n, int[][] lecture){
        int answer = 0;
        ArrayList<Time> times = new ArrayList<>();
        for(int i = 0; i<n; i++){
            times.add(new Time(lecture[i][0], 's'));
            times.add(new Time(lecture[i][1], 'e'));
        }
        Collections.sort(times);
        int cnt = 0;
        for(Time t : times){
            if(t.state == 's') cnt++;
            else cnt--;
            answer = Math.max(cnt, answer);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] lecture = new int[n][2];
        for(int i = 0; i<n; i++){
            lecture[i][0] = sc.nextInt();
            lecture[i][1] = sc.nextInt();
        }
        sc.close();
        System.out.println(solution(n, lecture));
    }

}
