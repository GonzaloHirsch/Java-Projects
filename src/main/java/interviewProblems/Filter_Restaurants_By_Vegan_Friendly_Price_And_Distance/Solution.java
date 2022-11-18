package interviewProblems.Filter_Restaurants_By_Vegan_Friendly_Price_And_Distance;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> result = Arrays.stream(restaurants)
                .filter(elem -> elem[2] >= veganFriendly && maxPrice >= elem[3] && maxDistance >= elem[4])
                .sorted((elemA, elemB) -> elemA[1] == elemB[1] ? Integer.compare(elemB[0], elemA[0]) : Integer.compare(elemB[1], elemA[1]))
                .map(elem -> elem[0])
                .collect(Collectors.toList());
        return result;
    }
}