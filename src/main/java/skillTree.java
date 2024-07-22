class skillTree {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String skillTree : skill_trees){
            if(isValidCheck(skill, skillTree)){
                answer++;
            }
        }
        return answer;
    }

    public boolean isValidCheck(String skill, String skillTree){
        int prevIdx = -1;
        for(char currentSkill : skillTree.toCharArray()){
            int currentIdx = skill.indexOf(currentSkill);
            if(currentIdx > prevIdx + 1){
                return false;
            }

            if(currentIdx == prevIdx + 1){
                prevIdx = currentIdx;
            }
        }

        return true;
    }
}
