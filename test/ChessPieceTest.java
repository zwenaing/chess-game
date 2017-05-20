import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * This class includes the test cases for testing every aspect for methods
 * implementing the interface ChessPiece.
 */
public class ChessPieceTest {

  ChessPiece b1;
  ChessPiece b2;
  ChessPiece b3;
  ChessPiece k1;
  ChessPiece k2;
  ChessPiece k3;
  ChessPiece q1;
  ChessPiece q2;
  ChessPiece q3;
  ChessPiece p1;
  ChessPiece p2;
  ChessPiece p3;
  ChessPiece r1;
  ChessPiece r2;
  ChessPiece r3;

  /**
   * Setting up the ChessPiece Objects necessary for testing purposes.
   */
  @Before
  public void setUp() {
    b1 = new Bishop(1, 5, Color.BLACK);
    b2 = new Bishop(2, 4, Color.WHITE);
    b3 = new Bishop(4, 2, Color.WHITE);
    k1 = new Knight(0, 0, Color.BLACK);
    k2 = new Knight(7, 7, Color.WHITE);
    k3 = new Knight(3, 4, Color.BLACK);
    q1 = new Queen(5, 6, Color.WHITE);
    q2 = new Queen(6, 4, Color.BLACK);
    q3 = new Queen(7, 0, Color.WHITE);
    p1 = new Pawn(0, 0, Color.WHITE);
    p2 = new Pawn(7, 7, Color.BLACK);
    p3 = new Pawn(3, 4, Color.BLACK);
    r1 = new Rook(0, 0, Color.BLACK);
    r2 = new Rook(7, 7, Color.WHITE);
    r3 = new Rook(3, 4, Color.BLACK);
  }

  // Test cases to check whether the constructors work properly
  @Test
  public void testConstructors() {
    assertEquals("Bishop: [Row: 1, Column: 5, Color: black]", b1.toString());
    assertEquals("Bishop: [Row: 2, Column: 4, Color: white]", b2.toString());
    assertEquals("Knight: [Row: 0, Column: 0, Color: black]", k1.toString());
    assertEquals("Knight: [Row: 7, Column: 7, Color: white]", k2.toString());
    assertEquals("Queen: [Row: 5, Column: 6, Color: white]", q1.toString());
    assertEquals("Queen: [Row: 6, Column: 4, Color: black]", q2.toString());
  }

  // Test cases to check whether the constructors throw exceptions properly

