package boj.august.datastructure;

import java.util.HashMap;
import java.util.Scanner;

public class P1302_베스트셀러 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            String book = sc.nextLine();
            map.merge(book, 1, Integer::sum);
        }
        int max = -1;
        String answer = "";
        for(String x : map.keySet()){
            if(max < map.get(x) || (map.get(x) == max && x.compareTo(answer)<0)){
                max = map.get(x);
                answer = x;
            }
        }

        System.out.println(answer);
    }
}
