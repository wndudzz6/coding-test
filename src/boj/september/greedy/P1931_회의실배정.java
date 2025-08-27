package boj.september.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//강의실 하나에 할 수 있는 강의를 최대한 받는 류
public class P1931_회의실배정 {

    static class Meeting implements Comparable<Meeting>{
        int s;
        int e;

        Meeting(int s, int e){
            this.s = s;
            this.e = e;
        }

        public int compareTo(Meeting o){
            if(this.e == o.e) return this.s-o.s;
            else return this.e-o.e;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Meeting> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            list.add(new Meeting(s,e));
        }

        Collections.sort(list);

        int cnt = 0;
        int curEnd = 0;
        for(Meeting o : list){
            if(curEnd <= o.s){
                cnt++;
                curEnd = o.e;
            }
        }

        System.out.println(cnt);
    }
}
