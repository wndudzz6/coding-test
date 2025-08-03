package boj.hyndaeatuo.graph.lecture;

import java.util.Scanner;

//여행가자
public class P1976 {
    static int[] city;

    static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa!=fb) city[fb] = city[fa];
    }

    static int find(int a){
        if(a!=city[a]){
            city[a] = find(city[a]);
        }
        return city[a];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //도시 수
        int m = sc.nextInt(); //여행 계획 도시 수
        city = new int[n+1];
        for(int i =1; i<=n; i++){
            city[i] = i;
        }

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                int x = sc.nextInt();
                if(x==1){
                    union(i, j);
                }
            }
        }
        int[] plan = new int[m];
        for(int i = 0; i<m; i++){
            plan[i] = sc.nextInt();
        }sc.close();

        for(int i = 0; i<m-1; i++){
            if(find(plan[i]) != find(plan[i+1])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
