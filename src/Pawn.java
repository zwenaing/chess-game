/**
 * This class represents a Pawn class and extends the AbstractChessPiece abstract class.
 */
public class Pawn extends AbstractChessPiece {

  /**
   * Constructs a Pawn given row, column and color.
   *
   * @param row the row number
   * @param column the column number
   * @param color the color of this piece
   * @throws IllegalArgumentException if the given row and column number are out of range
   */
  public Pawn(int row, int column, Color color) {
    super(row, column, color);
  }

  /**
   * Determine this piece is allowed to move to that desired position given the row and column
   * of that position.
   *
   * @param row the row number of the desired position
   * @param col the column number of the desired position
   * @return true if this piece can move to the given position, false otherwise
   * @throws IllegalArgumentException when the given row and column position is out of range
   */
  public boolean canMove(int row, int col) throws IllegalArgumentException {
    this.checkRowCol(row, col);
    if (this.row == row && this.column == col) {
      return false;
    }
    return ((this.color == Color.BLACK) && (row - this.row == 1) && (this.column == col))
        || ((this.color == Color.WHITE) && (this.row - row == 1) && (this.column == col));
  }

  /**
   * Determine this piece can kill the given ChessPiece.
   *
   * @param piece the given ChessPiece
   * @return true if this piece can kill the given ChessPiece, otherwise false
   * @throws IllegalArgumentException if the given ChessPiece constructor throws exception
   */
  public boolean canKill(ChessPiece piece) throws IllegalArgumentException {
    this.checkRowCol(piece.getRow(), piece.getCol());
    if (this.row == piece.getRow() && this.column == piece.getCol()) {
      return false;
    }
    return ((this.color != piece.getColor())
        && (this.row - piece.getRow() == 1)
        && (Math.abs(this.column - piece.getCol()) == 1))
        || ((this.color != piece.getColor())
        && (piece.getRow() - this.row == 1)
        && (Math.abs(this.column - piece.getCol()) == 1));
  }

  /**
   * Return the string representation of this piece.
   *
   * @return the formatted String
   */
  public String toString() {
    return "Pawn: " + super.toString();
  }

}