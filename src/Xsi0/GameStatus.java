package Xsi0;

public class GameStatus {
    private int winnerIndex;

    public boolean gameOver(GameBoard gameBoardEntity) {
        for (int i = 0; i < 3; i++) {
            int j = 0;
            if ((gameBoardEntity.getGameBoard()[i][j] == gameBoardEntity.getGameBoard()[i][j + 1]) && gameBoardEntity.getGameBoard()[i][j + 1] == gameBoardEntity.getGameBoard()[i][j + 2] && gameBoardEntity.getGameBoard()[i][j] != 0) {

                winnerIndex = gameBoardEntity.getGameBoard()[i][j];
                return true;
            }
            if ((gameBoardEntity.getGameBoard()[j][i] == gameBoardEntity.getGameBoard()[j + 1][i]) && gameBoardEntity.getGameBoard()[j + 1][i] == gameBoardEntity.getGameBoard()[j + 2][i] && gameBoardEntity.getGameBoard()[j][i] != 0) {
                winnerIndex = gameBoardEntity.getGameBoard()[i][j];
                return true;
            }

        }
        if (
                ((gameBoardEntity.getGameBoard()[0][0] == gameBoardEntity.getGameBoard()[1][1]) && gameBoardEntity.getGameBoard()[2][2] == gameBoardEntity.getGameBoard()[1][1] && gameBoardEntity.getGameBoard()[1][1] != 0) ||
                        ((gameBoardEntity.getGameBoard()[2][0] == gameBoardEntity.getGameBoard()[1][1]) && gameBoardEntity.getGameBoard()[0][2] == gameBoardEntity.getGameBoard()[1][1] && gameBoardEntity.getGameBoard()[1][1] != 0)
        ) {
            winnerIndex = gameBoardEntity.getGameBoard()[1][1];
            return true;
        }
        return false;
    }

    //    public boolean gameOver(GameBoard gameBoardEntity) {
//        for (int i = 0; i < 3; i++) {
//            int j = 0;
//            if ((gameBoardEntity.getGameBoard()[i][j] == gameBoardEntity.getGameBoard()[i][j + 1]) && gameBoardEntity.getGameBoard()[i][j + 1] == gameBoardEntity.getGameBoard()[i][j + 2] && gameBoardEntity.getGameBoard()[i][j] != 0) {
//
//                winnerPosition = gameBoardEntity.getGameBoard()[i][j];
//                return true;
//            }
//            if ((gameBoardEntity.getGameBoard()[j][i] == gameBoardEntity.getGameBoard()[j + 1][i]) && gameBoardEntity.getGameBoard()[j + 1][i] == gameBoardEntity.getGameBoard()[j + 2][i] && gameBoardEntity.getGameBoard()[j][i] != 0) {
//                winnerPosition = gameBoardEntity.getGameBoard()[i][j];
//                return true;
//            }
//            if (
//                    ((gameBoardEntity.getGameBoard()[0][0] == gameBoardEntity.getGameBoard()[1][1]) && gameBoardEntity.getGameBoard()[2][2] == gameBoardEntity.getGameBoard()[1][1] && gameBoardEntity.getGameBoard()[1][1] != 0) ||
//                            ((gameBoardEntity.getGameBoard()[2][0] == gameBoardEntity.getGameBoard()[1][1]) && gameBoardEntity.getGameBoard()[0][2] == gameBoardEntity.getGameBoard()[1][1] && gameBoardEntity.getGameBoard()[1][1] != 0)
//            ) {
//                winnerPosition = gameBoardEntity.getGameBoard()[1][1];
//                return true;
//            }
//        }
//        return false;
//    }
    public int gameConclusions(GameBoard gameBoardEntity) {
        if (!gameOver(gameBoardEntity) && !areThereMoreMovesPossible(gameBoardEntity)) {
            System.out.println("Not all games end in victory, thus draw it is.");
            return 0;
        }
        return winnerIndex;
    }

    public boolean areThereMoreMovesPossible(GameBoard gameBoard) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard.getGameBoard()[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
