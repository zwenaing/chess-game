/**
 * This class represents a Bishop and extends the AbstractChessPiece abstract class.
 */
public class Bishop extends AbstractChessPiece {

  /**
   * Constructs a Bishop given row, column and color.
   *
   * @param row the row number
   * @param column the column number
   * @param color the color of this piece
   */
  public Bishop(int row, int column, Color color) {
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
    return (this.row == row && this.column == col) || this.onDiagonalLine(row, col);
  }

  /**
   * Return the string representation of this piece.
   *
   * @return the formatted String
   */
  public String toString() {
    return "Bishop: " + super.toString();
  }

}
