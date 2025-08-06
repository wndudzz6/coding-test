package boj.hyndaeatuo.parsing;

import java.util.Arrays;
import java.util.Scanner;

public class P1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        int[] alpha = new int[26];
        for(char x : s.toCharArray()){
            x = Character.toUpperCase(x);
            alpha[x-'A']++;
        }
        int max = Arrays.stream(alpha).max().getAsInt();
        int cnt = 0;
        int index = 0;
        for(int i = 0; i<26; i++){
            if(alpha[i]==max){
                index = i;
                cnt++;
            }
        }
        if(cnt == 1) System.out.println((char) ('A'+index));
        else System.out.println("?");

    }
}
