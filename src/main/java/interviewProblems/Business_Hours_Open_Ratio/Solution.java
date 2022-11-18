package interviewProblems.Business_Hours_Open_Ratio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// <-- EXPAND to see the data classes
import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

class TimeRange {
    /*
    Represents a time range (the time between a start time and an end time)
    Example usage:
        time_range = TimeRange('3-5')
        System.out.println(time_range.start)
        3.0
     */
    float start;
    float end;

    TimeRange(String rangeString){
        String[] rangeSplit = rangeString.split("-");
        this.start = Float.valueOf(rangeSplit[0]);
        this.end = Float.valueOf(rangeSplit[1]);
    }
}

class Solution {

    public float openHoursRatio(TimeRange queryTimeRange, List<TimeRange> openHours) {
        // Edge case of no open hours
        if (openHours.size() == 0) return 0f;
        // Compute difference between start and end for each and
        // add it to the computation only if the difference is positive
        float coveredQuerySize = openHours.stream()
                .map(hours -> Math.min(hours.end, queryTimeRange.end) - Math.max(hours.start, queryTimeRange.start))
                .reduce(0f, (accum, elem) -> {
                    if (elem > 0) accum += elem;
                    return accum;
                });
        return coveredQuerySize / (queryTimeRange.end - queryTimeRange.start);
    }

    public static void main(String[] args) {
        try {
            // read input
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            TimeRange queryRange = new TimeRange(br.readLine());
            List<TimeRange> openHours = new ArrayList<>();
            String openHoursString = br.readLine();
            // if business has no open hours, then openHours will be an empty list
            if(!openHoursString.equals("")) {
                for(String rangeString: openHoursString.split(", ")){
                    openHours.add(new TimeRange(rangeString));
                }
            }

            // compute answer
            Solution solution = new Solution();
            float openHoursRatio = solution.openHoursRatio(queryRange, openHours);

            // print output to 2 decimal places
            DecimalFormat f = new DecimalFormat("#0.00");
            System.out.println(f.format(openHoursRatio));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}