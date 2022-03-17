package Xsi0;

public class Game {
    private GameStatus gameStatus=new GameStatus();
    private Player firstPlayer;
    private Player secondPlayer;
    public UserInput userInput = new UserInput();
    private GameBoard gameBoard=new GameBoard();
    private Graphics graphics=new Graphics();

    public Game(Player player1, Player player2) {
        randomFirstPlayer(player1, player2);
        System.out.println("First player randomly assigned is " + getFirstPlayer().getName() + ". I wish you both good luck.");
    }

    public void play() {
        while (gameStatus.areThereMoreMovesPossible(gameBoard)&&!gameStatus.gameOver(this.gameBoard)){
            graphics.displayTheBoard(gameBoard);
            gameStep(firstPlayer);
            if(!gameStatus.gameOver(this.gameBoard)){
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

    private int getNextValidPosition(Player player) {
        int currentPlayerInput = userInput.getNextPosition(player);
        while (!gameBoard.checkIfPositionAvailable(currentPlayerInput)) {
            System.out.println("The move you tried to make was already made, try another one");
            currentPlayerInput = userInput.getNextPosition(player);
        }
        return currentPlayerInput;
    }
    private void gameFinale(){
        if(gameStatus.gameConclusions(gameBoard)==1){
            System.out.println("Player "+firstPlayer.getName()+" won! Congratulations");
        }
        if(gameStatus.gameConclusions(gameBoard)==2){
            System.out.println("Player "+secondPlayer.getName()+" won! Congratulations");
        }
    }
    private void gameStep(Player player) {
        if(gameStatus.areThereMoreMovesPossible(this.gameBoard)) {
            gameBoard.insertInChosenPosition(getNextValidPosition(player), player);
        }
    }
}
