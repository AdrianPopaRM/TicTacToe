package Xsi0;

public class Game {
    private GameStatus gameStatus = new GameStatus();
    private Player firstPlayer;
    private Player secondPlayer;
    public UserInput userInput = new UserInput();
    private GameBoard gameBoard = new GameBoard();
    private Graphics graphics = new Graphics();
    private ComputerPlayer computerPlayer;

    public Game(Player player1, Player player2) {
        randomFirstPlayer(player1, player2);
        System.out.println("First player randomly assigned is " + getFirstPlayer().getName() + ". I wish you both good luck.");
    }

    public Game(Player player1) {
        this.firstPlayer = player1;
        player1.setQuePosition(1);
        this.computerPlayer = new ComputerPlayer(this.gameStatus, this.gameBoard);
    }

    public void playVsComputer() {
        while (gameStatus.areThereMoreMovesPossible(gameBoard) && !gameStatus.gameOver(gameBoard)) {
            graphics.displayTheBoard(gameBoard);
            gameStep(firstPlayer);
            if (!gameStatus.gameOver(this.gameBoard)) {
                graphics.displayTheBoard(gameBoard);
                if (gameStatus.areThereMoreMovesPossible(this.gameBoard)) {
                    gameBoard.insertInChosenPosition(computerPlayer.getNextMove(), computerPlayer);
                }
            }
        }
        graphics.displayTheBoard(gameBoard);
        if (gameStatus.gameConclusions(gameBoard) == 1) {
            System.out.println("Player " + firstPlayer.getName() + " won! Congratulations");
        }
        if (gameStatus.gameConclusions(gameBoard) == 2) {
            System.out.println("Computer won, better luck next time !");
        }
    }

    public void play() {
        while (gameStatus.areThereMoreMovesPossible(gameBoard) && !gameStatus.gameOver(this.gameBoard)) {
            graphics.displayTheBoard(gameBoard);
            gameStep(firstPlayer);
            if (!gameStatus.gameOver(this.gameBoard)) {
                graphics.displayTheBoard(gameBoard);
                gameStep(secondPlayer);
            }
        }
        graphics.displayTheBoard(gameBoard);
        gameFinale();
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }

    private void randomFirstPlayer(Player player1, Player player2) {
        int random = (int) Math.floor(Math.random() * (2 - 1 + 1) + 1);

        if (random == 1) {
            this.firstPlayer = player1;
            player1.setQuePosition(1);
            this.secondPlayer = player2;
            player2.setQuePosition(2);
            return;
        }
        this.firstPlayer = player2;
        player2.setQuePosition(1);
        this.secondPlayer = player1;
        player1.setQuePosition(2);
    }

    private void gameFinale() {
        if (gameStatus.gameConclusions(gameBoard) == 1) {
            System.out.println("Player " + firstPlayer.getName() + " won! Congratulations");
        }
        if (gameStatus.gameConclusions(gameBoard) == 2) {
            System.out.println("Player " + secondPlayer.getName() + " won! Congratulations");
        }
    }

    private void gameStep(Player player) {
        if (gameStatus.areThereMoreMovesPossible(this.gameBoard)) {
            gameBoard.insertInChosenPosition(gameBoard.getNextValidPosition(player, userInput), player);
        }
    }
}
