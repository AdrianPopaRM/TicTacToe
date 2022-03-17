package Xsi0;

import java.util.Scanner;

public class UserInput {

    public int getNextPosition(Player player) {
        System.out.println("Please enter your next move " + player.getName() + ", in this format RowCollum: ");
        Scanner keyboard = new Scanner(System.in);
        int playerChosenPosition = keyboard.nextInt();

        while ((playerChosenPosition % 10 > 2) || (playerChosenPosition / 10 > 2)) {
            System.out.println("The move your tried to make is not possible, chose another position");
            playerChosenPosition = keyboard.nextInt();
        }
        return playerChosenPosition;
    }
}
