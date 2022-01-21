class Solution {
    public int countSquares(int[][] matrix) {
        int[][] ups = new int[matrix.length][matrix[0].length];
        int[][] lefts = new int[matrix.length][matrix[0].length];
        
        for(int i = 0 ; i < matrix.length ; i++) {
            for(int j = 0; j < matrix[0].length ; j++) {
                if(matrix[i][j] == 1) {
                    ups[i][j] = 1;
                    lefts[i][j] = 1;
                    if(i-1 >= 0)
                        ups[i][j] += ups[i-1][j];
                    if(j-1 >= 0)
                        lefts[i][j] += lefts[i][j-1];
                }
            }
        }
                
        int count = 0;
        for(int i = 0 ; i < matrix.length ; i++) {
            for(int j = 0; j < matrix[0].length ; j++) {
                if(matrix[i][j] == 1) {
                    if(i-1 >= 0 && j-1 >= 0) {
                        matrix[i][j] = 1 + Math.min(matrix[i-1][j-1], Math.min(ups[i][j]-1, lefts[i][j]-1));
                        count += matrix[i][j];
                    } else
                        count++;
                }
            }
        }
        
        return count;
    }
}