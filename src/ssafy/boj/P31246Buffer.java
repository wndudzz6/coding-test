package ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P31246Buffer {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int cnt = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> a-b); //오름차순 정렬
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a>=b) cnt++;
            else pq.offer(b-a);
        }

        if(cnt>=k) System.out.println(0);
        else{
            int idx = k-cnt; //1이면 한번 뽑기 2면 두번 뽑기..
            for(int i = 0; i<idx-1; i++){
                pq.poll();
            }
            System.out.println(pq.poll());
        }

    }
}
