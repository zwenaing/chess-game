/**
 * This interface represents a ChessPiece, and contains all operations a ChessPiece can perform.
 */
public interface ChessPiece {

  /**
   * Get the row number of the current position of this piece.
   *
   * @return the row number
   */
  int getRow();

  /**
   * Get the column number of the current position of this piece.
   *
   * @return the column number
   */
  int getCol();

  /**
   * Get the Color this piece.
   *
   * @return the Color
   */
  Color getColor();

  /**
   * Determine this piece is allowed to move to that desired position given the row and column
   * of that position.
   *
   * @param row the row number of the desired position
   * @param col the column number of the desired position
   * @return true if this piece can move to the given position, false otherwise
   * @throws IllegalArgumentException when the given row and column position is out of range
   */
  boolean canMove(int row, int col) throws IllegalArgumentException;

  /**
   * Determine this piece can kill the given ChessPiece.
   *
   * @param piece the given ChessPiece
   * @return true if this piece can kill the given ChessPiece, otherwise false
   * @throws IllegalArgumentException if the given ChessPiece constructor throws exception
   */
  boolean canKill(ChessPiece piece) throws IllegalArgumentException;

}
