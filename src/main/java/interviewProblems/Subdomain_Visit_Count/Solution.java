package interviewProblems.Subdomain_Visit_Count;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> visits = new HashMap<>();
        // Some variables to hold different parts
        String[] parts;
        int visitNumber;
        String domain;
        // Iterate on all domains
        for (String s : cpdomains) {
            // Split the pair
            parts = s.split(" ");
            // Get each part
            visitNumber = Integer.parseInt(parts[0]);
            domain = parts[1];
            // Split domain
            parts = domain.split("\\.");
            // Store each of the values
            domain = "";
            for (int i = parts.length - 1; i >= 0; i--) {
                if (domain.isEmpty()) domain = parts[i];
                else domain = parts[i] + "." + domain;
                visits.put(domain, visits.getOrDefault(domain, 0) + visitNumber);
            }
        }
        // Join everything
        return visits.entrySet().stream()
                .map(item -> item.getValue() + " " + item.getKey())
                .collect(Collectors.toList());
    }
}