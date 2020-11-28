public abstract class DetermineWin {

    enum Direction {UP, DOWN, RIGHT, LEFT, DIAG_UP_RIGHT, DIAG_UP_LEFT, DIAG_DOWN_RIGHT, DIAG_DOWN_LEFT}

    public static int countPieces(int row, int col, Piece type, Direction direction){
        boolean isColInc;
        boolean isColDec;
        boolean isRowInc;
        boolean isRowDec;

        switch (direction){
            case UP:
                isRowDec = true;
            case DOWN:
                isRowInc = true;
                break;
            case RIGHT:
                isColInc = true;
                break;
            case LEFT:
                isColDec = true;
            case DIAG_UP_RIGHT:
                isColInc = true;
                isRowDec = true;
                break;
            case DIAG_UP_LEFT:
                isColDec = true;
                isRowDec = true;
                break;
            case DIAG_DOWN_RIGHT:
                isColInc = true;
                isRowInc = true;
                break;
            case DIAG_DOWN_LEFT:
                isColDec = true;
                isRowInc = true;
                break;






        }
    }

    public static int countLeft(int row, int col, Piece curType){
        int counter = 0;
        int i = col-1;
        while (i >= 0){
            if (Gui.getSuperPanelFromLst(row, i).getType() == curType) {
                counter++;
                i--;
            }
            else break;
        } return counter;
    }

    public static int countRight(int row, int col, Piece curType){
        int counter = 0;
        int i = col+1;
        while (i <= Gui.getColsAmount()){
            if (Gui.getSuperPanelFromLst(row, i).getType() == curType) {
                counter++;
                i++;
            }
            else break;
        } return counter;
    }

    public static int countUp(int row, int col, Piece curType){
        int counter = 0;
        int i = row-1;
        while (i >= 0){
            if (Gui.getSuperPanelFromLst(i, col).getType() == curType) {
                counter++;
                i--;
            }
            else break;
        } return counter;
    }

    public static int countDown(int row, int col, Piece curType){
        int counter = 0;
        int i = row+1;
        while (i <= Gui.getRowsAmount()){
            if (Gui.getSuperPanelFromLst(i, col).getType() == curType) {
                counter++;
                i++;
            }
            else break;
        } return counter;
    }
}
