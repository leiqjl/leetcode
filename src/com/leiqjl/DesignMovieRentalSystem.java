package com.leiqjl;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1912. Design Movie Rental System - Hard
 */
public class DesignMovieRentalSystem {
    //1 <= n <= 3 * 10^5
    //1 <= entries.length <= 10^5
    //0 <= shopi < n
    //1 <= moviei, pricei <= 10^4
    //Each shop carries at most one copy of a movie moviei.
    //At most 105 calls in total will be made to search, rent, drop and report.
    class MovieRentingSystem {
        //shop, movie, price
        Comparator<int[]> comparator = (a, b) -> {
            if (a[2] != b[2]) {
                return a[2] - b[2];
            }
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        };

         private int key(int shop, int movie) {
            return shop * 10_001 + movie;
        }

        Map<Integer, Set<int[]>> unrentedMap = new HashMap<>(); // Map moveId -> TreeSet of Entries
        Map<Integer, Integer> priceMap = new HashMap<>(); // Map (shop, movie) -> price
        TreeSet<int[]> rentedSet = new TreeSet<>(comparator);
        public MovieRentingSystem(int n, int[][] entries) {
            for (int[] entry : entries) {
                int shop = entry[0];
                int movie = entry[1];
                int price = entry[2];
                unrentedMap.computeIfAbsent(movie, x -> new TreeSet<>(comparator)).add(entry);
                int key = key(shop, movie);
                priceMap.put(key, price);
            }
        }

        //Search: Finds the cheapest 5 shops that have an unrented copy of a given movie.
        // The shops should be sorted by price in ascending order, and in case of a tie, the one with the smaller shopi should appear first.
        // If there are less than 5 matching shops, then all of them should be returned.
        // If no shop has an unrented copy, then an empty list should be returned.
        public List<Integer> search(int movie) {
            Set<int[]> entries = unrentedMap.get(movie);
            if (entries == null || entries.isEmpty()) {
                return new ArrayList<>();
            }
            return entries.stream().limit(5).map(e->e[0]).collect(Collectors.toList());
        }

        //Rent: Rents an unrented copy of a given movie from a given shop.
        public void rent(int shop, int movie) {
            int price = priceMap.get(key(shop, movie));
            int[] entry = {shop, movie, price};
            rentedSet.add(entry);
            unrentedMap.get(movie).remove(entry);
        }

        //Drop: Drops off a previously rented copy of a given movie at a given shop.
        public void drop(int shop, int movie) {
            int price = priceMap.get(key(shop, movie));
            int[] entry = {shop, movie, price};
            rentedSet.remove(entry);
            unrentedMap.get(movie).add(entry);
        }

        //Report: Returns the cheapest 5 rented movies (possibly of the same movie ID) as a 2D list res
        // where res[j] = [shopj, moviej] describes that the jth cheapest rented movie moviej was rented from the shop shopj.
        // The movies in res should be sorted by price in ascending order, and in case of a tie, the one with the smaller shopj should appear first,
        // and if there is still tie, the one with the smaller moviej should appear first.
        // If there are fewer than 5 rented movies, then all of them should be returned.
        // If no movies are currently being rented, then an empty list should be returned.
        public List<List<Integer>> report() {
            return rentedSet.stream().limit(5).map(e->List.of(e[0],e[1])).collect(Collectors.toList());
        }
    }
}
