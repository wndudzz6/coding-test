package boj.august.datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1316_그룹단어체커 {

    static boolean check(String x){
        boolean flag = true;
        Map<Character, Integer> map = new HashMap<>();
        //앞글자와 같을 때에는 안잡다가 다를 때에 map이 있으면 잡기
        char prev = x.charAt(0);
        map.put(prev, 1);
        if(x.length() == 1) return true;
        for(int i = 1; i<x.length(); i++){
            if(prev == x.charAt(i)) map.put(prev, map.get(prev)+1);
            else{
                if(map.get(x.charAt(i)) == null){
                    map.putIfAbsent(x.charAt(i), 1);
                    prev = x.charAt(i);
                }else{
                    return false;
                }
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        sc.nextLine();
        for(int i = 0; i<n; i++){
            String x = sc.nextLine();
            if(check(x)) cnt++;
        }
        System.out.println(cnt);
    }
}
