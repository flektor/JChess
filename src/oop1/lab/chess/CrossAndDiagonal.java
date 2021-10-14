package oop1.lab.chess;

import java.util.ArrayList;
import oop1.lab.chess.pieces.SyncPieces;
 
public class CrossAndDiagonal {

    public CrossAndDiagonal(ArrayList<SyncPieces> pieces) {
        this.pieces = pieces;
        cells = new ArrayList<>();
        for (SyncPieces piece : pieces) {
            cells.add(piece.getPosition());
        }

//        for (SyncPieces piece : pieces) {
//            if (piece.getImageUnicode().equals("\u2654")) {
//                if (piece.getTeam() == 0) {
//                    whiteKingPosition = piece.getPosition();
//                } else {
//                    blackKingPosition = piece.getPosition();
//                }
//            }
//        }
    }

    public ArrayList<Integer> getCross(int i, int range) {
        for (SyncPieces piece : pieces) {
            if (piece.getPosition() == i) {
                team = piece.getTeam();
            }
        }
        Boolean c1, c2, c3, c4;
        c1 = c2 = c3 = c4 = true;
        ArrayList<Integer> list = new ArrayList<>();
        for (int rng = 0; rng < range; rng++) {

            if (i / 8 - rng >= 0 && !list.contains(i - rng * 8) && c1) {
                list.add(i - rng * 8);
                if (cells.contains(i - rng * 8) && rng != 0) {
                    c1 = false;
                }
            }
            if (i / 8 + rng < 8 && !list.contains(i + rng * 8) && c2) {
                list.add(i + rng * 8);
                if (cells.contains(i + rng * 8) && rng != 0) {
                    c2 = false;
                }
            }
            if (i % 8 - rng >= 0 && !list.contains(i - rng) && c3) {
                list.add(i - rng);
                if (cells.contains(i - rng) && rng != 0) {
                    c3 = false;
                }
            }
            if (i % 8 + rng < 8 && !list.contains(i + rng) && c4) {
                list.add(i + rng);
                if (cells.contains(i + rng) && rng != 0) {
                    c4 = false;
                }
            }
        }
        for (int a = 0; a < pieces.size(); a++) {
            for (int x = 0; x < list.size(); x++) {
                if (list.get(x) == pieces.get(a).getPosition() && list.get(x) != i) {
                    if (pieces.get(a).getTeam() == team) {
                        list.remove(x);
                    }
                }
            }
        }

//        list = kingPermission(list, i);
        return list;
    }

    public ArrayList<Integer> getDiagonal(int i, int range) {

        for (SyncPieces piece : pieces) {
            if (piece.getPosition() == i) {
                team = piece.getTeam();
            }
        }
        Boolean d1, d2, d3, d4;
        d1 = d2 = d3 = d4 = true;
        ArrayList<Integer> list = new ArrayList<>();
        for (int rng = 0; rng < range; rng++) {
            if (i / 8 + rng < 8 && i % 8 - rng >= 0 && !list.contains(i + rng * 7) && d1) {
                list.add(i + rng * 7);
                if (cells.contains(i + rng * 7) && rng != 0) {
                    d1 = false;
                }
            }
            if (i / 8 - rng >= 0 && i % 8 + rng < 8 && !list.contains(i - rng * 7) && d2) {
                list.add(i - rng * 7);
                if (cells.contains(i - rng * 7) && rng != 0) {
                    d2 = false;
                }
            }
            if (i / 8 + rng < 8 && i % 8 + rng < 8 && !list.contains(i + rng * 9) && d3) {
                list.add(i + rng * 9);
                if (cells.contains(i + rng * 9) && rng != 0) {
                    d3 = false;
                }
            }
            if (i / 8 - rng >= 0 && i % 8 - rng >= 0 && !list.contains(i - rng * 9) && d4) {
                list.add(i - rng * 9);
                if (cells.contains(i - rng * 9) && rng != 0) {
                    d4 = false;
                }
            }
        }
        for (int a = 0; a < pieces.size(); a++) {
            for (int x = 0; x < list.size(); x++) {
                if (list.get(x) == pieces.get(a).getPosition() && list.get(x) != i) {
                    if (pieces.get(a).getTeam() == team) {
                        list.remove(x);
                    }
                }
            }
        }
//        list = kingPermission(list, i);
        return list;
    }

    public ArrayList<Integer> getCrossAndDiagonal(int i, int range) {
        ArrayList<Integer> list = null;
        if (getCross(i, range) != null) {
            list = getCross(i, range);
        }
        if (list != null) {
            list.addAll(getDiagonal(i, range));
        } else {
            list = getDiagonal(i, range);
        }

        // diagrafei th thesh i pou tha uparxei 2 fores
        Boolean isTrue = true;
        int x = 0;
        while (isTrue) {
            if (list.get(x) == i) {
                list.remove(x);
                isTrue = false;
            }
            if (x < list.size()) {
                x++;
            } else {
                isTrue = false;
            }
        }
        return list;
    }
//    public ArrayList<Integer> kingPermission(ArrayList<Integer> list,int i){
//        for (SyncPieces piece : pieces) {
//            if (piece.getTeam() == WHITE) {
//                if (piece.getPossibleMoves(i).contains(blackKingPosition)) {
//                    for (int l : list) {
//                        if (l == piece.getPosition()) {
//                            list.remove(l);
//                        }
//                    }
//                }
//            }else {
//                if (piece.getPossibleMoves(i).contains(whiteKingPosition)) {
//                    for (int l : list) {
//                        if (l == piece.getPosition()) {
//                            list.remove(l);
//                        }
//                    }
//                }
//            }
//        }
//        return list;
//    }
    private ArrayList<Integer> cells;
    private ArrayList<SyncPieces> pieces;
    private final static int WHITE = 0, GREEN = 1;
    private int team = 0, whiteKingPosition = 0, blackKingPosition = 0;
}
