package Xsi0;

public class Player {
    private String name;
    private int quePosition;

    public Player(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public int getQuePosition() {
        return quePosition;
    }

    public void setQuePosition(int quePosition) {
        this.quePosition = quePosition;
    }

    @Override
    public String toString() {
        return "Player " +
                "name is " + name;
    }
}
