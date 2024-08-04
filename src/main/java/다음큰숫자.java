class 다음큰숫자 {
    public int solution(int n) {
        int answer = 0;
        int cnt = 0;
        String str = Integer.toBinaryString(n);
        // 주어진수의 1의 개수를 센다.
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i) == 1) cnt++;
        }

        // 4. n+1부터 반복. ? 다음 수부터 비교해야 더 큰수와 비교 가능
        for(int i =n+1;i<1000000;i++){
            // 5. 위 과정을 반복.
            String temp = Integer.toBinaryString(i);
            int temp_cnt = 0;
            for(int j =0;j<temp.length();j++){
                if(temp.charAt(j) == '1') temp_cnt++;
            }
            // 6. 1인 비트의 수가 일치하면 해당 수를 담아 반복문 종료.
            if(temp_cnt == cnt) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
