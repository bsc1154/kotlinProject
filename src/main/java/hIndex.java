import java.util.*;
public class hIndex {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);//오름차순정렬

        for (int i = 0; i < citations.length; i++) { //논문 개수
            int h = citations.length - i; //인용된 논문 수

            if (citations[i] >= h) { //인용된 논문이 이상인것
                answer = h;
                break;
            }
        }

        return answer;
    }
}
