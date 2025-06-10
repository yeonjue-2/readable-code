package cleancode.minesweeper.tobe.minesweeper.board.cell;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmptyCellTest {

    @Test
    @DisplayName("flag() 실행 전 상태 확인")
    void testFlag_notOperated() {
        // given
        EmptyCell cell = new EmptyCell();

        // when - flag() 호출 없음

        // then
        assertThat(cell.isOpened()).isFalse();
        assertThat(cell.getSnapshot()).isEqualTo(CellSnapshot.ofUnChecked());
    }

    @Test
    @DisplayName("flag() - 정상 동작 확인")
    void testFlag_success() {
        // given
        EmptyCell cell = new EmptyCell();

        // when
        cell.flag();

        // then
        assertThat(cell.isOpened()).isFalse();
        assertThat(cell.getSnapshot()).isEqualTo(CellSnapshot.ofFlag());
    }

    @Test
    @DisplayName("open() - 정상 동작 확인 및 EmptyCell일 경우 snapShot 빈 셀 반환")
    void testOpen_success() {
        // given
        EmptyCell cell = new EmptyCell();

        // when
        cell.open();

        // then
        assertThat(cell.isOpened()).isTrue();
        assertThat(cell.isChecked()).isTrue();
        assertThat(cell.getSnapshot()).isEqualTo(CellSnapshot.ofEmpty());
    }
}
