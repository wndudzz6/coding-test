package boj.hyndaeatuo.graph.lecture;

import java.util.Arrays;
import java.util.Scanner;

//친구인가?
public class UnionFind1 {
    static int[] friend;

    static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) friend[fb] = fa;
    }

    static int find(int a){
        if(friend[a] != a){
            friend[a] = find(friend[a]);
        }
        return friend[a];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        friend = new int[n+1];
        for(int i =1; i<=n; i++){
            friend[i] = i; //자기 자신이 친구
        }
        for(int i = 1; i<=m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a,b);
        }

        int a = sc.nextInt();
        int b = sc.nextInt();
        if(find(a) != find(b)) System.out.println("NO");
        else System.out.println("YES");
    }
}
