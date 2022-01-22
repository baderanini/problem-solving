class Solution {
    Set<String> visited = new HashSet<>();
    public int minFlips(int[][] mat) {
        
        Queue<int[][]> q = new LinkedList<>();
        String allZeros = serializeMatrix(new int[mat.length][mat[0].length]);
        
        q.offer(mat);
        int steps = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i = 0 ; i < size ; i++) {
                int[][] currMat = q.poll();
                
                String serialized = serializeMatrix(currMat);
                if(!visited.contains(serialized)) {
                    visited.add(serialized);
                    if(serialized.equals(allZeros))
                        return steps;
                    for(int r = 0 ;  r < currMat.length ; r++) {
                        for(int c = 0 ; c < currMat[0].length ; c++) {
                            q.offer(flip(currMat, r, c));
                        }
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
    
    String serializeMatrix(int[][] mat) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < mat.length ; i++) {
            for(int j = 0 ; j < mat[0].length ; j++)
                sb.append(mat[i][j]);
        }
        
        return sb.toString();
    }
    
    int[][] flip(int[][] mat, int i, int j) {
        int[][] newMat = new int[mat.length][mat[0].length];
        for(int r = 0 ; r < mat.length ; r++) {
            for(int c = 0 ; c < mat[0].length ; c++) {
                if((r==i && c==j) || (r==i+1 && c==j) || (r==i-1 && c==j) || (r==i && c==j+1) || (r==i && c==j-1)) {
                    newMat[r][c] = mat[r][c] == 0 ? 1 : 0;
                } else 
                    newMat[r][c] = mat[r][c];
            }
        }
        
        return newMat;
    }
}