package oop1.lab.chess.pieces;

import java.util.ArrayList;

public interface SyncPieces {
    public void setPosition(int i);
    public int getPosition();
    public ArrayList<Integer> getPossibleMoves(int i);
    
    public String getImageUnicode();
    public int getTeam();
    public void update(ArrayList<SyncPieces> cells);
}