  // Illegal row number of Bishop
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor1() {
    new Bishop(-1, 3, Color.WHITE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor2() {
    ChessPiece bishop = new Bishop(8, 3, Color.WHITE);
  }

  // Illegal column number of Bishop
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor3() {
    new Bishop(3, -1, Color.BLACK);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor4() {
    new Bishop(5, 10, Color.BLACK);
  }

  // Illegal row number of Knight
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor5() {
    new Knight(-1, 3, Color.WHITE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor6() {
    new Knight(8, 3, Color.WHITE);
  }

  // Illegal column number of Knight
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor7() {
    new Knight(3, -1, Color.BLACK);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor8() {
    new Knight(5, 10, Color.BLACK);
  }

  // Illegal row number of Queen
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor9() {
    new Queen(-1, 3, Color.WHITE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor10() {
    new Queen(8, 3, Color.WHITE);
  }

  // Illegal column number of Queen
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor11() {
    new Queen(3, -1, Color.BLACK);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor12() {
    new Queen(5, 10, Color.BLACK);
  }

  // Test cases to check whether the getRow method works properly
  @Test
  public void getRow() {
    assertEquals(1, b1.getRow());
    assertEquals(2, b2.getRow());
    assertEquals(4, b3.getRow());
    assertEquals(0, k1.getRow());
    assertEquals(7, k2.getRow());
    assertEquals(3, k3.getRow());
    assertEquals(5, q1.getRow());
    assertEquals(6, q2.getRow());
    assertEquals(7, q3.getRow());
  }

  // Test cases to check whether the getColumn method works properly
  @Test
  public void testGetColumn() {
    assertEquals(5, b1.getCol());
    assertEquals(4, b2.getCol());
    assertEquals(2, b3.getCol());
    assertEquals(0, k1.getCol());
    assertEquals(7, k2.getCol());
    assertEquals(4, k3.getCol());
    assertEquals(6, q1.getCol());
    assertEquals(4, q2.getCol());
    assertEquals(0, q3.getCol());
  }

  // Test cases to check whether the getColumn method works properly
  @Test
  public void testGetColor() {
    assertEquals(Color.BLACK, b1.getColor());
    assertEquals(Color.BLACK, k1.getColor());
    assertEquals(Color.WHITE, q1.getColor());
  }

  // Test cases to check whether the canMove method for Bishop works properly
  @Test
  public void testBishopCanMove() {
    // Bishop-1 eligible moves
    assertTrue(b1.canMove(2, 6));
    assertTrue(b1.canMove(0, 4));
    assertTrue(b1.canMove(0, 6));
    assertTrue(b1.canMove(3, 3));
    // Bishop-1 non-eligible moves
    assertFalse(b1.canMove(1, 0));
    assertFalse(b1.canMove(1, 7));
    assertFalse(b1.canMove(3, 6));
    assertFalse(b1.canMove(5, 2));
    // Bishop-2 eligible moves
    assertTrue(b2.canMove(5, 1));
    assertTrue(b2.canMove(0, 6));
    assertTrue(b2.canMove(0, 2));
    assertTrue(b2.canMove(3, 5));
    // Bishop-2 non-eligible moves
    assertFalse(b2.canMove(1, 2));
    assertFalse(b2.canMove(3, 7));
    assertFalse(b2.canMove(1, 6));
    assertFalse(b2.canMove(4, 4));
    // Bishops can move to the same position
    assertTrue(b1.canMove(1, 5));
    assertTrue(b2.canMove(2, 4));
  }

  // Test cases to check whether the canMove method for Bishop throws exceptions for
  // illegal row and column numbers
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalBishopCanMove1() {
    b1.canMove(-1, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalBishopCanMove2() {
    b1.canMove(10, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalBishopCanMove3() {
    b1.canMove(4, -2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalBishopCanMove4() {
    b1.canMove(6, 10);
  }

  // Test cases to check whether the canKill method for Bishop works properly
  @Test
  public void testBishopCanKill() {
    // Can kill ChessPieces on the diagonal lines
    assertTrue(b1.canKill(new Bishop(3, 7, Color.WHITE)));
    assertTrue(b1.canKill(new Knight(6, 0, Color.WHITE)));
    assertTrue(b1.canKill(new Queen(0, 4, Color.WHITE)));
    assertTrue(b1.canKill(new Bishop(0, 6, Color.WHITE)));
    // Can't kill ChessPieces outside the diagonal lines
    assertFalse(b1.canKill(new Bishop(2, 5, Color.WHITE)));
    assertFalse(b1.canKill(new Knight(1, 7, Color.BLACK)));
    assertFalse(b1.canKill(new Queen(2, 3, Color.WHITE)));
    assertFalse(b1.canKill(new Bishop(0, 6, Color.BLACK)));
    assertFalse(b1.canKill(new Queen(3, 7, Color.BLACK)));
    // Bishops can kill another piece at the same position
    assertTrue(b1.canKill(new Knight(1, 5, Color.WHITE)));
    assertTrue(b2.canKill(new Queen(2, 4, Color.BLACK)));
  }

  // Test cases to check whether the canKill method for Bishop throws exceptions for
  // given illegal ChessPiece
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalBishopCanKill1() {
    b1.canKill(new Bishop(-1, 4, Color.BLACK));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalBishopCanKill2() {
    b1.canKill(new Bishop(10, 4, Color.WHITE));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalBishopCanKill3() {
    b1.canKill(new Bishop(4, -2, Color.BLACK));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalBishopCanKill4() {
    b1.canKill(new Bishop(5, 8, Color.WHITE));
  }

  // Test cases to check whether the canMove method for Knight works properly
  @Test
  public void testKnightCanMove() {
    // Knights eligible moves
    assertTrue(k1.canMove(2, 1));
    assertTrue(k1.canMove(1, 2));
    assertTrue(k2.canMove(6, 5));
    assertTrue(k2.canMove(5, 6));
    assertTrue(k3.canMove(5, 3));
    assertTrue(k3.canMove(1, 3));
    assertTrue(k3.canMove(2, 6));
    assertTrue(k3.canMove(4, 6));
    // Knights non-eligible moves
    assertFalse(k1.canMove(2, 2));
    assertFalse(k2.canMove(3, 3));
    assertFalse(k3.canMove(4, 3));
    assertFalse(k3.canMove(1, 6));
    // Knights can move to the same position
    assertFalse(k2.canMove(7, 7));
    assertFalse(k3.canMove(3, 4));
  }

  // Test cases to check whether the canMove method for Knight throws exceptions for
  // illegal row and column numbers
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalKnightCanMove1() {
    k1.canMove(-1, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalKnightCanMove2() {
    k1.canMove(10, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalKnightCanMove3() {
    k1.canMove(4, -2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalKnightCanMove4() {
    k1.canMove(6, 10);
  }

  // Test cases to check whether the canKill method for Knight works properly
  @Test
  public void testKnightCanKill() {
    // Can kill ChessPieces on the straight lines
    assertTrue(k1.canKill(new Bishop(1, 2, Color.WHITE)));
    assertTrue(k1.canKill(new Queen(2, 1, Color.WHITE)));
    assertTrue(k3.canKill(new Knight(4, 2, Color.WHITE)));
    assertTrue(k3.canKill(new Knight(1, 5, Color.WHITE)));
    assertTrue(k2.canKill(new Bishop(6, 5, Color.BLACK)));
    assertTrue(k2.canKill(new Queen(5, 6, Color.BLACK)));
    // Can't kill ChessPieces outside the straight lines
    assertFalse(k1.canKill(new Queen(3, 3, Color.WHITE)));
    assertFalse(k3.canKill(new Bishop(4, 3, Color.BLACK)));
    assertFalse(k2.canKill(new Knight(6, 6, Color.BLACK)));
    assertFalse(k1.canKill(new Bishop(1, 2, Color.BLACK)));
    assertFalse(k2.canKill(new Knight(1, 5, Color.WHITE)));
    assertFalse(k3.canKill(new Queen(5, 6, Color.BLACK)));
    // Knights can't kill another piece at the same position
    assertFalse(k1.canKill(new Knight(0, 0, Color.BLACK)));
    assertFalse(k2.canKill(new Queen(7, 7, Color.WHITE)));
  }

  // Test cases to check whether the canMove method for Knight throws exceptions for
  // given illegal ChessPiece
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalKnightCanKill1() {
    k1.canKill(new Knight(-1, 4, Color.BLACK));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalKnightCanKill2() {
    k1.canKill(new Knight(10, 4, Color.WHITE));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalKnightCanKill3() {
    k1.canKill(new Knight(4, -2, Color.BLACK));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalKnightCanKill4() {
    k1.canKill(new Knight(5, 8, Color.WHITE));
  }

  // Test cases to check whether the canMove method for Queen works properly
  @Test
  public void testQueenCanMove() {
    // Queen eligible moves
    assertTrue(q2.canMove(3, 1)); // diagonal
    assertTrue(q2.canMove(7, 5)); // diagonal
    assertTrue(q2.canMove(7, 3)); // diagonal
    assertTrue(q2.canMove(4, 6)); // diagonal
    assertTrue(q2.canMove(7, 4)); // up
    assertTrue(q2.canMove(3, 4)); // down
    assertTrue(q2.canMove(6, 1)); // left
    assertTrue(q2.canMove(6, 7)); // right
    // Queen non-eligible moves
    assertFalse(q2.canMove(5, 2));
    assertFalse(q2.canMove(7, 7));
    assertFalse(q2.canMove(4, 7));
    assertFalse(q2.canMove(4, 3));
    // Queens can move to the same position
    assertTrue(q1.canMove(5, 6));
    assertTrue(q3.canMove(7, 0));
  }

  // Test cases to check whether the canMove method for Queen throws exceptions for
  // illegal row and column numbers
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalQueenCanMove1() {
    q1.canMove(-1, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalQueenCanMove2() {
    q1.canMove(10, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalQueenCanMove3() {
    q1.canMove(4, -2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalQueenCanMove4() {
    q1.canMove(6, 10);
  }

  // Test cases to check whether the canKill method for Queen works properly
  @Test
  public void testQueenCanKill() {
    // Queen can kill any ChessPiece on diagonal or straight lines
    assertTrue(q2.canKill(new Bishop(4, 2, Color.WHITE)));
    assertTrue(q2.canKill(new Queen(3, 7, Color.WHITE)));
    assertTrue(q2.canKill(new Bishop(0, 4, Color.WHITE)));
    assertTrue(q2.canKill(new Queen(7, 5, Color.WHITE)));
    assertTrue(q2.canKill(new Knight(2, 0, Color.WHITE)));
    // Queen can't kill any ChessPiece outside diagonal or straight lines
    assertFalse(q2.canKill(new Bishop(4, 3, Color.BLACK)));
    assertFalse(q2.canKill(new Queen(0, 2, Color.WHITE)));
    assertFalse(q2.canKill(new Knight(7, 6, Color.WHITE)));
    assertFalse(q2.canKill(new Bishop(2, 6, Color.BLACK)));
    assertFalse(q2.canKill(new Queen(4, 2, Color.BLACK)));
    assertFalse(q3.canKill(new Knight(5, 2, Color.WHITE)));
    assertFalse(q1.canKill(new Queen(5, 3, Color.WHITE)));
    // Queens can kill another piece at the same position
    assertTrue(q2.canKill(new Queen(6, 4, Color.WHITE)));
    assertTrue(q1.canKill(new Knight(5, 6, Color.BLACK)));
  }

  // Test cases to check whether the canMove method for Queen throws exceptions for
  // given illegal ChessPiece
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalQueenCanKill1() {
    q1.canKill(new Queen(-1, 4, Color.BLACK));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalQueenCanKill2() {
    q1.canKill(new Queen(10, 4, Color.WHITE));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalQueenCanKill3() {
    q1.canKill(new Queen(4, -2, Color.BLACK));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalQueenCanKill4() {
    q1.canKill(new Queen(5, 8, Color.WHITE));
  }

  // Test cases to check whether the canMove method for Pawn works properly
  @Test
  public void testPawnCanMove() {
    // Pawn-1 2 3 eligible moves
    assertTrue(p1.canMove(1, 0));
    assertTrue(p2.canMove(6, 7));
    assertTrue(p3.canMove(2, 4));

    // Pawn-1 non-eligible moves
    assertFalse(p1.canMove(1, 1));
    assertFalse(p1.canMove(0, 2));

    // Pawn-2 non-eligible moves
    assertFalse(p2.canMove(6, 6));
    assertFalse(p2.canMove(5, 7));

    // Pawn-3 non-eligible moves
    assertFalse(p3.canMove(1, 2));
    assertFalse(p3.canMove(3, 7));
    assertFalse(p3.canMove(5, 4));

    assertFalse(p3.canMove(3, 4));
  }

  // Test cases to check whether the canMove method for Pawn throws exceptions for
  // illegal row and column numbers
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalPawnCanMove1() {
    p1.canMove(-1, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalPawnCanMove2() {
    p1.canMove(10, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalPawnCanMove3() {
    p1.canMove(4, -2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalPawnCanMove4() {
    p1.canMove(6, 10);
  }

  // Test cases to check whether the canKill method for Pawn works properly
  @Test
  public void testPawnCanKill() {
    // Pawn can kill any ChessPiece on one place forward diagonally
    assertTrue(p1.canKill(new Bishop(1, 1, Color.BLACK)));
    assertTrue(p3.canKill(new Queen(2, 5, Color.WHITE)));
    assertTrue(p3.canKill(new Bishop(2, 3, Color.WHITE)));
    assertTrue(p2.canKill(new Bishop(6, 6, Color.WHITE)));
    // Pawn can't kill any ChessPiece outside diagonal or same color
    assertFalse(p2.canKill(new Bishop(4, 3, Color.WHITE)));
    assertFalse(p3.canKill(new Knight(4, 5, Color.WHITE)));
    assertFalse(p2.canKill(new Queen(0, 2, Color.BLACK)));
    assertFalse(p3.canKill(new Queen(4, 3, Color.WHITE)));
    assertFalse(p1.canKill(new Bishop(0, 0, Color.WHITE)));
  }

  // Test cases to check whether the canKill method for Pawn throws exceptions for
  // given illegal ChessPiece
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalPawnCanKill1() {
    p1.canKill(new Bishop(-1, 4, Color.BLACK));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalPawnCanKill2() {
    p1.canKill(new Bishop(10, 4, Color.WHITE));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalPawnCanKill3() {
    p1.canKill(new Bishop(4, -2, Color.BLACK));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalPawnCanKill4() {
    p1.canKill(new Bishop(5, 8, Color.WHITE));
  }

  // Test cases to check whether the canMove method for Rook works properly
  @Test
  public void testRookCanMove() {
    // Rook-1 2 3 eligible moves
    assertTrue(r1.canMove(1, 0));
    assertTrue(r1.canMove(0, 1));
    assertTrue(r2.canMove(0, 7));
    assertTrue(r2.canMove(7, 0));
    assertTrue(r3.canMove(5, 4));
    assertTrue(r3.canMove(3, 6));

    // Rook-1 non-eligible moves
    assertFalse(r1.canMove(1, 1));
    assertFalse(r1.canMove(2, 2));

    // Rook-2 non-eligible moves
    assertFalse(r2.canMove(6, 6));
    assertFalse(r2.canMove(5, 3));

    // Rook-3 non-eligible moves
    assertFalse(r3.canMove(1, 2));
    assertFalse(r3.canMove(5, 3));

    assertTrue(r1.canMove(0, 0));
  }

  // Test cases to check whether the canMove method for Rook throws exceptions for
  // illegal row and column numbers
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalRookCanMove1() {
    r1.canMove(-1, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalRookCanMove2() {
    r1.canMove(10, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalRookCanMove3() {
    r1.canMove(4, -2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalRookCanMove4() {
    r1.canMove(6, 10);
  }

  // Test cases to check whether the canKill method for Rook works properly
  @Test
  public void testRookCanKill() {
    // Rook can kill any ChessPiece move horizontally or vertically
    assertTrue(r1.canKill(new Bishop(0, 1, Color.WHITE)));
    assertTrue(r1.canKill(new Bishop(1, 0, Color.WHITE)));
    assertTrue(r3.canKill(new Queen(3, 5, Color.WHITE)));
    assertTrue(r3.canKill(new Bishop(6, 4, Color.WHITE)));
    assertTrue(r2.canKill(new Bishop(0, 7, Color.BLACK)));
    assertTrue(r2.canKill(new Bishop(5, 7, Color.BLACK)));
    // Rook can't kill any ChessPiece outside diagonal or same color
    assertFalse(r2.canKill(new Bishop(0, 7, Color.WHITE)));
    assertFalse(r2.canKill(new Queen(2, 2, Color.BLACK)));

    assertTrue(r1.canKill(new Bishop(0, 0, Color.WHITE)));
  }

  // Test cases to check whether the canKill method for Pawn throws exceptions for
  // given illegal ChessPiece
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalRookCanKill1() {
    r1.canKill(new Bishop(-1, 4, Color.BLACK));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalRookCanKill2() {
    r1.canKill(new Bishop(10, 4, Color.WHITE));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalRookCanKill3() {
    r1.canKill(new Bishop(4, -2, Color.BLACK));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalRookCanKill4() {
    r1.canKill(new Bishop(5, 8, Color.WHITE));
  }

}