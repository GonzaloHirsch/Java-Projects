package interviewProblems.Business_Review_Stats;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
// <-- EXPAND to see the data classes
import java.io.*;
import java.util.*;
import java.time.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import java.util.stream.Collectors;
import java.math.BigDecimal;

class Review {
    int reviewId;
    int rating;
    String date;

    public Review(JSONObject jsonReview) {
        this.reviewId = ((Long) jsonReview.get("review_id")).intValue();
        this.rating = ((Long) jsonReview.get("rating")).intValue();
        this.date = (String) jsonReview.get("date");
    }

    public int getReviewId() { return this.reviewId; }
    public int getRating() { return this.rating; }
    public String getDate() { return this.date; }
}


class ReviewStats {
    String newestDate;
    String oldestDate;
    int count;
    double averageRating;

    public ReviewStats(String newestDate, String oldestDate, int count, double averageRating) {
        this.newestDate = newestDate;
        this.oldestDate = oldestDate;
        this.count = count;
        this.averageRating = averageRating;
    }

    public String getNewestDate() { return newestDate; }
    public String getOldestDate() { return oldestDate; }
    public double getAverageRating() { return averageRating; }
    public int getCount() { return count; }
}


class Solution {
    // Function to round to nearest half
    // Math.round will round to nearest integer
    // All numbers ending in .25 to .74 will end up adding an entire unit, then add .5 when divided by 2
    // Numbers ending in .0 to .24 will just be 2 * floor(number), so won't add a decimal
    // Numbers ending in .75 to .0 will add 2 units, then add 1 when divided by 2
    private float roundToNearestHalf(float n) {
        return Math.round(n * 2) / 2f;
    }

    public ReviewStats calculateBusinessReviewStats(List<Review> reviews) {
        // Left input example for clarity
    /*
        Example input:
        [
            Review({
                "review_id": 1,
                "date": "2021-01-02",
                "rating": 4
            }),
            Review({
                "review_id": 2,
                "date": "2021-01-15",
                "rating": 4
            }),
            Review({
                "review_id": 3,
                "date": "2021-01-15",
                "rating": 5
            }),
            Review({
                "review_id": 4,
                "date": "2021-01-15",
                "rating": 5
            })
        ]

        Example output:
        newest review: 2021-01-15
        oldest review: 2021-01-02
        review count: 4
        average rating: 4.5

        Explanation:
        The most recent review has the latest date 2021-01-15.
        The oldest review has the earliest date 2021-01-02.
        The number of reviews is the size of the list. Review_ids may not be unique.
        The average review rating is (4+4+5+5)/4 = 4.5. Should be rounded to nearest 0.5 value.
        */

        /*
            Went for a more functional approach instead of doing everything in one pass.
            It is cleaner in terms of adding more analytics in the future, we would have
            to add an isolated line of code instead of having to modify a loop that computes
            many other items.
        */

        // The number of reviews is just the size of the list
        int reviewCount = reviews.size();

        /*
            The rating is computed using a stream and rounded using a custom function.
            In case the number of reviews is 0, we avoid a division by zero by setting
            0 as the default rating if no reviews. Although no provided test cases fail
            because of this, it should be handled.
        */
        float averageRating = reviewCount > 0 ? this.roundToNearestHalf(
                reviews.stream()
                        .map(elem -> elem.getRating())
                        .reduce(0, (accum, curr) -> accum + curr) / (float) reviewCount
        ) : 0;

        /*
            Sorting the reviews to get both the newest & oldest reviews.
            Newest will be at the end of the list, oldest at the start.
            This order makes sense from a data structure point of view.
        */
        reviews.sort((reviewA, reviewB) -> reviewA.getDate().compareTo(reviewB.getDate()));

        return new ReviewStats(
            /*
                Must check if there are reviews before trying to get the oldest/newest.
                Instructions didn't specify what to do with this, I decided to return null
                instead of a String with an invalid date (empty).
            */
                reviewCount > 0 ? reviews.get(reviewCount - 1).getDate() : null,
                reviewCount > 0 ? reviews.get(0).getDate() : null,
                reviewCount,
                averageRating
        );
    }

    public static void main(String[] args) {
        try {
            /*
             *  Parse the input as a list of Review objects
             */
            String jsonString = new BufferedReader(new InputStreamReader(System.in))
                    .lines().collect(Collectors.joining("\n"));

            JSONArray jsonReviews = (JSONArray) new JSONParser().parse(jsonString);
            List<Review> reviews = (List<Review>) jsonReviews.stream().map(
                    review -> new Review((JSONObject) review)
            ).collect(Collectors.toList());

            /**
             * Calculate review statistics
             */
            ReviewStats solution = new Solution().calculateBusinessReviewStats(reviews);

            /*
             *  Print the desired review statistics
             */
            System.out.println(String.format("newest review: %s", solution.getNewestDate()));
            System.out.println(String.format("oldest review: %s", solution.getOldestDate()));
            System.out.println(String.format("review count: %d", solution.getCount()));
            System.out.println(String.format("average rating: %.1f", solution.getAverageRating()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}