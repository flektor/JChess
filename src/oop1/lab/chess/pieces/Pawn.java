package oop1.lab.chess.pieces;

import java.util.ArrayList;

public class Pawn implements SyncPieces {

    public Pawn(int i, int color) {
        position = i;
        this.color = color;
        kind = "Pawn";
        unicode = "\u2659";
        pieces = new ArrayList<>();
    }

    public String getKind() {
        return kind;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int c) {
        color = c;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public void setPosition(int i) {
        this.position = i;
    }

    @Override
    public String getImageUnicode() {
        return unicode;
    }
    @Override
    public void update(ArrayList<SyncPieces> pieces) {
        this.pieces = pieces;
    }
    @Override
    public ArrayList<Integer> getPossibleMoves(int i) {
            ArrayList<Integer> cells = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>();
            for (SyncPieces piece : pieces) {
                 list.add( piece.getPosition() ); 
            }
        if (color == WHITE) {
            if (i/8 == 1) {
                cells.add(i + 16);
            }
            if(i + 8 < 64 && !list.contains(i + 8) ){
                cells.add(i + 8);
            }
            if (i + 7 < 64 && list.contains(i + 7) ) {
                cells.add(i + 7);
            }
            if (i + 9 < 64 && list.contains(i + 9)) {
                cells.add(i + 9);
            }

        } else if(color == BLACK){
            if (i/8 == 6) {
                cells.add(i - 16);
            }
            if( i - 8 >= 0 && !list.contains(i - 8) ){
                cells.add(i - 8);
            }
            if (i - 7 >= 0 && list.contains(i - 7)) {
                cells.add(i - 7);
            }
            if (i - 9 >= 0 && list.contains(i - 9)) {
                cells.add(i - 9);
            }
       
        }
        cells.add(i);
        return cells;
    }
    @Override
    public int getTeam() {
        return color;
    }

    private int position, color;
    private String kind, unicode;
    private static final int WHITE = 0, BLACK = 1;
    private ArrayList<SyncPieces> pieces;
    

}
