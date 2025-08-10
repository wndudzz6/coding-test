package boj.hyndaeatuo.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P1374 {
    static class Lecture implements Comparable<Lecture>{
        char s;
        long t;

        Lecture(char s, long t){
            this.s = s;
            this.t = t;
        }

        public int compareTo(Lecture o){
            if(this.t == o.t) return this.s-o.s; //끝e 시작 s char형태 오름차
            return (int)(this.t-o.t);
        }
    }

    static int solution(int n, ArrayList<Lecture> list){
        Collections.sort(list);
        int answer = 0;
        int cnt = 0;
        for(int i = 0; i<list.size(); i++){
            Lecture cur = list.get(i);
            if(cur.s == 'e'){
                cnt--;
            }else{
                cnt++;
                answer = Math.max(cnt, answer);
            }
        }return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Lecture> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            int num = sc.nextInt(); //이거 왜 필요한데?
            long s = sc.nextLong();
            long e = sc.nextLong();

            list.add(new Lecture('s', s));
            list.add(new Lecture('e', e));
        }

        System.out.println(solution(n, list));
    }
}
