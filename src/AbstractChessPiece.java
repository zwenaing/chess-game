/**
 * This abstract class contains the fields and operations common to all subclasses.
 */
public abstract class AbstractChessPiece implements ChessPiece {

  protected final int MAX = 7; // the maximum row and column number
  protected final int MIN = 0; // the minimum row and column number

  protected int row;
  protected int column;
  protected Color color;

  /**
   * Constructs the AbstractChessPiece given row, column and color values.
   *
   * @param row the row number of this piece
   * @param column the column number of this piece
   * @param color the color of this piece
   * @throws IllegalArgumentException if the given row and column number are out of range
   */
  protected AbstractChessPiece(int row, int column, Color color) throws IllegalArgumentException {
    this.checkRowCol(row, column);
    this.row = row;
    this.column = column;
    this.color = color;
  }

  /**
   * Get the row number of the current position of this piece.
   *
   * @return the row number
   */
  public int getRow() {
    return this.row;
  }

  /**
   * Get the column number of the current position of this piece.
   *
   * @return the column number
   */
  public int getCol() {
    return this.column;
  }

  /**
   * Get the Color this piece.
   *
   * @return the Color
   */
  public Color getColor() {
    return this.color;
  }

  /**
   * Check the given row and column number is within acceptable range.
   * Otherwise, throws an exception.
   *
   * @param row the row number
   * @param column the column number
   * @throws IllegalArgumentException if the given row and column number are out of range
   */
  protected void checkRowCol(int row, int column) throws IllegalArgumentException {
    if (row < MIN || row > MAX) {
      throw new IllegalArgumentException("Row number must be between 0 and 7");
    }
    if (column < MIN || column > MAX) {
      throw new IllegalArgumentException("Column number must be between 0 and 7");
    }
  }

  /**
   * Determine this piece can kill the given ChessPiece. This piece can kill another ChessPiece if
   * this piece can move to that position and they are in different colors.
   *
   * @param piece the given ChessPiece
   * @return true if this piece can kill the given ChessPiece, otherwise false
   * @throws IllegalArgumentException if the given ChessPiece is in the same position as this piece
   */
  public boolean canKill(ChessPiece piece) throws IllegalArgumentException {
    if ((this.row == piece.getRow()) && (this.column == piece.getCol())) {
      return false;
    }
    return this.canMove(piece.getRow(), piece.getCol())
        && (this.color != piece.getColor());
  }

  /**
   * Check whether the given position with row and column is on the diagonal line of this piece.
   *
   * @param row the row number of the given position
   * @param column the column number of the given position
   * @return true if the given position is on the diagonal line of this piece, otherwise false
   */
  protected boolean onDiagonalLine(int row, int column) {
    return Math.abs(this.row - row) == Math.abs(this.column - column);
  }

  /**
   * Check whether the given position with row and column is on the straight line of this piece.
   *
   * @param row the row number of the given position
   * @param column the column number of the given position
   * @return true if the given position is on the straight line of this piece, otherwise false
   */
  protected boolean onStraightLine(int row, int column) {
    return (this.row == row) || (this.column == column);
  }

  /**
   * Return the string representation of this piece.
   *
   * @return the formatted String
   */
  public String toString() {
    return "[Row: " + this.row + ", Column: " + this.column + ", Color: " + (
        (this.color == Color.BLACK) ? "black]" : "white]");
  }
}
