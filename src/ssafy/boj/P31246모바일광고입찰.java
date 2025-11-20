package ssafy.boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P31246모바일광고입찰 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int cnt = 0;
        List<Integer> dif = new ArrayList<>();
        for(int i = 0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(a>=b) cnt++; //같은 경우는 테스크케이스에 없긴 함
            else dif.add(b-a);
        }

        if(cnt>=k) System.out.println(0);
        else{
            Collections.sort(dif);
            System.out.println(dif.get(k-cnt-1));
        }
    }
}
