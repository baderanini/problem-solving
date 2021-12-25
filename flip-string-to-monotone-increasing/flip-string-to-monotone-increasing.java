class Solution {
    public int minFlipsMonoIncr(String s) {
        int ones = 0, zeros = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) == '0')
                zeros++;
            else
                ones++;
        }
    



        int onesBefore = 0, zerosBefore = 0;
        int minFlips = ones;
        for(int i =  0; i < s.length() ; i++) {
            char curr = s.charAt(i);

            int onesAfter = ones - onesBefore - (curr == '1' ? 1 : 0);
            int zerosAfter = zeros - zerosBefore - (curr == '0' ? 1 : 0);

            int withMeAsOne = onesBefore + zerosAfter + (curr == '1' ? 0 : 1);
            minFlips = Math.min(minFlips, withMeAsOne);

            if(curr == '0')
                zerosBefore++;
            else
                onesBefore++;
        }

        return minFlips;
    }
}


/*

00110


*/