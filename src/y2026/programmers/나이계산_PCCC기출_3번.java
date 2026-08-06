package y2026.programmers;

/*
Korea면 한국식 나이, Year면 연 나이 출력
* */

public class 나이계산_PCCC기출_3번 {

    public static int solution(int year, String age_type){
      int answer;

      if(age_type.equals("Korea")){
          answer = 2030 - year + 1;
      }else{
          answer = 2030 - year;
      }

      return answer;
    }


    public static void main(String[] args) {
        System.out.println(solution(2000, "Korea"));
        System.out.println(solution(1999, "Year"));
    }
}
