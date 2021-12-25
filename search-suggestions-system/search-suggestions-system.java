class Solution {
    
    
    class TrieNode {
        boolean end = false;
        TreeMap<Character, TrieNode> children = new TreeMap<>();
    }
    
    
    
    
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = fillProducts(products);
        
        
        List<List<String>> res = new ArrayList<>();
        
        StringBuilder prefix = new StringBuilder();
        for(int i = 0 ; i < searchWord.length() ; i++) {
            prefix.append(searchWord.charAt(i));
            List<String> subRes = new ArrayList<>();
            
            getWords(prefix.toString(), root, subRes);
            
            res.add(subRes);
        }
        
        return res;
    }
    
    
    void getWords(String prefix, TrieNode root, List<String> res) {
        TrieNode curr = root;
        
        for(int i = 0 ; i < prefix.length() ; i++) {
            char c = prefix.charAt(i);
            if(curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else {
                return;
            }
        }
        
        autoComplete(curr, res, new StringBuilder(prefix), 3);
    }
    
    int autoComplete(TrieNode root, List<String> res, StringBuilder sb, int required) {
        int taken = 0;
        if(required <= 0)
            return taken;
        if(root.end) {
            res.add(sb.toString());
            taken++;
        }
        
        for(char child: root.children.keySet()) {
            if(required-taken > 0) {
                StringBuilder newSb = new StringBuilder(sb);
                newSb.append(child);
                taken += autoComplete(root.children.get(child), res, newSb, required-taken);
            }
        }
        
        return taken;
    }
    
    
    TrieNode fillProducts(String[] products) {
        TrieNode root = new TrieNode();
        
        for(int i = 0 ; i < products.length ; i++) {
            
            String product = products[i];
            TrieNode curr = root;
            for(int j = 0 ; j < product.length() ; j++) {
                char c = product.charAt(j);
                curr.children.putIfAbsent(c, new TrieNode());
                curr = curr.children.get(c);
            }
            
            curr.end = true;
        }
        
        return root;
    }
}