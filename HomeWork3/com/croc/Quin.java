package com.croc;

/**
 * Class for chess quin - figure
 * @author ChekhovAI
 */
public class Quin extends Figure {
    /**
     * Constructor with setting quin on the board
     * @param column to set column of quin
     * @param row    to set row of quin
     * @throws OutOfBoardException    when param coords are out of board
     * @throws TakenPositionException when param coords are taken
     */
    Quin(char column, byte row) throws OutOfBoardException, TakenPositionException {
        super(column, row);
    }

    /**
     * Method to do turn of quin
     * @param column of turn
     * @param row    of turn
     * @return this for do a series of turns
     * @throws OutOfBoardException    when the turn is out of the board
     * @throws TakenPositionException when pos of the turn is taken
     * @throws IllegalTurnException   when the turn is unsupported by quin
     */
    @Override
    public Figure turn(char column, byte row)
            throws OutOfBoardException, TakenPositionException, IllegalTurnException {
        if (this.getColumn() - column == 0 && this.getRow() - row == 0 ||
                Math.abs(this.getColumn() - column) !=  Math.abs(this.getRow() - row) &&
                (this.getColumn() - column != 0 && this.getRow() - row == 0 ||
                 this.getColumn() - column == 0 && this.getRow() - row != 0)){
            throw new IllegalTurnException(
                    String.format("The turn (%c, %d)->(%c, %d) are not supported by quin",
                            this.getColumn(), this.getRow(), column, row)
            );
        }
        return super.turn(column, row);
    }
}
