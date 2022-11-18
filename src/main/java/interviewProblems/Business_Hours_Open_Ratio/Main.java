package interviewProblems.Business_Hours_Open_Ratio;

// ---------------------------------- SOLVED ----------------------------------
// --------------------------- YELP / November 2020 --------------------------
/**
 * Original problem: EXAMPLE QUESTION FROM HACKER RANK
 *
 * Businesses on Yelp list the hours that they are open each day. We want to be able to calculate what percentage of a given time frame a business is open.
 * This can be useful to users who want to know how much of their free time a business is open.
 * Inputs:
 * There are two inputs:
 * A time range to query for (a start and an end time)
 * • A business's open hours (a list of time ranges)
 * Input processing has already been done for you.
 * Output:
 * The fraction OF THE QUERY TIME RANGE that the business is open.
 * (In other words, the percentage of the query time range in which the business is open.)
 * Return this number as a float. This function should NOT do any rounding.
 * Examples of time ranges:
 * 0-24
 * the whole day
 * 9-17
 * 9 AM to 5 PM
 * 18-23.75
 * 6 PM to 11:45 PM
 * Examples of open hours:
 * 0-24
 * 9.5-17
 * 11-14, 18-22
 * to 10 PM
 * closed the entire day open the entire day open from 9:30 AM to 5 PM
 * open from 11 AM to 2 PM, and from 6 PM
 * Assume that the open hours time ranges are in order and non-overlapping.
 * Furthermore, all time ranges start to end have the property 0 <= start < end <=
 * 24.
 *
 * Examples:
 * Query Time Range
 * 4-10
 * 7-11
 * 0-24
 * 5-22
 * Open Hours
 * 0-24
 * 9-17
 * 0-2, 20-24 (empty)
 * Answer
 * 1.0
 * 0.5
 * 0.25
 * 0.0
 */
class Main {
    public static void main(String[] args){

    }
}