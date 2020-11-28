import javax.swing.*;
import java.awt.*;

public abstract class Gui {
    private static final int FRAME_SIZE = 1000;
    private static final int ROWS_AMOUNT = 6;
    private static final int COLS_AMOUNT = 7;
    private static final int AMOUNT_TO_WIN = 4;

    private static final JFrame frame = new JFrame("Connect Four");
    private static final PiecePanel[][] piecePanelLst = new PiecePanel[6][7];
    private static Piece curPiece = Piece.RED;
    private static final JButton[] btnLst = new JButton[7];
    private static final int[] nextRowOfColLst = new int[COLS_AMOUNT];
    private static final JButton clearBtn = new JButton("Clear");
    private static final JButton resetScoreBtn = new JButton("Reset Score");
    private static int redScore = 0;
    private static int blueScore = 0;
    private static final JLabel redScoreLabel = new JLabel("RED score: 0");
    private static final JLabel blueScoreLabel = new JLabel("BLUE score: 0");

    static void initializeFrame() {
        getFrame().setLayout(new GridLayout(ROWS_AMOUNT + 2, COLS_AMOUNT));

        GuiUtils.initializeColumns();
        GuiUtils.initializePiecePanelLst();
        GuiUtils.initializeButtons();
        GuiUtils.initializeClearButton();
        GuiUtils.initializeScores();

        getFrame().setSize(FRAME_SIZE, FRAME_SIZE);
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().setVisible(true);
    }

    static int getAmountToWin() { return AMOUNT_TO_WIN; }
    static int getColsAmount() { return COLS_AMOUNT; }
    static int getRowsAmount() { return ROWS_AMOUNT; }
    static JFrame getFrame() { return frame; }
    static PiecePanel[][] getPiecePanelLst() { return piecePanelLst; }
    static Piece getCurPiece() { return curPiece; }
    static int[] getNextRowOfColLst() { return nextRowOfColLst; }
    static JButton[] getBtnLst() { return btnLst; }
    static JButton getClearBtn() { return clearBtn; }
    static JButton getResetScoreBtn() { return resetScoreBtn; }
    static int getRedScore() { return redScore; }
    static int getBlueScore() { return blueScore; }
    static JLabel getRedScoreLabel(){ return redScoreLabel; }
    static JLabel getBlueScoreLabel(){ return blueScoreLabel; }
    static void resetRedScore() { redScore = 0; }
    static void resetBlueScore() { blueScore = 0; }

    static void incrementRedScore(){ redScore += 1; }
    static void incrementBlueScore(){ blueScore += 1; }
    static int getNextRowOfColFromLst(int col){ return nextRowOfColLst[col]; }
    static PiecePanel getPiecePanelFromLst(int row, int col){ return piecePanelLst[row][col]; }
    static JButton getBtnFromLst(int i){ return btnLst[i]; }
    static void setCurPiece(Piece piece){ curPiece = piece; }
    static void decrementNextRowAtCol(int col){ nextRowOfColLst[col] -= 1; }
    static void addComponent(JComponent component){ frame.add(component); }
    static void repaint(){ frame.repaint(); }
}