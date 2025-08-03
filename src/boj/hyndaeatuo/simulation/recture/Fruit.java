package boj.hyndaeatuo.simulation.recture;

import java.util.Arrays;

public class Fruit {

    int minIndex(int[]fruit){
        int minIndex = 0;
        for(int i = 1; i<fruit.length; i++){
            if(fruit[minIndex]> fruit[i])
                minIndex = i;
        }
        return minIndex;
    }

    boolean canChange(int[]s1, int[]s2, int minIndex1, int minIndex2){
        int[] copy1 = Arrays.copyOf(s1, s1.length);
        int[] copy2 = Arrays.copyOf(s2, s2.length);
        copy1[minIndex1]++;
        copy2[minIndex1]--;

        copy1[minIndex2]--;
        copy2[minIndex2]++;

        if(minIndex1 != minIndex(copy1)) return false;
        if(minIndex2 != minIndex(copy2)) return false;

        return true;
    }

    public int solution(int[][] fruit){
        int answer = 0;
        int n = fruit.length;
        boolean[] ch = new boolean[n]; //0 based 기본이 false
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                int minIndex1 = minIndex(fruit[i]);
                int minIndex2 = minIndex(fruit[j]);
                if(minIndex1 != minIndex2 && !ch[i] && !ch[j]){
                    //둘 다 이득이 되는 경우 (한 쪽이라도 minIndex가 바뀌면 안됨)
                    if(canChange(fruit[i], fruit[j], minIndex1, minIndex2)){
                        fruit[i][minIndex1]++;
                        fruit[i][minIndex2]--;
                        fruit[j][minIndex1]--;
                        fruit[j][minIndex2]++;

                        ch[i] = true;
                        ch[j] = true;
                        continue;
                    }
                }
            }answer += fruit[i][minIndex(fruit[i])];
        }
        return answer;
    }

    public static void main(String[] args){
        Fruit T = new Fruit();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}
