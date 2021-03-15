package com.croc;

/**
 * Class for chess bishop - figure
 * @author ChekhovAI
 */
public class Bishop extends Figure {

    /**
     * Constructor with setting bishop on the board
     * @param column to set column of bishop
     * @param row    to set row of bishop
     * @throws OutOfBoardException    when param coords are out of board
     * @throws TakenPositionException when param coords are taken
     */
    Bishop(char column, byte row) throws OutOfBoardException, TakenPositionException {
        super(column, row);
    }

    /**
     * Method to do turn of bishop
     * @param column of turn
     * @param row    of turn
     * @return this for do a series of turns
     * @throws OutOfBoardException    when the turn is out of the board
     * @throws TakenPositionException when pos of the turn is taken
     * @throws IllegalTurnException   when the turn is unsupported by bishop
     */
    @Override
    public Figure turn(char column, byte row)
            throws OutOfBoardException, TakenPositionException, IllegalTurnException {
        if (this.getColumn() - column == 0 && this.getRow() - row == 0 ||
                Math.abs(this.getColumn() - column) !=  Math.abs(this.getRow() - row)){
            throw new IllegalTurnException(
                    String.format("The turn (%c, %d)->(%c, %d) are not supported by bishop",
                            this.getColumn(), this.getRow(), column, row)
            );
        }
        return super.turn(column, row);
    }
}
