package com.croc;

/**
 * Class for chess knight - figure
 * @author ChekhovAI
 */
public class Knight extends Figure {

    /**
     * Constructor with setting knight on the board
     * @param column to set column of knight
     * @param row    to set row of knight
     * @throws OutOfBoardException    when param coords are out of board
     * @throws TakenPositionException when param coords are taken
     */
    Knight(char column, byte row) throws OutOfBoardException, TakenPositionException {
        super(column, row);
    }

    /**
     * Method to do turn of knight
     * @param column of turn
     * @param row    of turn
     * @return this for do a series of turns
     * @throws OutOfBoardException    when the turn is out of the board
     * @throws TakenPositionException when pos of the turn is taken
     * @throws IllegalTurnException   when the turn is unsupported by knight
     */
    @Override
    public Figure turn(char column, byte row)
            throws OutOfBoardException, TakenPositionException, IllegalTurnException{
        if (this.getColumn() - column == 0 && this.getRow() - row == 0 ||
                !(this.getColumn() - column == 2 && this.getRow() - row == 1) ||
                !(this.getColumn() - column == 1 && this.getRow() - row == 2)) {
            throw new IllegalTurnException(
                    String.format("The turn (%c, %d)->(%c, %d) are not supported by knight",
                            this.getColumn(), this.getRow(), column, row)
            );
        }
        return super.turn(column, row);
    }
}
