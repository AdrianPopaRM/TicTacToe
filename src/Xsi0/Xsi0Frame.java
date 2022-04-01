package Xsi0;

import javax.swing.*;

public class Xsi0Frame extends JFrame {

    private Xsi0Panel panel;

    public Xsi0Frame(GameBoard gameboard) {
        setTitle("Joc nou de X si 0");
        setSize(1000,1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new Xsi0Panel(gameboard);
        add(panel);
    }

    public void redraw() {
//        panel.removeAll();
//        panel.setVisible(false);
        this.dispose();
        this.setVisible(true);
        panel.repaint();
    }
}
