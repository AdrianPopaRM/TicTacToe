package Xsi0;

public class Main {
    public static void main(String args[]){
        int[][] map=new int[3][3];
        map[0][0]=2;    map[0][1]=0;    map[0][2]=0;
        map[1][0]=2;    map[1][1]=2;    map[1][2]=0;
        map[2][0]=1;    map[2][1]=0;    map[2][2]=0;
        int i=0;

        Game game=new Game(new Player("Adi"),new Player("Stef"));
//        System.out.println(Arrays.toString(Game.gameOver(map)));
//        UserInput s=new UserInput();
//        s.getNextPosition(new Player("Adi"));
        game.play();
    }
}
