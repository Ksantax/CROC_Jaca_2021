package com.croc;

/**
 * Class with entry point
 * @author ChekhovAI
 */
public class Main {
    /**
     * Main function - entry point of program
     * @param args from command line (terminal)
     */
    public static void main(String[] args) {
        // Make a pawn and do legal turn
        Figure pawn = null;
        try {
            pawn = new Pawn('a', (byte)1);
            System.out.println("Pawn set on board to (a, 1)");
            pawn.turn('a', (byte)2);
            System.out.println("Pawn moved (a, 1)->(a, 2)");
        } catch (OutOfBoardException | TakenPositionException | IllegalTurnException e) {
            System.out.println(e.getMessage().strip());
        } finally {
            if(pawn != null) {
                pawn.removeFromBoard();
                System.out.println("Pawn removed");
            }
        }

        // Make a quin and do legal turn
        Figure quin = null;
        try {
            quin = new Quin('d', (byte)0);
            System.out.println("Quin set on board to (d, 0)");
            quin.turn('b', (byte)2);
            System.out.println("Quin moved (d, 0)->(b, 2)");
        } catch (OutOfBoardException | TakenPositionException | IllegalTurnException e) {
            System.out.println(e.getMessage().strip());
        } finally {
            if(quin != null) {
                quin.removeFromBoard();
                System.out.println("Quin removed");
            }
        }
        // Make a rook and do illegal turn
        Figure rook = null;
        try {
            rook = new Rook('d', (byte)0);
            System.out.println("Rook set on board to (d, 0)");
            rook.turn('b', (byte)2);
            System.out.println("Rook moved (d, 0)->(b, 2)");
        } catch (OutOfBoardException | TakenPositionException | IllegalTurnException e) {
            System.out.println(e.getMessage().strip());
        } finally {
            System.out.println("Rook wasn't removed (specialty)");
        }
        // Make a knight with taken position
        Figure knight = null;
        try {
            knight = new Knight('d', (byte)0);
            System.out.println("Knight set on board to (d, 0)");
            knight.turn('c', (byte)2);
            System.out.println("Knight moved (d, 0)->(c, 2)");
        } catch (OutOfBoardException | TakenPositionException | IllegalTurnException e) {
            System.out.println(e.getMessage().strip());
        } finally {
            if(knight != null) {
                knight.removeFromBoard();
                System.out.println("Knight removed");
            }
        }
        // Remove rook
        if(rook != null) {
            rook.removeFromBoard();
            System.out.println("Rook removed");
        }
        // Make a bishop with illegal position
        Figure bishop = null;
        try {
            bishop = new Bishop('a', (byte)8);
            System.out.println("Bishop set on board to (a, 8)");
            bishop.turn('c', (byte)2);
            System.out.println("Bishop moved (a, 8)->(c, 2)");
        } catch (OutOfBoardException | TakenPositionException | IllegalTurnException e) {
            System.out.println(e.getMessage().strip());
        } finally {
            if(bishop != null) {
                bishop.removeFromBoard();
                System.out.println("Bishop removed");
            }
        }
    }
}
