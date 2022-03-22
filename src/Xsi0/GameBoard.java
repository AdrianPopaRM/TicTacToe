package Xsi0;

public class GameBoard {
    private int[][] gameBoard;

    public GameBoard() {
        gameBoard = initializeGameBoard();
    }

    private int[][] initializeGameBoard() {
        int[][] gameBoard = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                gameBoard[i][j] = 0;
        }
        return gameBoard;
    }
    public int getNextValidPosition(Player player,UserInput userInput) {
        int currentPlayerInput = userInput.getNextPosition(player);
        while (!this.checkIfPositionAvailable(currentPlayerInput)) {
            System.out.println("The move you tried to make was already made, try another one");
            currentPlayerInput = userInput.getNextPosition(player);
        }
        return currentPlayerInput;
    }
    public int[][] getGameBoard() {
        return gameBoard;
    }

    public void insertInChosenPosition(int position, Player player) {
        this.gameBoard[position / 10][position % 10] = player.getQuePosition();
    }
    public void insertInChosenPosition(int position, ComputerPlayer player) {
        this.gameBoard[position / 10][position % 10] = 2;
    }

    public boolean checkIfPositionAvailable(int position) {
        return gameBoard[position / 10][position % 10] == 0;
    }
}
