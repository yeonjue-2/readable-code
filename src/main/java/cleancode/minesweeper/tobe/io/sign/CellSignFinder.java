package cleancode.minesweeper.tobe.io.sign;

import cleancode.minesweeper.tobe.cell.CellSnapshot;

import java.util.List;

public class CellSignFinder {

    public static final List<CellSignProvidable> CELL_SIGN_PROVIDERS = List.of(
            new EmptyCellSignProvider(),
            new FlagCellSignProvider(),
            new LandMineCellSignProvider(),
            new NumberCellSignProvider(),
            new UncheckedMineCellSignProvider()
    );

    public String findCellSignFrom(CellSnapshot snapshot) {
        return CELL_SIGN_PROVIDERS.stream()
                .filter(p -> p.supports(snapshot))
                .findFirst()
                .map(p -> p.provide(snapshot))
                .orElseThrow(() -> new IllegalArgumentException("확인할 수 없는 셀입니다."));
    }
}
