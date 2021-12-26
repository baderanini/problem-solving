class Solution {
    public boolean isHappy(int n) {
        int fast = n, slow = n;
        do {
            slow = sumOfSquares(slow);
            if(fast == 1)
                return true;
            fast = sumOfSquares(fast);
            if(fast == 1)
                return true;
            fast = sumOfSquares(fast);
            if(fast == 1)
                return true;
        } while(fast != slow);
        
        return false;
    }
    
    int sumOfSquares(int n) {
        int sum = 0;
        while(n > 0) {
            sum += (n%10) * (n%10);
            n /= 10;
        }
        
        return sum;
    }
}