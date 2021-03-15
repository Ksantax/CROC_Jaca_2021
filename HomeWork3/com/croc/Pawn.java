package com.croc;

/**
 * Class for chess pawn - Figure
 * @author ChekhovAI
 */
public class Pawn extends Figure{
    /**
     * Constructor with setting pawn on the board
     * @param column to set column of pawn
     * @param row    to set row of pawn
     * @throws OutOfBoardException when param coords are out of board
     * @throws TakenPositionException when param coords are taken
     */
    Pawn(char column, byte row) throws OutOfBoardException, TakenPositionException {
        super(column, row);
    }

    /**
     * Method to do turn of pawn
     * @param column of turn
     * @param row of turn
     * @return this for do a series of turns
     * @throws OutOfBoardException when the turn is out of the board
     * @throws TakenPositionException when pos of the turn is taken
     * @throws IllegalTurnException when the turn is unsupported by pawn
     */
    @Override
    public Figure turn(char column, byte row)
            throws OutOfBoardException, TakenPositionException, IllegalTurnException {
        if (Math.abs(this.getRow() - row) != 1 || this.getColumn() != column){
            throw new IllegalTurnException(
                    String.format("The turn (%c, %d)->(%c, %d) are not supported by pawn",
                            this.getColumn(), this.getRow(), column, row)
            );
        }
        return super.turn(column, row);
    }
}
