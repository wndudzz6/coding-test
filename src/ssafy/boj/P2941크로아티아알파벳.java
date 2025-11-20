package ssafy.boj;

import java.io.*;
import java.util.*;

public class P2941크로아티아알파벳 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String word = st.nextToken();
        word = word.replace("c=", "1");
        word = word.replace("c-", "1");
        word = word.replace("dz=", "1");
        word = word.replace("d-", "1");
        word = word.replace("lj", "1");
        word = word.replace("nj", "1");
        word = word.replace("s=", "1");
        word = word.replace("z=", "1");

        System.out.println(word.length());
    }
}
