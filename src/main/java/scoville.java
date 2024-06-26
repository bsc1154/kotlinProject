import java.util.PriorityQueue;

public class scoville {
    //[1, 2, 3, 9, 10, 12]
    //7
    public int solution(int[] scoville, int k){
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();

        for(int i=0; i < scoville.length; i++){
            que.add(scoville[i]);
        }
        while(que.peek() < k){
            if(que.size() == 1)
                return -1;
            que.add(que.poll() + que.poll() * 2);
            answer++;
        }
        return answer;
    }
}
