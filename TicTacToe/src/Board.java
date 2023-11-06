import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class Board {
    final int size = 3;
    String[][] data = {{" "," "," "},{" "," "," "},{" "," "," "}};

    public void println(String s) {
        System.out.println(s);
    }

    public void print(String s) {
        System.out.print(s);
    }


    public void menu() {
        println("----------------------------");
        println("1 - Start Game");
        println("2 - Exit");
    }

        public void printBoard() {
            for (int i = 0; i < size; i++) {
                System.out.print(i);
                for (int j = 0; j < size; j++) {
                    System.out.print("|" + data[i][j]);
                }
                System.out.println("|");
            }
            System.out.println("========");
            System.out.println("  0 1 2");
        }


        public int getInput() {
            Scanner kb = new Scanner(System.in);
            String input =  kb.nextLine();
            try {
                int i = Integer.parseInt(input);
                return i;
            }
            catch (NumberFormatException ex) {
                println("Enter a Number!");
                return 1000;
            }
        }

        public boolean allowMove(int row, int col) {
            if(data[row][col] == " ") {
                return true;
            }
            else {
                return false;
            }
        }

    public ArrayList<int []> getAvailablePositions() {
        ArrayList <int []> emptyList = new ArrayList<int []>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(" ".contains(data[i][j]))
                {
                    emptyList.add(new int[]{i, j});
                }
            }

        }
        return emptyList;
    }

    public int [] getEmptyPosition(ArrayList<int[]> emptyList) {
        Random rand = new Random();
        return emptyList.get(rand.nextInt(emptyList.size()));
    }

    public boolean checkWin(){
        boolean win = false;
        for (int i = 0; i < size; i++) {
            if(data[i][0] != " " && data[i][0] == data[i][1] && data[i][1] == data[i][2]){
                win = true;
                println(data[i][0] + " wins, game over.");
                break;
            }

        }
        for (int j = 0; j < size; j++) {
            if(data[0][j] != " " && data[0][j] == data[1][j] && data[1][j] == data[2][j]){
                win = true;
                println(data[0][j] + " wins, game over.");
                break;
            }

        }
        if(data[0][0] != " " && data[0][0] == data[1][1] && data[1][1] == data[2][2]){
            win = true;
            println(data[0][0] + " wins, game over.");
        }
        if(data[0][2]  != " " && data[0][2] == data[1][1] && data[1][1] == data[2][0]){
            win = true;
            println(data[0][2] + " wins, game over.");
        }

        return win;
    }

    public void playGame () {
        while (true) {
            printBoard();
            println("Enter row number:");
            int row = getInput();
            if (row < 0 || row > 2) {
                println("Invalid Input!");
                continue;
            }

            println("Enter col number:");
            int col = getInput();
            if (col < 0 || col > 2) {
                println("Invalid Input!");
                continue;
            }

            if(allowMove(row, col)) {
                data[row][col] = "X";
                if(checkWin()) {
                    printBoard();
                    break;
                }
                ArrayList<int[]> emptyList = getAvailablePositions();
                if(emptyList.size() > 0) {
                    int[] machineMovePosition = getEmptyPosition(emptyList);
                    if (machineMovePosition.length == 2) {
                        data[machineMovePosition[0]][machineMovePosition[1]] = "Y";
                        if (checkWin()) {
                            printBoard();
                            break;
                        }
                    }
                }
                else {
                    println("Cat's Game!");
                    printBoard();
                    break;
                }
            }
            else {
                println("Illegal Move!");
            }
        }//while
    }

    public void reseBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                data[i][j] = " ";
            }
        }
    }

}
