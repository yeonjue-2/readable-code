package cleancode.minesweeper.tobe.minesweeper.board;

import cleancode.minesweeper.tobe.minesweeper.board.cell.Cell;
import cleancode.minesweeper.tobe.minesweeper.board.cell.CellSnapshot;
import cleancode.minesweeper.tobe.minesweeper.board.cell.EmptyCell;
import cleancode.minesweeper.tobe.minesweeper.board.position.CellPosition;
import cleancode.minesweeper.tobe.minesweeper.gamelevel.Advanced;
import cleancode.minesweeper.tobe.minesweeper.gamelevel.VeryBeginner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest {

    @Test
    @DisplayName("isInvalidCellPosition() - 정상 동작, 셀 위치가 보드 범위 밖일 때 true 반환")
    void isInvalidCellPosition_success() {
        GameBoard gameBoard = new GameBoard(new Advanced()); // 20행 x 24열

        // when
        boolean rowOut = gameBoard.isInvalidCellPosition(CellPosition.of(20, 5));
        boolean colOut = gameBoard.isInvalidCellPosition(CellPosition.of(5, 24));
        boolean bothOut = gameBoard.isInvalidCellPosition(CellPosition.of(21, 25));

        // then
        assertThat(rowOut).isTrue();
        assertThat(colOut).isTrue();
        assertThat(bothOut).isTrue();
    }

    @Test
    @DisplayName("isInvalidCellPosition() - 셀 위치가 보드 범위 내 일 때 false 반환")
    void isInvalidCellPosition_returnFalse() {
        GameBoard gameBoard = new GameBoard(new VeryBeginner()); // 4행 x 5열

        // when
        boolean bothIn = gameBoard.isInvalidCellPosition(CellPosition.of(3, 4));

        // then
        assertThat(bothIn).isFalse();
    }

    @Test
    @DisplayName("getSnapshot() - 열리지 않은 EmptyCell은 UnChecked 반환")
    void getSnapshot_unopenedEmptyCell_returnsUnChecked() throws Exception {
        // given
        EmptyCell cell = new EmptyCell();
        GameBoard gameBoard = createGameBoardWithCell(cell);

        // when
        CellSnapshot snapshot = gameBoard.getSnapshot(CellPosition.of(0, 0));

        // then
        assertThat(snapshot).isEqualTo(CellSnapshot.ofUnChecked());
    }

    @Test
    @DisplayName("getSnapshot() flag된 EmptyCell은 Flag 반환")
    void getSnapshot_flaggedEmptyCell_returnsFlag() throws Exception {
        // given
        EmptyCell cell = new EmptyCell();
        cell.flag();
        GameBoard gameBoard = createGameBoardWithCell(cell);

        // when
        CellSnapshot snapshot = gameBoard.getSnapshot(CellPosition.of(0, 0));

        // then
        assertThat(snapshot).isEqualTo(CellSnapshot.ofFlag());
    }

    @Test
    @DisplayName("getSnapshot() open된 EmptyCell은 Empty 반환")
    void getSnapshot_openedEmptyCell_returnsEmpty() throws Exception {
        // given
        EmptyCell cell = new EmptyCell();
        cell.open();
        GameBoard gameBoard = createGameBoardWithCell(cell);

        // when
        CellSnapshot snapshot = gameBoard.getSnapshot(CellPosition.of(0, 0));

        // then
        assertThat(snapshot).isEqualTo(CellSnapshot.ofEmpty());
    }

    private GameBoard createGameBoardWithCell(Cell cell) throws Exception {
        GameBoard gameBoard = new GameBoard(new VeryBeginner());

        Field boardField = GameBoard.class.getDeclaredField("board");
        boardField.setAccessible(true);
        boardField.set(gameBoard, new Cell[][]{{cell}});  // 원하는 셀로 넣어줌

        return gameBoard;
    }
}
