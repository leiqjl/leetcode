package com.leiqjl;

import java.util.*;

/**
 * 2115. Find All Possible Recipes from Given Supplies - Medium
 */
public class FindAllPossibleRecipesFromGivenSupplies {
    //Topological Sort
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> set = new HashSet<>(Arrays.asList(supplies));
        int[] inDegrees = new int[recipes.length];
        HashMap<String, List<Integer>> dependencies = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            for (String ingredient : ingredients.get(i)) {
                if (!set.contains(ingredient)) {
                    if (!dependencies.containsKey(ingredient)) {
                        dependencies.put(ingredient, new ArrayList<>());
                    }
                    dependencies.get(ingredient).add(i);
                    inDegrees[i]++;
                }
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            result.add(recipes[poll]);
            if (dependencies.containsKey(recipes[poll])) {
                for (int i : dependencies.get(recipes[poll])) {
                    if (--inDegrees[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindAllPossibleRecipesFromGivenSupplies f = new FindAllPossibleRecipesFromGivenSupplies();
        //Input: recipes = ["bread"], ingredients = [["yeast","flour"]], supplies = ["yeast","flour","corn"]
        //Output: ["bread"]
        assert f.findAllRecipes(new String[]{"bread"}, List.of(Arrays.asList("yeast", "flour")), new String[]{"yeast", "flour", "corn"})
                .equals(List.of("bread"));
        //Input: recipes = ["bread","sandwich"], ingredients = [["yeast","flour"],["bread","meat"]], supplies = ["yeast","flour","meat"]
        //Output: ["bread","sandwich"]
        assert f.findAllRecipes(new String[]{"bread", "sandwich"}, List.of(Arrays.asList("yeast", "flour"), Arrays.asList("bread", "meat")),
                new String[]{"yeast", "flour", "meat"})
                .equals(List.of("bread", "sandwich"));
        //Input: recipes = ["bread","sandwich","burger"], ingredients = [["yeast","flour"],["bread","meat"],["sandwich","meat","bread"]], supplies = ["yeast","flour","meat"]
        //Output: ["bread","sandwich","burger"]
        assert f.findAllRecipes(new String[]{"bread","sandwich","burger"}, List.of(Arrays.asList("yeast", "flour"), Arrays.asList("bread", "meat"), Arrays.asList("sandwich","meat","bread")),
                        new String[]{"yeast", "flour", "meat"})
                .equals(List.of("bread","sandwich","burger"));
    }
}
