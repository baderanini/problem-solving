class Solution {
    public int minArea(char[][] image, int x, int y) {
        int upper = findUpperLimit(image, 0, x-1);
        int lower = findLowerLimit(image, x+1, image.length-1);
        
        int left = findLeftLimit(image, 0, y-1);
        int right = findRightLimit(image, y+1, image[0].length-1);
                
        return (lower-upper-1) * (right-left-1);
    }
    
    int findUpperLimit(char[][] image, int l, int h) {
        while(l <= h) {
            int mid = l+(h-l)/2;
            if(rowAllZeros(image, mid)) {
                l = mid+1;
            } else {
                h = mid-1;
            }
        }
        return h;
    }
    
    int findLowerLimit(char[][] image, int l, int h) {
        while(l <= h) {
            int mid = l+(h-l)/2;
            if(rowAllZeros(image, mid)) {
                h = mid-1;
            } else {
                l = mid+1;
            }
        }
        return l;
    }
    
    int findLeftLimit(char[][] image, int l, int h) {
        while(l <= h) {
            int mid = l+(h-l)/2;
            if(colAllZeros(image, mid)) {
                l = mid+1;
            } else {
                h = mid-1;
            }
        }
        return h;
    }
    
    int findRightLimit(char[][] image, int l, int h) {
        while(l <= h) {
            int mid = l+(h-l)/2;
            if(colAllZeros(image, mid)) {
                h = mid-1;
            } else {
                l = mid+1;
            }
        }
        return l;
    }
    
    boolean rowAllZeros(char[][] image, int row) {
        for(int j = 0 ; j < image[0].length ; j++)
            if(image[row][j] == '1')
                return false;
        return true;
    }
    
    boolean colAllZeros(char[][] image, int col) {
        for(int i = 0 ; i < image.length ; i++)
            if(image[i][col] == '1')
                return false;
        return true;
    }
}