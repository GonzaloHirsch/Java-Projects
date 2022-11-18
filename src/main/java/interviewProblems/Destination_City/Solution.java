package interviewProblems.Destination_City;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    /*
    * NOTE: It cannot be done using a concatenation of stream operations because the reduction
    *       requires all the origins to be populated
    * */
    public String destCity(List<List<String>> paths) {
        // Initialize origins with set size
        Set<String> origins = new HashSet<>(paths.size());
        // Populate all origins
        paths.stream().forEach(elem -> origins.add(elem.get(0)));
        // Get the results by reducing the stream
        List<String> result = paths.stream().reduce(null, (accum, element) -> {
            if (!origins.contains(element.get(1))) accum = element;
            return accum;
        });
        return result.get(1);
    }
}