class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] res = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        for(int[] log: logs) {
            map.putIfAbsent(log[0], new HashSet<>());
            map.get(log[0]).add(log[1]);
        }
        
        for(Set<Integer> mins: map.values()) {
         res[mins.size()-1]++;   
        }
        
        return res;
    }
}