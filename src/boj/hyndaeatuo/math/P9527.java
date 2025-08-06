package boj.hyndaeatuo.math;

import java.util.Scanner;

//메모리 초과가 남
public class P9527 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long dist = b-a+1; //2~12 2 3 4 5 6 7 8 9 10 11 12 dist : 11
        int sum = 0;
        for(int i = 0; i<dist; i++){
            String s = Long.toBinaryString((a+i));
            for(char x : s.toCharArray()){
                if(x=='1') sum++;
            }
        }
        System.out.println(sum);
    }
}
