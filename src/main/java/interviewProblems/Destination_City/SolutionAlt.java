package interviewProblems.Destination_City;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SolutionAlt {
    public String destCity(List<List<String>> paths) {
        // Need to compare all destinations to all outgoing
        // Comparison should be done in O(1)
        // Should be done in 1 pass
        // Collections to store everything and handle it in 1 pass
        Set<String> destinations = new HashSet<>();
        Set<String> origins = new HashSet<>(paths.size());
        String pathOrigin, pathDestination;
        for (List<String> path : paths) {
            pathOrigin = path.get(0);
            pathDestination = path.get(1);
            // Always add the origins to keep track of them
            origins.add(pathOrigin);
            // If the path origin is a destination, we need to remove it from the unique destionations
            if (destinations.contains(pathOrigin)) destinations.remove(pathOrigin);
            // If the destination is not an origin for another path, add it
            if (!origins.contains(pathDestination)) destinations.add(pathDestination);
        }
        return destinations.iterator().next();
    }
}