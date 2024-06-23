import java.util.*;
class Solution {
    public String solution(String number, int k) {

        //"1924"  제거할 숫자 개수2
        // 그리디 알고리즘
        // 각 자리에서 최고로 높은 수가 나오는 경우를 생각하기

        String answer = "";
        StringBuilder answerBuilder = new StringBuilder();


        char[] array = number.toCharArray();

        int len = array.length - k;

        // 문자 비교를 시작하는 인덱스를 나타내는 start 변수
        int start = 0;

        for(int i=0; i<len; i++){
            char max = '0';
            for(int j = start; j <= i;j++){
                if(array[j] > max){
                    max = array[j];
                    start=j+1;
                }

            }
        }

        // k개의 수를 제거할 때 얻을 수 있는 가장 큰 숫자를 구하려 한다
        answer = answerBuilder.toString();
        return answer;
    }

}
