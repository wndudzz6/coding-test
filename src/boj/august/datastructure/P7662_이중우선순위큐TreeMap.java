package boj.august.datastructure;

import java.util.Scanner;
import java.util.TreeMap;

public class P7662_이중우선순위큐TreeMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0; t<T; t++){
            int k = sc.nextInt();
            sc.nextLine();
            TreeMap<Integer, Integer> tm = new TreeMap<>(); //오름차 정렬
            for(int i = 0; i<k; i++){
                String x = sc.nextLine();
                char state = x.split(" ")[0].charAt(0);
                int n = Integer.parseInt(x.split(" ")[1]);

                if(state == 'I'){
                    tm.put(n, tm.getOrDefault(n, 0)+1);
                }else{
                    if(tm.isEmpty()) continue;

                    int key = (n == 1) ? tm.lastKey() : tm.firstKey();
                    if (tm.get(key) == 1) tm.remove(key);
                    else tm.put(key, tm.get(key)-1);
                }
            }
            if(tm.isEmpty()) System.out.println("EMPTY");
            else System.out.println(tm.lastKey()+" "+tm.firstKey());
        }
    }
}
