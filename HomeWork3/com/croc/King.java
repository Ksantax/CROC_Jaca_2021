package com.croc;

/**
 * Class for chess king - figure
 * @author ChekhovAI
 */
public class King extends Figure {
    /**
     * Constructor with setting king on the board
     * @param column to set column of king
     * @param row    to set row of king
     * @throws OutOfBoardException    when param coords are out of board
     * @throws TakenPositionException when param coords are taken
     */
    King(char column, byte row) throws OutOfBoardException, TakenPositionException {
        super(column, row);
    }

    /**
     * Method to do turn of king
     * @param column of turn
     * @param row    of turn
     * @return this for do a series of turns
     * @throws OutOfBoardException    when the turn is out of the board
     * @throws TakenPositionException when pos of the turn is taken
     * @throws IllegalTurnException   when the turn is unsupported by king
     */
    @Override
    public Figure turn(char column, byte row)
            throws OutOfBoardException, TakenPositionException, IllegalTurnException {
        if (this.getColumn() - column == 0 && this.getRow() - row == 0 ||
                Math.abs(this.getColumn() - column) > 1 || Math.abs(this.getRow() - row) > 1){
            throw new IllegalTurnException(
                    String.format("The turn (%c, %d)->(%c, %d) are not supported by king",
                            this.getColumn(), this.getRow(), column, row)
            );
        }
        return super.turn(column, row);
    }
}
