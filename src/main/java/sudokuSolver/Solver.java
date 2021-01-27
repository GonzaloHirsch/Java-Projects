package sudokuSolver;

import java.util.*;

public class Solver {
    private Number[][] board;

    private HashSet<Integer> squareNumbers = new HashSet<>();
    private HashSet<Integer> verticalNumbers = new HashSet<>();
    private HashSet<Integer> horizontalNumbers = new HashSet<>();

    private int squareX;
    private int squareY;

    private Deque<Number> visitedNumbers = new ArrayDeque<>(81);
    private Deque<Number> numbersToVisit = new ArrayDeque<>(81);

    public Solver(int[][] board){
        this.board = new Number[9][9];

        for(int y = 0; y < 9; y++){
            for(int x = 0; x < 9; x++){
                this.board[x][y] = new Number(board[x][y], x, y);
                if (board[x][y] > 0){
                    this.board[x][y].isFixed = true;
                } else {
                    this.board[x][y].isFixed = false;
                    this.numbersToVisit.add(this.board[x][y]);
                }
            }
        }
    }

    public int[][] solve(){

        this.backtrackSolve();

        int[][] solution = new int[9][9];

        for(int y = 0; y < 9; y++){
            for(int x = 0; x < 9; x++){
                solution[x][y] = this.board[x][y].number;
            }
        }

        return solution;
    }

    private void backtrackSolve(){
        Number visiting = null;
        boolean hasToBT = false;
        boolean isValid = true;

        while (this.numbersToVisit.size() > 0){
            visiting = this.numbersToVisit.poll();
            do {
                visiting.number += 1;
                isValid = visiting.number <= 9 && this.isValidAddition(visiting.x, visiting.y);
            } while (!isValid && visiting.number <= 9);

            // Backtrack case
            if (visiting.number > 9){
                visiting.number = 0;
                this.numbersToVisit.addFirst(visiting);
                visiting = this.visitedNumbers.poll();
                if (visiting == null) throw new RuntimeException("This Sudoku has no solution!");
                this.numbersToVisit.addFirst(visiting);
            } else {
                this.visitedNumbers.addFirst(visiting);
            }
        }
    }

    private boolean isValidAddition(int x, int y){
        this.squareX = x / 3;
        this.squareY = y / 3;

        int squareCeros = 0;
        int verticalCeros = 0;
        int horizontalCeros = 0;

        this.squareNumbers.clear();
        this.verticalNumbers.clear();
        this.horizontalNumbers.clear();

        for (int ys = this.squareY * 3; ys < this.squareY * 3 + 3; ys++){
            for (int xs = this.squareX * 3; xs < this.squareX * 3 + 3; xs++){
                if (this.board[xs][ys].number == 0){
                    squareCeros++;
                }
                else {
                    this.squareNumbers.add(this.board[xs][ys].number);
                }
            }
        }

        for (int vertical = 0; vertical < 9; vertical++){
            if (this.board[x][vertical].number == 0){
                verticalCeros++;
            }
            else {
                this.verticalNumbers.add(this.board[x][vertical].number);
            }
        }

        for (int horizontal = 0; horizontal < 9; horizontal++){
            if (this.board[horizontal][y].number == 0){
                horizontalCeros++;
            }
            else {
                this.horizontalNumbers.add(this.board[horizontal][y].number);
            }
        }

        return (this.squareNumbers.size() + squareCeros) == 9
                && (this.verticalNumbers.size() + verticalCeros) == 9
                && (this.horizontalNumbers.size() + horizontalCeros) == 9;
    }

    public String getPrintableSolution(){
        StringBuilder sb = new StringBuilder();

        for(int y = 0; y < 9; y++){
            if (y % 3 == 0)
                sb.append("+---------+---------+---------+\n");
            for(int x = 0; x < 9; x++){
                if (x % 3 != 0)
                    sb.append(' ');
                else
                    sb.append("| ");
                sb.append(this.board[x][y].number);
                if (x == 8)
                    sb.append(" |");
                else
                    sb.append(' ');
            }
            sb.append('\n');
            if (y == 8)
                sb.append("+---------+---------+---------+\n");
        }

        return sb.toString();
    }

    private class Number {
        private int number;
        private int x;
        private int y;
        private boolean isFixed;

        public Number(){
            this.number = 0;
            this.x = -1;
            this.y = -1;
            this.isFixed = false;
        }

        public Number(int number, int x, int y, boolean isFixed){
            this.number = number;
            this.x = x;
            this.y = y;
            this.isFixed = isFixed;
        }

        public Number(int number, int x, int y){
            this.number = number;
            this.x = x;
            this.y = y;
        }
    }
}
