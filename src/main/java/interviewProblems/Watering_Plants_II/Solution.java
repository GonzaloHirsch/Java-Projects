package interviewProblems.Watering_Plants_II;


class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int total = 0;
        for (int a = 0, b = plants.length - 1, wa = capacityA, wb = capacityB; a <= b; a++, b--) {
            // Reached the same plant
            if (a == b) {
                if ((wa >= wb && wa < plants[a]) || (wa < wb && wb < plants[b])) total++;
            } else {
                if (wa < plants[a]) {
                    total++;
                    wa = capacityA;
                }
                wa -= plants[a];
                if (wb < plants[b]) {
                    total++;
                    wb = capacityB;
                }
                wb -= plants[b];
            }
        }

        return total;
    }
}