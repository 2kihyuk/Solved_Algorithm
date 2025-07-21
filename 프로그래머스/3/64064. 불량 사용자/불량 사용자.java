import java.util.*;
class Solution {
    Set<Set<String>> result = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        dfs(user_id,banned_id,0,new HashSet<>());
        
        return result.size();
    }
    
    public void dfs(String[] user_id, String[]banned_id, int depth, Set<String> current){
        
        if(depth == banned_id.length){
            result.add(new HashSet<>(current));
            return;
        }
        
        String ban = banned_id[depth];
        
        
            
            for(String id : user_id){
                if(current.contains(id)) continue;
                if(isMatch(id,ban)){
                    current.add(id);
                    dfs(user_id,banned_id,depth+1,current);
                    current.remove(id);
                }
        }
    }
    boolean isMatch(String user, String ban){
        if(user.length() != ban.length()) return false;
        
        for(int i =0;i<user.length();i++){
            if(ban.charAt(i) == '*') continue;
            if(ban.charAt(i) != user.charAt(i)) return false;
        }
        return true;
    }
}