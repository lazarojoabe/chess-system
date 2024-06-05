package boardgame;

import chess.ChessPiece;
import javafx.scene.input.PickResult;

public class Board {
    private int rows;
    private int columns;
    private Piece [][] pieces;

    public Board(int columns, int rows) {
        if(rows < 1 || columns < 1){
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.columns = columns;
        this.rows = rows;
        pieces = new Piece[rows][columns];
    }

    public Piece piece(int row, int column){
        return pieces[row][column];
    }

    public Piece piece(Position position){
        if(!postionExists(position)){
            throw new BoardException("Error: position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piecie, Position position){
        if (thereIsAPiece(position)) {
            throw new BoardException("There is already a piece on position" + position);
        }
        pieces[position.getRow()][position.getColumn()] = piecie;
        piecie.position = position;
    }

    public boolean postionExists(Position positon){
        return positon.getRow() >= 0 && positon.getRow() < rows &&
                positon.getColumn() >= 0 && positon.getColumn() < columns;
    }

    public boolean thereIsAPiece(Position position){
        if(!postionExists(position)){
            throw new BoardException("Error: position not on the board");
        }
        return piece(position.getRow(), position.getColumn()) != null;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

}
