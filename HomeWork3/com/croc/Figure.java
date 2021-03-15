package com.croc;

/**
 * Abstract class for chess figures
 * @author ChekhovAI
 */
abstract public class Figure {
    /** Field for column of figure */
    private char column;
    /** Field for row of figure */
    private byte row;

    /**
     * Constructor with setting figure on the board
     * @param column to set column of figure
     * @param row    to set row of figure
     * @throws OutOfBoardException when param coords are out of board
     * @throws TakenPositionException when param coords are taken
     */
    Figure(char column, byte row) throws OutOfBoardException, TakenPositionException {
        Board.chekPosition(column, row);
        this.column = column;
        this.row = row;
        Board.setFigure(this);
    }

    /**
     * Getter for column of figure
     * @return column of figure
     */
    public char getColumn() {
        return column;
    }

    /**
     * Getter for row of figure
     * @return row of figure
     */
    public byte getRow() {
        return row;
    }

    /** Setter for column of figure
     * @param column to set
     */
    public void setColumn(char column) {
        this.column = column;
    }

    /** Setter for row of figure
     * @param row to set
     */
    public void setRow(byte row) {
        this.row= row;
    }

    /**
     * Method to do turn of figure
     * @param column of turn
     * @param row    of turn
     * @return this for do a series of turns
     * @throws OutOfBoardException    when the turn is out of the board
     * @throws TakenPositionException when pos of the turn is taken
     * @throws IllegalTurnException   when the turn is unsupported by figure
     */
    public Figure turn(char column, byte row)
            throws OutOfBoardException, TakenPositionException, IllegalTurnException{
        Board.chekPosition(column, row);
        Board.deleteFigure(this);
        this.setRow(row);
        this.setColumn(column);
        Board.setFigure(this);
        return this;
    }

    /** Method to remove the figure from the board */
    public void removeFromBoard() {Board.deleteFigure(this);}
}
