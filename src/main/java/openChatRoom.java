import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class openChatRoom {
    public String[] solution(String [] args){
        List<String> list = new ArrayList<String>();
        HashMap<String,String> data = new HashMap<String,String>();
        for(String r : args){
            StringTokenizer st = new StringTokenizer(r);
            String doing = st.nextToken();
            String userId = st.nextToken();
            String nickName = "";
            //떠난게 아닐경우는 닉네임이 필요하다.
            if(!doing.equals("Leave")){
                nickName = st.nextToken();
            }

            if(doing.equals("Enter")){
                data.put(userId,nickName);
                list.add(userId+"님이 들어왔습니다.");
            }

            if(doing.equals("Change")){
                data.put(userId,nickName);
            }

            if(doing.equals("Leave")){
                list.add(userId+"님이 나갔습니다.");
            }
        }

        String [] answer = new String[list.size()];
        int idx = 0;
        for(String a : list){
            //
            int endOfId = a.indexOf("님");
            String endUserId = a.substring(0,endOfId);
            //아이디뽑기
            answer[idx++]= a.replace(endUserId,data.get(endUserId));
            //아이디를 아이디의 네임으로 치환
        }
        return answer;
    }
}
