package interviewProblems.Walking_Robot_Simulation_II;
class Robot {
    private int[] direction;
    private String[] directions;
    private int[][] positions;
    private int n;
    private int stepCount;

    public Robot(int width, int height) {
        this.n = 2 * width + 2 * height - 4;
        this.stepCount = 0;
        this.directions = new String[n];
        this.directions[0] = "East";
        this.positions = new int[n][];
        this.positions[0] = new int[]{0,0};
        this.direction = new int[]{1,0};
        this.precomputeSteps(width, height);
    }

    public void precomputeSteps(int width, int height) {
        int x = 0, y = 0, targetX = 0, targetY = 0, i = 0;
        while (i < n) {
            targetX = x + this.direction[0];
            targetY = y + this.direction[1];
            if (targetX >= width || targetX < 0 || targetY >= height || targetY < 0) this.turn();
            else {
                i++;
                this.positions[i % n] = new int[]{targetX, targetY};
                this.directions[i % n] = this.getDirInternal();
                x = targetX;
                y = targetY;
            }
        }
    }

    public void step(int num) {
        this.stepCount += num;
    }

    public int[] getPos() {
        return this.stepCount > 0 ? this.positions[this.stepCount % n] : new int[]{0,0};
    }

    public String getDir() {
        return this.stepCount > 0 ? this.directions[this.stepCount % n] : "East";
    }

    public String getDirInternal() {
        if (this.direction[0] == 1) {
            return "East";
        } else if (this.direction[0] == -1) {
            return "West";
        } else if (this.direction[1] == 1) {
            return "North";
        } else if (this.direction[1] == -1) {
            return "South";
        }
        return null;
    }

    private void turn() {
        // East
        if (this.direction[0] == 1) {
            this.direction[0] = 0;
            this.direction[1] = 1;
        }
        // West
        else if (this.direction[0] == -1) {
            this.direction[0] = 0;
            this.direction[1] = -1;
        }
        // North
        else if (this.direction[1] == 1) {
            this.direction[0] = -1;
            this.direction[1] = 0;
        }
        // South
        else if (this.direction[1] == -1) {
            this.direction[0] = 1;
            this.direction[1] = 0;
        }
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */