package Xsi0;

public class Main {
    public static void main(String args[]){
        Game game=new Game(new Player("Adi"));
        Game game1=new Game(new Player("Adi"),new Player("Stef"));
//        game.playVsComputer();
        game1.play();
    }
}
