package oop1.lab.chess;

import java.util.ArrayList;
import oop1.lab.chess.pieces.Bishop;
import oop1.lab.chess.pieces.King;
import oop1.lab.chess.pieces.Knight;
import oop1.lab.chess.pieces.Rook;
import oop1.lab.chess.pieces.Pawn;
import oop1.lab.chess.pieces.SyncPieces;
import oop1.lab.chess.pieces.Queen;
 
public class Game {

    public Game() {
        setPieces();
        updatePieces();
    }

    public ArrayList<Integer> getPossibleMoves(int i) {
        for (int x = 0; x < pieces.size(); x++) {
            if (getPiece(x).getPosition() == i) {
                return pieces.get(x).getPossibleMoves(i);
            }
        }
        return null;
    }

    private void setPieces() {
        pieces = new ArrayList<>();
        deadPieces = new ArrayList<>();

        pieces.add(new Rook(0, WHITE));
        pieces.add(new Rook(7, WHITE));
        pieces.add(new Knight(1, WHITE));
        pieces.add(new Knight(6, WHITE));
        pieces.add(new Bishop(2, WHITE));
        pieces.add(new Bishop(5, WHITE));
        pieces.add(new Queen(3, WHITE));
        pieces.add(new King(4, WHITE));
        pieces.add(new Pawn(8, WHITE));
        pieces.add(new Pawn(9, WHITE));
        pieces.add(new Pawn(10, WHITE));
        pieces.add(new Pawn(11, WHITE));
        pieces.add(new Pawn(12, WHITE));
        pieces.add(new Pawn(13, WHITE));
        pieces.add(new Pawn(14, WHITE));
        pieces.add(new Pawn(15, WHITE));

        pieces.add(new Rook(63, BLACK));
        pieces.add(new Rook(56, BLACK));
        pieces.add(new Knight(62, BLACK));
        pieces.add(new Knight(57, BLACK));
        pieces.add(new Bishop(61, BLACK));
        pieces.add(new Bishop(58, BLACK));
        pieces.add(new Queen(60, BLACK));
        pieces.add(new King(59, BLACK));
        pieces.add(new Pawn(48, BLACK));
        pieces.add(new Pawn(49, BLACK));
        pieces.add(new Pawn(50, BLACK));
        pieces.add(new Pawn(51, BLACK));
        pieces.add(new Pawn(52, BLACK));
        pieces.add(new Pawn(53, BLACK));
        pieces.add(new Pawn(54, BLACK));
        pieces.add(new Pawn(55, BLACK));

    }

    public void updatePieces() {
        for (SyncPieces piece : pieces) {
            piece.update(pieces);
        }
    }

    public SyncPieces getPiece(int i) {
        return pieces.get(i);
    }

    public void removePiece(int i) {
        deadPieces.add(pieces.get(i));
        pieces.remove(i);
    }

    public ArrayList<SyncPieces> getPieces() {
        return pieces;
    }
    private static final int WHITE = 0, BLACK = 1;
    public ArrayList<SyncPieces> pieces, deadPieces;

}
