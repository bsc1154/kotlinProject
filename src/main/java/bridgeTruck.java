import java.util.LinkedList;
import java.util.Queue;

class bridgeTruck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<currentTruck> bridge = new LinkedList<>();
        int currentBridgeWeight = 0;
        int com = 0;
        int time = 0;
        int index = 0;

        while (index < truck_weights.length) {
            if (!bridge.isEmpty() && time - bridge.peek().time == bridge_length) {
                currentTruck truck = bridge.poll();
                currentBridgeWeight -= truck.weight;//현재 다리에 가해진무게 - 빠져나간 트럭의 무게
            }

            //지나고있는 사이즈가 최대사이즈보다크면 다음턴
            if (bridge.size() >= bridge_length) {
                continue;
            }

            //현재 다리에 가해진 무개에 다음 트럭이 올라탔을때 > 다리가 견딜수있는 최대 무게면 다음턴
            if (currentBridgeWeight + truck_weights[index] > weight) {
                continue;
            }

            //현재 다리에 가해진무게에 추가 트럭무게를 더한다.
            currentBridgeWeight += truck_weights[index];


            //현재 다리에 가해진 무게와, 사이즈, 진입시간 초기화를 위한 로직
            currentTruck currentTruck = new currentTruck();
            currentTruck.setWeight(truck_weights[index]);
            currentTruck.setTime(time);
            bridge.add(currentTruck);

            index++;
        }

        return time + bridge_length;
    }



    class currentTruck{
        private int weight;
        private int time;

        public int getWeight(int weight){
            return this.weight;
        }

        public void setWeight(int weight){
            this.weight = weight;
        }


        public int getTime(int time){
            return this.time;
        }

        public void setTime(int time){
            this.time = time;
        }
    }
}