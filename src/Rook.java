/**
 * This class represents a Rook class and extends the AbstractChessPiece abstract class.
 */
public class Rook extends AbstractChessPiece {

  /**
   * Constructs a Rook given row, column and color.
   *
   * @param row the row number
   * @param column the column number
   * @param color the color of this piece
   * @throws IllegalArgumentException if the given row and column number are out of range
   */
  public Rook(int row, int column, Color color) {
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
    return this.onStraightLine(row, col);
  }

  /**
   * Return the string representation of this piece.
   *
   * @return the formatted String
   */
  public String toString() {
    return "Rook: " + super.toString();
  }

}