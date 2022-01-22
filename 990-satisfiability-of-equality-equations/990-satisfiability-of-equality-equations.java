class Solution {
    public boolean equationsPossible(String[] equations) {
        Integer[] parents = new Integer[26];
        
        for(String equation: equations) {
            if(equation.contains("==")) {
                String[] tokens = equation.split("==");
                int c1 = tokens[0].charAt(0)-'a', c2 = tokens[1].charAt(0)-'a';
                if(parents[c1] == null)
                    parents[c1] = c1;
                if(parents[c2] == null)
                    parents[c2] = c2;
                
                union(parents, c1, c2);
            }
        }
        
        for(String equation: equations) {
            if(equation.contains("!=")) {
                String[] tokens = equation.split("!=");
                int c1 = tokens[0].charAt(0)-'a', c2 = tokens[1].charAt(0)-'a';
                if(parents[c1] == null)
                    parents[c1] = c1;
                if(parents[c2] == null)
                    parents[c2] = c2;
                if(find(parents, c1) == find(parents, c2))
                    return false;
            }
        }
        
        return true;
    }
    
    void union(Integer[] parents, int x, int y) {
        int xp = find(parents, x);
        int yp = find(parents, y);
        
        parents[xp] = yp;
    }
    
    int find(Integer[] parents, int x) {
        if(parents[x] != x)
            return find(parents, parents[x]);
        else
            return x;
    }
}