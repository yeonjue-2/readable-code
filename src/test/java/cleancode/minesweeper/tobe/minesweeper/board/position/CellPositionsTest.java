package cleancode.minesweeper.tobe.minesweeper.board.position;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CellPositionsTest {

    @Test
    @DisplayName("extractRandomPositions 정상 동작 확인")
    void extractRandomPositions_success() {
        // given
        List<CellPosition> original = Arrays.asList(
            CellPosition.of(0, 0),
            CellPosition.of(0, 1),
            CellPosition.of(1, 0),
            CellPosition.of(1, 1)
        );

        CellPositions positions = CellPositions.of(original);
        int count = 2;

        // when
        List<CellPosition> result = positions.extractRandomPositions(count);

        // then
        assertThat(result).hasSize(count);
        assertThat(result).allMatch(original::contains);
    }

}
