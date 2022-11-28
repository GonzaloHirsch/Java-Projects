package interviewProblems.Day_Of_The_week;


class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        if (month <= 2) year--;
        int C = (int)Math.floor(year / 100);
        int Y = year % 100;
        int M = (month >= 3 ? month - 2 : month + 10);

        return days[
                ((((day +
                        (int)Math.floor(2.6 * M - 0.2) -
                        2 * C + Y + Y/4 + C/4)) % 7) + 7) % 7
                ];
    }
}