package sudokuSolver;

import java.time.Duration;
import java.util.Scanner;

public class Tester {

    public static void main(String[] args){
        try {
            System.out.println("Welcome to Sudoku Solver, input your Sudoku(numbers sepparated by a space and places with no numbers have 0s, input has to be each row continuously):");
            String input = new Scanner(System.in).nextLine();

            int[][] parsedInput = parseInput(input);

            Solver mySolver = new Solver(parsedInput);

            long start = System.nanoTime();

            mySolver.solve();

            long end = System.nanoTime();

            Duration duration = Duration.ofNanos(end - start);

            System.out.println("The solution is(took " + duration.toMillis() + " millis):");
            System.out.println(mySolver.getPrintableSolution());
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    public static int[][] parseInput(String input){
        String[] numbersInText = input.split(" ");
        if (numbersInText.length != 81) throw new RuntimeException("Wrong Sudoku input!");
        int[][] res = new int[9][9];

        int index = 0;
        int num;
        for (int y = 0; y < 9; y++){
            for (int x = 0; x < 9; x++){
                num = Integer.parseInt(numbersInText[index++]);
                if (num > 9 || num < 0) throw new RuntimeException("Wrong Sudoku input!");
                res[x][y] = num;
            }
        }

        return res;
    }
}
