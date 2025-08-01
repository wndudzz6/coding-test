package boj.hyndaeatuo;

import java.util.ArrayList;
import java.util.Scanner;

//모바일 광고 입찰
//내가 생각한 전략 : cnt, dist리스트(쭉 정렬) 15분씀 정렬을 매번 하려다가 시간초과 뜸 수정
public class P31246 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> dist = new ArrayList<>(); //(a,b)->a-b 왜 안되지?
        int cnt = 0;
        boolean flag = false;

        for(int i = 0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a-b>= 0) cnt++;
            else{
                dist.add(b-a);
            }
            if(cnt>=k) flag = true;
        }
        if(flag) System.out.println(0);
        else {
            dist.sort((c,d)->c-d);
            System.out.println(dist.get(k-(cnt+1)));
        }
    }
}
