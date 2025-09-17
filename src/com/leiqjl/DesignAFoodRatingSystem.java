package com.leiqjl;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 2353. Design a Food Rating System - Medium
 */
public class DesignAFoodRatingSystem {
    class FoodRatings {
        private Map<String, Integer> foodToRatingMap = new HashMap<>();
        private Map<String, String> foodToCuisineMap = new HashMap<>();
        private Map<String, TreeSet<Pair<String, Integer>>> cuisineToFoodsMap = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                foodToRatingMap.put(foods[i], ratings[i]);
                foodToCuisineMap.put(foods[i], cuisines[i]);
                cuisineToFoodsMap.computeIfAbsent(cuisines[i], k -> new TreeSet<>((a, b) -> {
                    int compareByRating = Integer.compare(a.getV(), b.getV());
                    if (compareByRating == 0) {
                        // If ratings are equal, compare by food name (in ascending order).
                        return a.getK().compareTo(b.getK());
                    }
                    return compareByRating;
                })).add(new Pair(-ratings[i], foods[i]));
            }
        }

        public void changeRating(String food, int newRating) {
            String cuisine = foodToCuisineMap.get(food);

            TreeSet<Pair<String, Integer>> cuisineSet = cuisineToFoodsMap.get(cuisine);
            Pair<String, Integer> oldElement = new Pair<>(food, -foodToRatingMap.get(food));
            cuisineSet.remove(oldElement);


            foodToRatingMap.put(food, newRating);

            cuisineSet.add(new Pair<>(food, -newRating));
        }

        public String highestRated(String cuisine) {
            return cuisineToFoodsMap.get(cuisine).first().getK();
        }
    }

}

