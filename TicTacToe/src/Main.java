import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Tic-Tac-Toe Game!");
        Board board = new Board();
        int userInput;
        while (true) {
            board.menu();
            board.println("----------------------------");
            userInput = board.getInput();
            if(userInput != 1 && userInput != 2) {
                board.println("Invalid Input!");
            }
            else {
                if(userInput == 1) {
                    board.reseBoard();
                    board.playGame();
                }
                else {
                    break;
                }
            }
        }
    }
}