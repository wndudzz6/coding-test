package ssafy.boj;

import java.io.*;
import java.util.*;

public class P11650좌표정렬하기 {

    static class Point implements Comparable<Point>{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point o){
            if(o.x == this.x) return this.y-o.y;
            return this.x-o.x;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        List<Point> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Point(x,y));
        }

        Collections.sort(list);
        for(Point p : list){
            System.out.println(p.x+" "+p.y);
        }
    }
}
