
import javax.swing.*;
import java.awt.*;


public abstract class Gui {
    public static final int FRAME_SIZE = 1000;
    public static final int ROWS_AMOUNT = 6;
    public static final int COLS_AMOUNT = 7;

    public static JFrame frame = new JFrame("Connect Four");
    public static SuperPanel[][] superPanelLst = new SuperPanel[6][7];
    public static Piece curPiece = Piece.RED;
    public static JButton[] btnLst = new JButton[7];
    public static int[] nextRowOfColLst = new int[COLS_AMOUNT];
    public static JButton clearButton = new JButton("Clear");

    public static void initializeFrame() {
        getFrame().setLayout(new GridLayout(ROWS_AMOUNT + 2, COLS_AMOUNT));

        GuiUtils.initializeColumns();
        GuiUtils.initializeSuperPanelLst();
        GuiUtils.initializeButtons();
        GuiUtils.initializeClearButton();

        getFrame().setSize(FRAME_SIZE, FRAME_SIZE);
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().setVisible(true);
    }

    public static int getColsAmount() { return COLS_AMOUNT; }
    public static int getRowsAmount() { return ROWS_AMOUNT; }
    public static JFrame getFrame() { return frame; }
    public static SuperPanel[][] getSuperPanelLst() { return superPanelLst; }
    public static Piece getCurPiece() { return curPiece; }
    public static int[] getNextRowOfColLst() { return nextRowOfColLst; }
    public static JButton[] getBtnLst() { return btnLst; }
    public static JButton getClearButton() { return clearButton; }

    public static SuperPanel getSuperPanelFromLst(int row, int col){ return superPanelLst[row][col]; }
    public static JButton getBtnFromLst(int i){ return btnLst[i]; }
    public static void setCurPiece(Piece piece){ curPiece = piece; }
    public static void decrementNextRowAtCol(int col){ nextRowOfColLst[col] -= 1; }
    public static void addComponent(JComponent component){ frame.add(component); }
    public static void repaint(){ frame.repaint(); }
}