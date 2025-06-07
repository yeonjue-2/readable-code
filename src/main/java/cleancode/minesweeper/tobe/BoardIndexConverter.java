package cleancode.minesweeper.tobe;

public class BoardIndexConverter {

    private static final char BASIC_CHAR_FOR_COL = 'a';


    public int getSelectedRowIndex(String cellInput) {
        String cellInputRow = cellInput.substring(1);  // 1
        return convertRowFrom(cellInputRow);
    }

    public int getSelectedColIndex(String cellInput) {
        char cellInputCol = cellInput.charAt(0);  // a
        return convertColFrom(cellInputCol);
    }

    private int convertRowFrom(String cellInputRow) {
        int rowIndex = Integer.parseInt(cellInputRow) - 1;
        if (rowIndex < 0) {
            throw new GameException("잘못된 입력입니다.");
        }
        return rowIndex;
    }

    private int convertColFrom(char cellInputCol) {  // 'a' = 97
        int colIndex = cellInputCol - BASIC_CHAR_FOR_COL;
        if (colIndex < 0 ) {
            throw new GameException("잘못된 입력입니다.");
        }

        return colIndex;
    }
}
