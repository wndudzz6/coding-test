package simulation.again;

public class Fruit {

    int getMinIndex(int[] fruit){
        int min = getMin(fruit);
        int index = 0;
        for(int i = 0; i<fruit.length; i++){
            if(min == fruit[i]) index = i;
        }
        return index;
    }

    boolean isMinUnique(int[] fruit){
        int min = getMin(fruit);
        int cnt = 0;
        for(int x : fruit){
            if(min == x) cnt++;
        }

        return cnt == 1;
    }

    //내가 만들어본 쪼개기 함수
    boolean canExchange(int[] a, int[] b){
        if(getMinIndex(a) == getMinIndex(b)) return false;
        if(!isMinUnique(a) || !isMinUnique(b)) return false;

        int am = getMinIndex(a);
        int bm = getMinIndex(b);
        if(am>=0 && bm>=0) {
            if(a[am]+1 > a[bm]-1 || b[am]-1 < b[bm]+1) return false;
        }


        return true;
    }

    int getMin(int[] fruit){
        int min = Integer.MAX_VALUE;
        for(int x : fruit){
            min = Math.min(min, x);
        }
        return min;
    }


    public int solution(int[][] fruit){
        int answer = 0;
        int n = fruit.length;
        int[] ch = new int[n];

        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                if(canExchange(fruit[i], fruit[j])){
                    if(ch[i] == 0 && ch[j] == 0) {
                        int a = getMinIndex(fruit[i]);
                        int b = getMinIndex(fruit[j]);
                        fruit[i][a]++;
                        fruit[i][b]--;
                        fruit[j][a]--;
                        fruit[j][b]++;

                        ch[i] = 1;
                        ch[j] = 1;

                        break;
                    }
                }
            }
        }
        for(int[] x : fruit){
            answer += getMin(x);
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
