package oop1.lab.chess.pieces;

import oop1.lab.chess.CrossAndDiagonal;
import java.util.ArrayList;

public class Queen implements SyncPieces {

    public Queen(int i, int color) {
        position = i;
        this.color = color;
        kind = "Queen";
        unicode = "\u2655";
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
    public ArrayList<Integer> getPossibleMoves(int i) {
        return cnd.getCrossAndDiagonal(i, 8);
    }

    @Override
    public int getTeam() {
        return color;
    }

    @Override
    public void update(ArrayList<SyncPieces> pieces) {
        this.pieces = pieces;
        cnd = new CrossAndDiagonal(pieces);
    }

    private int position, color;
    private String kind, unicode;
    private CrossAndDiagonal cnd;
    private ArrayList<SyncPieces> pieces;

}
