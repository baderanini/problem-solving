class Cell {
    int hor = 0;
    int ver = 0;
    int d1 = 0;
    int d2 = 0;
    
    Cell() {}
    
    Cell(int hor, int ver, int d1, int d2) {
        this.hor = hor;
        this.ver = ver;
        this.d1 = d1;
        this.d2 = d2;
    }
    
    int getMax() {
        return Math.max(hor, Math.max(ver, Math.max(d1, d2)));
    }
}
class Solution {
    public int longestLine(int[][] mat) {
        int max = 0;
        Cell[][] cells = new Cell[mat.length][mat[0].length];
        for(int i = 0 ; i < mat.length ; i++) {
            for(int j = 0 ; j < mat[0].length ; j++) {
                if(mat[i][j] == 1)
                    cells[i][j] = updatedCell(cells, i, j);
                else
                    cells[i][j] = new Cell();
                max = Math.max(max, cells[i][j].getMax());
            }
        }
        return max;
    }
    
    Cell updatedCell(Cell[][] cells, int i, int j) {
        Cell updatedCell = new Cell(1,1,1,1);
        if(i-1 >= 0)
            updatedCell.ver += cells[i-1][j].ver;
        if(j-1 >= 0)
            updatedCell.hor += cells[i][j-1].hor;
        if(i-1 >= 0 && j-1 >= 0)
            updatedCell.d1 += cells[i-1][j-1].d1;
        if(i-1 >= 0 && j+1 < cells[0].length)
            updatedCell.d2 += cells[i-1][j+1].d2;
        return updatedCell;
    }
}