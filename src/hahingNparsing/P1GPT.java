package hahingNparsing;

public class P1GPT {
    public int solution(String s){
        int answer = -1;
        int[] ch = new int[28];
        char[] c = s.toCharArray();
        for(char x : c){
            ch[x-'a']++;
        }
        for (int i = 0; i < c.length; i++) {
            if (ch[c[i] - 'a'] == 1) return i+1;
        }

        return answer;
    }

    public static void main(String[] args){
        P1GPT T = new P1GPT();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}
