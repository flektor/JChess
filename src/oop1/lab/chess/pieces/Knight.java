package oop1.lab.chess.pieces;

import java.util.ArrayList;

public class Knight implements SyncPieces {

    public Knight(int i, int color) {
        position = i;
        this.color = color;
        kind = "Knight";
        unicode = "\u2658";
    }

    public String getKind() {
        return kind;
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
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (Math.abs(x) + Math.abs(y) == 3) {
                    if (i / 8 + x < 8 && i % 8 - y >= 0) {
                        list.add(i + x * 8 - y);
                    }
                    if (i / 8 - x >= 0 && i % 8 + y < 8) {
                        list.add(i - x * 8 + y);
                    }
                    if (i / 8 + x < 8 && i % 8 + y < 8) {
                        list.add(i + x * 8 + y);
                    }
                    if (i / 8 - x >= 0 && i % 8 - y >= 0) {
                        list.add(i - x * 8 - y);
                    }
                    list.add(i);
                }
            }
        }
        for (int a = 0; a < pieces.size(); a++) {
            for (int x = 0; x < list.size(); x++) {
                if (list.get(x) == pieces.get(a).getPosition() && list.get(x) != i) {
                    if (pieces.get(a).getTeam() == color) {
                        list.remove(x);
                    } 
                }
            }
        }
        return list;
    }
    private int position, color;
    private String kind, unicode;
    private ArrayList<SyncPieces> pieces;

    @Override
    public int getTeam() {
        return color;
    }


}
