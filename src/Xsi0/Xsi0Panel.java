package Xsi0;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;

public class Xsi0Panel extends JPanel {
    private GameBoard gameBoard;
    private Graphics2D graphics;

    public Xsi0Panel(GameBoard gameBoard){
        this.gameBoard=gameBoard;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        graphics = (Graphics2D) g;

        drawBoard(graphics);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard.getGameBoard()[i][j] == 1) {
                    drawX(i, j, graphics);
                }
                if (gameBoard.getGameBoard()[i][j] == 2) {
                    draw0(i, j, graphics);
                }
            }
        }
    }

    public void redraw() {
        this.paintComponent(graphics);
    }

    private void drawBoard(Graphics2D g){
        int width=this.getWidth();
        int height=this.getHeight();
        g.setStroke(new BasicStroke(5));
        g.drawLine(width-6*width/10,height-height/5,width-6*width/10,height/5);
        g.drawLine(width-4*width/10,height-height/5,width-4*width/10,height/5);

        g.drawLine(width/5,4*height/10,width-width/5,4*height/10);
        g.drawLine(width/5,height-4*height/10,width-width/5,height-4*height/10);
    }

    private void drawX(int row,int column,Graphics2D g){
        int startX=(int)(0.2*(column+1)*getWidth())+10;
        int startY=(int)(0.2*(row+1)*getHeight())+10;
        int endX=(int)(startX+0.2*getWidth())-20;
        int endY=(int)(startY+0.2*getHeight())-20;
        g.setColor(new Color(0,0,255));
        g.drawLine(startX,startY,endX,endY);
        g.drawLine(startX,endY,endX,startY);
    }

    private void draw0(int row, int column, Graphics2D g){
        int startX=(int)(0.2*(column+1)*getWidth())+10;
        int startY=(int)(0.2*(row+1)*getHeight())+10;
        g.setColor(new Color(255,0,0));
        g.drawOval(startX,startY,(int) (0.2 * getWidth()-20), (int) (0.2 * getHeight()-20));
    }
}
