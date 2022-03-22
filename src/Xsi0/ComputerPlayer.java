package Xsi0;

public class ComputerPlayer {
    private GameStatus gameStatus;
    private GameBoard gameBoard;
    private int moveThatCouldEndTheGame;

    //    private int adversaryIndex;
    public ComputerPlayer(GameStatus gameStatus, GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        this.gameStatus = gameStatus;
    }

    public int getNextMove() {
        if (isGameCloseToFinish()) {
            return moveThatCouldEndTheGame;
        }
        return getNextRandomMove();
    }

    private int getNextRandomMove() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.gameBoard.getGameBoard()[i][j] == 0) {
                    return i * 10 + j;
                }
            }
        }
        return 0;
    }

    private boolean isGameCloseToFinish() {
        for (int i = 0; i < 3; i++) {
            int j = 0;
            int checkLines = checkLine(i * 10 + j, i * 10 + j + 1, i * 10 + j + 2);
            if (checkLines != 0) {
                this.moveThatCouldEndTheGame = checkLines;
                return true;
            }
            checkLines = checkLine(j * 10 + i, (j + 1) * 10 + i, (j + 2) * 10 + i);
            if (checkLines != 0) {
                this.moveThatCouldEndTheGame = checkLines;
                return true;
            }
            checkLines = checkLine(0, 11, 22);
            if (checkLines != 0) {
                this.moveThatCouldEndTheGame = checkLines;
                return true;
            }
            checkLines = checkLine(20, 2, 11);
            if (checkLines != 0) {
                this.moveThatCouldEndTheGame = checkLines;
                return true;
            }
        }
        return false;
    }

    private int checkLine(int indexA, int indexB, int indexC) {
        int a = this.gameBoard.getGameBoard()[indexA / 10][indexA % 10];
        int b = this.gameBoard.getGameBoard()[indexB / 10][indexB % 10];
        int c = this.gameBoard.getGameBoard()[indexC / 10][indexC % 10];
        if ((a == 0 && b != 0 && c != 0) || (a != 0 && b == 0 && c != 0) || (a != 0 && b != 0 && c == 0)) {
            if ((a + b + c) % 2 == 0) {
                if (a == 0) {
                    return indexA;
                }
                if (b == 0) {
                    return indexB;
                }
                return indexC;
            }
        }
        return 0;
    }
}

