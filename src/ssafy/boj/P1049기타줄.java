package ssafy.boj;

import java.io.*;
import java.util.*;
public class P1049기타줄 {

    static int comparePrice(int[][] brand, int n){
        int packMin = Integer.MAX_VALUE;
        int eachMin = Integer.MAX_VALUE;

        for(int i = 0; i<brand.length; i++){
            packMin = Math.min(packMin, brand[i][0]);
            eachMin = Math.min(eachMin, brand[i][1]);
        }

        int answer = eachMin * n;

        int quo = n/6;
        int mod = n%6;

        int p1 = (packMin * quo) + (eachMin * mod);
        int p2 = packMin * (quo+1);

        answer = Math.min(answer, p1);
        answer = Math.min(answer, p2);

        return answer;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //끊어진 기타줄 개수
        int m = Integer.parseInt(st.nextToken()); //기타줄 브랜드

        int[][] brand = new int[m][2];

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int pack = Integer.parseInt(st.nextToken());
            int each = Integer.parseInt(st.nextToken());

            brand[i][0] = pack;
            brand[i][1] = each;
        }

        System.out.println(comparePrice(brand, n));

    }
}
