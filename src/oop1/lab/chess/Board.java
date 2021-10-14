package oop1.lab.chess;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import oop1.lab.chess.pieces.SyncPieces;
 
public class Board extends JPanel implements ActionListener {

    public Board() {
        setLayout(new GridLayout(8, 8, 1, 1));
        for (int i = 0; i < 8 * 8; i++) {
            add(new JButton());
            ((JButton) getComponent(i)).addActionListener(this);
            ((JButton) getComponent(i)).setEnabled(false);
        }
        newGame();
    }

    private void newGame() {
        game = new Game();
        clickCount = 0;
        turn = WHITE;
        for (int x = 0; x < 8 * 8; x++) {
            setImage(x, NORMAL);
            for (SyncPieces piece : game.getPieces()) {
                if (piece.getPosition() == x && piece.getTeam() == turn && piece.getPossibleMoves(x).size() != 1) {
                    ((JButton) getComponent(x)).setEnabled(true);
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        getComponent(i * 8 + j).setBackground(Color.white);
                    } else {
                        getComponent(i * 8 + j).setBackground(Color.black);
                    }
                } else if (j % 2 != 0) {
                    getComponent(i * 8 + j).setBackground(Color.white);
                } else {
                    getComponent(i * 8 + j).setBackground(Color.black);
                }
            }
        }
    }

    public void activateCells(ArrayList<Integer> cells, int flag) {
        ArrayList<Integer> targets = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        Color light, dark;
        if (flag == GREEN) {
            light = new Color(144, 238, 144);
            dark = new Color(00, 66, 00);
        } else {
            light = new Color(204, 0, 0);
            dark = new Color(153, 0, 0);
        }
        for (int i = 0; i < game.getPieces().size(); i++) {
            for (int x = 0; x < cells.size(); x++) {
                if (cells.get(x) == game.getPiece(i).getPosition()) {
                    if (game.getPiece(i).getTeam() == turn && flag == GREEN ) {
                        targets.add(cells.get(x));
                        cells.remove(x);
                    }
                }
            }
        }
        for (int x = 0; x < cells.size(); x++) {
            if(cells.get(x) == tempx)
               System.out.println(tempx);
            ((JButton) getComponent(cells.get(x))).setEnabled(true);
            ((JButton) getComponent(cells.get(x))).removeAll();
            setImage(cells.get(x), flag);
            if (cells.get(x) / 8 % 2 == 0) {
                if (cells.get(x) % 8 % 2 == 0) {
                    getComponent(cells.get(x)).setBackground(light);
                } else {
                    getComponent(cells.get(x)).setBackground(dark);
                }
            } else if (cells.get(x) % 8 % 2 != 0) {
                getComponent(cells.get(x)).setBackground(light);
            } else {
                getComponent(cells.get(x)).setBackground(dark);
            }
        }
        if (flag == GREEN) {
            cells = targets;
            activateCells(cells, RED);
        }
    }

    public void deactivateCells() {;
        ((JButton) getComponent(tempx)).removeAll();
        for (int x = 0; x < 8 * 8; x++) {
            ((JButton) getComponent(x)).setEnabled(false);
            for (int i = 0; i < game.getPieces().size(); i++) {

                if (game.getPiece(i).getPosition() == x) {
                    ((JButton) getComponent(x)).removeAll();

                    if (game.getPiece(i).getTeam() == turn && game.getPiece(i).getPossibleMoves(x).size() != 1) {
                        ((JButton) getComponent(x)).setEnabled(true);
                    }
                    setImage(x, NORMAL);
                }
            }
        }
        for (int x = 0; x < 8 * 8; x++) {
            if (x / 8 % 2 == 0) {
                if (x % 8 % 2 == 0) {
                    getComponent(x).setBackground(Color.white);
                } else {
                    getComponent(x).setBackground(Color.black);
                }
            } else if (x % 8 % 2 != 0) {
                getComponent(x).setBackground(Color.white);
            } else {
                getComponent(x).setBackground(Color.black);
            }
        }
    }

    private void setImage(int x, int flag) {
        for (int a = 0; a < game.getPieces().size(); a++) {
            if (game.getPiece(a).getPosition() == x) {
                String piece = game.getPiece(a).getImageUnicode();
                int i = a;
                Container button = (Container) getComponent(x);
                Boolean blackSquare;
                Color color;
                if (x / 8 % 2 == 0) {
                    if (x % 8 % 2 == 0) {
                        blackSquare = false;
                    } else {
                        blackSquare = true;
                    }
                } else {
                    if (x % 8 % 2 == 0) {
                        blackSquare = true;
                    } else {
                        blackSquare = false;
                    }
                }
                if (game.getPiece(i).getTeam() == 0) {
                    color = new Color(203, 203, 197);
                } else {
                    color = new Color(192, 142, 60);
                }
                graphics.addColoredUnicodeCharToContainer(piece, button, color, Color.DARK_GRAY, blackSquare, flag);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int x = 0; x < 8 * 8; x++) {
            if (getComponent(x) == e.getSource()) {
                if (clickCount == 0) {
                    tempx = x;
                }
                if (clickCount % 2 == 0) {
                    currentx = x;
                    if (clickCount == 0) {
                        turn = BLACK;
                    }
                    for (int i = 0; i < game.getPieces().size(); i++) {
                        if (game.getPiece(i).getPosition() == x) {
                            activateCells(game.getPossibleMoves(x), GREEN);
                            tempi = i;
                        }
                    }
                } else {
                    if(tempx != x)
                    for (int i = 0; i < game.getPieces().size(); i++) {
                        if (game.getPiece(i).getPosition() == x) {
                            game.removePiece(i);
                        }
                    }
                    for (int i = 0; i < game.getPieces().size(); i++) {
                        if (game.getPiece(i).getPosition() == tempx) {
                            game.getPiece(i).setPosition(x);
                        }
                    }
                    deactivateCells();
                    game.updatePieces();
                    if (turn == WHITE) {
                        turn = BLACK;
                    } else {
                        turn = WHITE;
                    }
                }
                tempx = x;
            }
            repaint();
            revalidate();
        }
        clickCount++;
    }
    private Game game;
    private int tempx, tempi, currentx, clickCount, turn;
    private ChessGraphics graphics;
    private final static int NORMAL = 0, GREEN = 1, RED = 2, WHITE = 0, BLACK = 1;
}
