package boj.hyndaeatuo.greedy;

import java.util.Scanner;

//기타줄 ~ 실용적인 풀이
public class P1049 {

    static int solution(int n, int m, int[][] brand){
        int pack = Integer.MAX_VALUE;
        int each = Integer.MAX_VALUE;
        for(int i = 0; i<m; i++){
            pack = Math.min(brand[i][0], pack);
            each = Math.min(brand[i][1], each);
        }
        int answer = each*n;
        int mod = n%6;
        int quo = n/6;
        //quo*pack + mod*each
        int p1 = (quo*pack) + (mod*each);
        answer = Math.min(answer, p1);
        //only pack
        int p2 = (quo+1)*pack;

        answer = Math.min(answer,p2);
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] brand = new int[m][2];
        for(int i = 0; i<m; i++){
            brand[i][0] = sc.nextInt();
            brand[i][1] = sc.nextInt();
        }
        sc.close();
        System.out.println(solution(n, m, brand));
    }
}
