package boj.hyndaeatuo.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P1931 {

    static class Meeting implements Comparable<Meeting>{
        int s;
        int e;

        Meeting(int s, int e){
            this.s = s;
            this.e = e;
        }

        public int compareTo(Meeting o){
            if(this.e == o.e) return this.s-o.s;
            return this.e -o.e;
        }
    }

    static int solution(int n, ArrayList<Meeting> list){
        int cnt = 1;
        int ce = list.get(0).e;
        for(int i = 1; i<n; i++){
            int s = list.get(i).s;
            int e = list.get(i).e;
            if(s>=ce){
                cnt++;
                ce = e;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Meeting> list = new ArrayList<>();
        for(int i = 1; i<=n; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            list.add(new Meeting(s,e));
        }
        sc.close();
        Collections.sort(list);
        System.out.println(solution(n, list));
    }
}
