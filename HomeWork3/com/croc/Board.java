package com.croc;

/**
 * Class for storing taken positions of board
 * and checking illegal turns
 * @author ChekhovAI
 */
public class Board {
    /** Field for storing taken positions of board */
    private static final boolean[][] boardMatrix = new boolean[8][8];

    /**
     * Method to check coordinates (coords) for legality
     * @param x column of turn as char
     * @param y row of turn as int
     * @throws OutOfBoardException when coords are out of board
     * @throws TakenPositionException when there is figure on position of coords
     */
    protected static void chekPosition(char x, byte y)
            throws OutOfBoardException, TakenPositionException {
        if (x > 7 + 'a' || y > 7 || x < 'a' || y < 0) {
            throw new OutOfBoardException(
                    String.format("Coordinates (%c, %d) are illegal\n", x, y)
            );
        } else if (boardMatrix[y][(x - 'a')]) {
            throw new TakenPositionException(
                    String.format("Position with coordinates (%c, %d) is taken\n", x, y)
            );
        }
    }

    /**
     * Method to set figure on board
     * @param figure to set on board
     */
    public static void setFigure(Figure figure) {
        boardMatrix[figure.getRow()][(figure.getColumn() - 'a')] = true;
    }

    /**
     * Method to delete figure from board
     * @param figure to delete
     */
    public static void deleteFigure(Figure figure) {
        boardMatrix[figure.getRow()][(figure.getColumn() - 'a')] = false;
    }
}
