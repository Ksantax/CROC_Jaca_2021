package com.croc;

/**
 * Class for chess rook - figure
 * @author ChekhovAI
 */
public class Rook extends Figure {
    /**
     * Constructor with setting rook on the board
     * @param column to set column of rook
     * @param row    to set row of rook
     * @throws OutOfBoardException    when param coords are out of board
     * @throws TakenPositionException when param coords are taken
     */
    Rook(char column, byte row) throws OutOfBoardException, TakenPositionException {
        super(column, row);
    }

    /**
     * Method to do turn of rook
     * @param column of turn
     * @param row    of turn
     * @return this for do a series of turns
     * @throws OutOfBoardException    when the turn is out of the board
     * @throws TakenPositionException when pos of the turn is taken
     * @throws IllegalTurnException   when the turn is unsupported by rook
     */
    @Override
    public Figure turn(char column, byte row)
            throws OutOfBoardException, TakenPositionException, IllegalTurnException {
        if (this.getColumn() - column != 0 && this.getRow() - row != 0 ||
                this.getColumn() - column == 0 && this.getRow() - row == 0){
            throw new IllegalTurnException(
                    String.format("The turn (%c, %d)->(%c, %d) are not supported by rook",
                            this.getColumn(), this.getRow(), column, row)
            );
        }
        return super.turn(column, row);
    }

}
