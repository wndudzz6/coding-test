package boj.hyndaeatuo.simulation;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//톱니바퀴
public class P14891 {
    static Deque<Character>[] gears = new Deque[4];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i<4; i++){
            String s = sc.nextLine();
            if(s.length()==0){
                s = sc.nextLine();
            }
            gears[i] = new LinkedList<>();
            for(char c : s.toCharArray()){
                gears[i].addLast(c);
            }
        }
        int K = sc.nextInt();

        while(K --> 0){
            int num = sc.nextInt()-1;
            int dir = sc.nextInt(); //1 시계, -1 반시계

            int[] rotateDir = new int[4];
            rotateDir[num] = dir;

            for(int i = num-1; i>=0; i--){
                if(getRight(gears[i]).equals(getLeft(gears[i+1]))) break;
                rotateDir[i] =- rotateDir[i+1];
            }

            for(int i = num + 1; i<4; i++){
                if(getLeft(gears[i]).equals(getRight(gears[i-1]))) break;
                rotateDir[i] = - rotateDir[i-1];
            }

            for(int i = 0; i<4; i++){
                if(rotateDir[i]==1) rotateClockwise(gears[i]);
                else if(rotateDir[i] ==-1) rotateCounterClockwise(gears[i]);
            }
        }

        int score = 0;
        for(int i =0; i<4; i++){
            if(gears[i].peekFirst() == '1'){
                score += (1<<i);
            }
        }
        System.out.println(score);

    }
    static void rotateClockwise(Deque<Character> gear) {
        gear.addFirst(gear.pollLast());
    }

    static void rotateCounterClockwise(Deque<Character> gear) {
        gear.addLast(gear.pollFirst());
    }

    static Character getLeft(Deque<Character> gear) {
        return ((LinkedList<Character>) gear).get(6); // 6번 인덱스가 왼쪽
    }

    static Character getRight(Deque<Character> gear) {
        return ((LinkedList<Character>) gear).get(2); // 2번 인덱스가 오른쪽
    }

}
