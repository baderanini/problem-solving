class Replacement {
    String src;
    String target;
    
    Replacement(String src, String target) {
        this.src = src;
        this.target = target;
    }
}

class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        
        
        Replacement[] replacements = new Replacement[s.length()];

        for(int i = 0 ; i < indices.length ; i++) {
            int sP = indices[i], srcP = 0;
            String src = sources[i], target = targets[i];
            
            while(sP < s.length() && srcP < src.length() && s.charAt(sP) == src.charAt(srcP)) {
                sP++;
                srcP++;
            }
            if(srcP == src.length()) {
                replacements[indices[i]] = new Replacement(src, target);
            }
        }
        
        StringBuilder resultStringBuilder = new StringBuilder();
        
        for(int i = 0 ; i < s.length() ; i++) {
            if(replacements[i] != null) {
                resultStringBuilder.append(replacements[i].target);
                i += replacements[i].src.length() - 1;
            } else {
                resultStringBuilder.append(s.charAt(i));
            }
        }
        
        return resultStringBuilder.toString();
    }
}