class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> result = new ArrayList<>();
        
        Set<String> suppliesSet = new HashSet<>();
        for(String supply: supplies)
            suppliesSet.add(supply);
        
        Map<String, Set<String>> ingredientsMap = new HashMap<>();
        
        for(int i = 0 ; i < recipes.length ; i++) {
            ingredientsMap.put(recipes[i], new HashSet<>());
            for(String ingredient: ingredients.get(i))
                ingredientsMap.get(recipes[i]).add(ingredient);
        }
        
        Map<String, Boolean> state = new HashMap<>();
        
        for(String s: recipes)
            if(dfs(s, ingredientsMap, suppliesSet, state))
                result.add(s);
        
        return result;
    }
    
    boolean dfs(String recipe, Map<String, Set<String>> ingredientsMap, Set<String> suppliesSet, Map<String, Boolean> state) {
        if(suppliesSet.contains(recipe))
            return true;
        
        if(state.containsKey(recipe)) {
            return state.get(recipe);
        }
        
        state.put(recipe, false);
        
        boolean result = true;
        Set<String> ingradients = ingredientsMap.get(recipe);
        if(ingradients == null)
            result = false;
        else {
            for(String ingradient: ingradients) {
                if(!dfs(ingradient, ingredientsMap, suppliesSet, state)) {
                    result = false;
                    break;
                }
            }
        }
        
        state.put(recipe, result);
        
        return result;
    }
}