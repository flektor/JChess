
package oop1.lab.chess;

import javax.swing.JFrame;
 
public class Frame extends JFrame {
    private Board board;
    public Frame(){
        board = new Board();
        add(board);
        setTitle("Chess");
        setSize(800,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public Board getBoard(){
        return board;
    }
}
