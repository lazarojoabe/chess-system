package chess;

import boardgame.BoardException;
import boardgame.Position;

public class ChessPosition {
    private char column;
    private int row;

    public ChessPosition(char column, int row) {
        if(column < 'a' || column > 'h' || row < 1 || row > 8){
            throw new ChessException("Error instantianing ChessPositon. Valid values are from a1 to h8");
        }
        this.column = column;
        this.row = row;
    }

    //converting positions

    //Chess matrix -> matrix
    protected Position toPosition(){
        return new Position(8 - row, column - 'a');
    }
    //matrix -> chess matrix
    protected static ChessPosition fromPosition(Position position){
        return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
    }

    @Override
    public String toString() {
        return "" + column + row;
    }

    public char getColumn() {
        return column;
    }

    public void setColumn(char column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
