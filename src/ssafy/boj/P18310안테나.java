package ssafy.boj;

import java.util.*;
import java.io.*;

//결정알고리즘으로 착각함 ㅎㅎ;
public class P18310안테나 {
    static int LOCATION = 200000;

    static int solution(int[] house){
        int n = house.length;
        Arrays.sort(house);

        if(n%2 == 0){
            int mid = n/2-1; //더 작은거(딱 나누어 떨어지지않을 때)
            return house[mid];
        }else{
            int mid = n/2;
            return house[mid];
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] house = new int[n];
        for(int i = 0; i<n; i++){
            house[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(house));

    }


}
