import javax.swing.*;

enum Direction {DOWN, RIGHT, LEFT, UP_RIGHT, UP_LEFT, DOWN_RIGHT, DOWN_LEFT}

public abstract class DetermineWin {
    private static final String WIN_MSG = "%s wins!";
    private static final String NO_WINNER = "";

    static int countCol(int row, int col, Piece type){
        return countPieces(row, col, type, Direction.DOWN);
    }

    static int countRow(int row, int col, Piece type){
        return countPieces(row, col, type, Direction.LEFT) + countPieces(row, col, type, Direction.RIGHT);
    }

    static int countForwardDiag(int row, int col, Piece type){
        return countPieces(row, col, type, Direction.DOWN_LEFT) +
                countPieces(row, col, type, Direction.UP_RIGHT);
    }

    static int countBackwardDiag(int row, int col, Piece type){
        return countPieces(row, col, type, Direction.UP_LEFT) +
                countPieces(row, col, type, Direction.DOWN_RIGHT);
    }

    static String getWinner(int row, int col, Piece type){
        if (countCol(row, col, type) >= Gui.getAmountToWin()-1 ||
                countRow(row, col, type) >= Gui.getAmountToWin()-1 ||
                countForwardDiag(row, col, type) >= Gui.getAmountToWin()-1 ||
                countBackwardDiag(row, col, type) >= Gui.getAmountToWin()-1){
            return type.toString();
        } return NO_WINNER;
    }

    static boolean isWin(int row, int col, Piece type){
        String winner = getWinner(row, col, type);
        if (winner.equals(NO_WINNER)) return false;
        JOptionPane.showMessageDialog(Gui.getFrame(), String.format(WIN_MSG, winner));
        return true;
    }

    static int countPieces(int row, int col, Piece type, Direction direction) {
        int curRow;
        int curCol;
        int counter = 0;

        switch (direction) {

            case DOWN:
                curRow = row + 1;
                while (curRow < Gui.getRowsAmount()) {
                    if (Gui.getPiecePanelFromLst(curRow, col).getType() == type) {
                        counter++;
                        curRow++;
                    } else break;
                } return counter;

            case RIGHT:
                curCol = col + 1;
                while (curCol < Gui.getColsAmount()) {
                    if (Gui.getPiecePanelFromLst(row, curCol).getType() == type) {
                        counter++;
                        curCol++;
                    } else break;
                } return counter;


            case LEFT:
                curCol = col - 1;
                while (curCol >= 0) {
                    if (Gui.getPiecePanelFromLst(row, curCol).getType() == type) {
                        counter++;
                        curCol--;
                    } else break;
                }
                return counter;

            case UP_RIGHT:
                curCol = col + 1;
                curRow = row - 1;
                while (curCol < Gui.getColsAmount() && curRow >= 0) {
                    if (Gui.getPiecePanelFromLst(curRow, curCol).getType() == type) {
                        counter++;
                        curCol++;
                        curRow--;
                    } else break;
                } return counter;

            case UP_LEFT:
                curCol = col - 1;
                curRow = row - 1;
                while (curCol >= 0 && curRow >= 0) {
                    if (Gui.getPiecePanelFromLst(curRow, curCol).getType() == type) {
                        counter++;
                        curCol--;
                        curRow--;
                    } else break;
                } return counter;

            case DOWN_RIGHT:
                curCol = col + 1;
                curRow = row + 1;
                while (curCol < Gui.getColsAmount() && curRow < Gui.getRowsAmount()) {
                    if (Gui.getPiecePanelFromLst(curRow, curCol).getType() == type) {
                        counter++;
                        curCol++;
                        curRow++;
                    } else break;
                } return counter;

            case DOWN_LEFT:
                curCol = col - 1;
                curRow = row + 1;
                while (curCol >= 0 && curRow < Gui.getRowsAmount()) {
                    if (Gui.getPiecePanelFromLst(curRow, curCol).getType() == type) {
                        counter++;
                        curCol--;
                        curRow++;
                    } else break;
                } return counter;

            default: return -1;
        }
    }
}