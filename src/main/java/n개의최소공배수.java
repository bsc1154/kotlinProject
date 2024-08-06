public class n개의최소공배수 {
    public int solution(int[] arr){
        int answer = arr[0];

        for(int num : arr){
            answer = gcd(answer, num);
        }

        return answer;
    }


    public int lcm(int a, int b){
        return a*b / gcd(a,b);
    }

    public int gcd(int a, int b){
        if(a < b){
            return (a == 0 ) ? b : a % b;
        }else{
            return (b == 0) ? a : b % a;
        }
    }
}
