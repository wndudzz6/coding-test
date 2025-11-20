package ssafy.boj;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P7785회사에있는사람 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        TreeSet<String> tset = new TreeSet<>(Comparator.reverseOrder());
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();

            if(state.equals("enter")){
                tset.add(name);
            }else{
                tset.remove(name);
            }
        }

        for(String name : tset) System.out.println(name);
    }
}
