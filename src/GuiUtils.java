import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class GuiUtils {

    static void initializeSuperPanelLst() {
        for (int i = 0; i < Gui.getRowsAmount(); i++) {
            for (int j = 0; j < Gui.getColsAmount(); j++) {
                Gui.getSuperPanelLst()[i][j] = new SuperPanel(Piece.GRAY);
                Gui.addComponent(Gui.getSuperPanelFromLst(i, j));
            }
        }
    }

    public static void initializeButtons(){
        for (int i = 0; i < 7; i++) {
            setButtonInLst(i);
            addActionListenerToBtnInLst(i);
            Gui.addComponent(Gui.getBtnFromLst(i));
        }
    }

    public static void initializeClearButton(){
        Gui.getClearButton().addActionListener(new ClearButtonListener());
        Gui.addComponent(Gui.getClearButton());
    }

    static void initializeColumns(){
        for (int i=0; i<Gui.getColsAmount(); i++) Gui.getNextRowOfColLst()[i] = Gui.getRowsAmount() - 1;
    }

    public static void updatePanel(int row, int col){
        Gui.getSuperPanelLst()[row][col].setType(Gui.getCurPiece());
    }

    public static void updatePiece(){
        switch (Gui.getCurPiece()) {
            case RED:
                Gui.setCurPiece(Piece.BLUE);
                break;
            case BLUE:
                Gui.setCurPiece(Piece.RED);
                break;
        }
    }

    public static void addActionListenerToBtnInLst(int index){
        JButton btn = Gui.getBtnFromLst(index);
        ActionListener listener = new ColumnButtonListener(index);
        btn.addActionListener(listener);
    }

    public static void restartSuperPanelInLst(int row, int col){
        Gui.getSuperPanelFromLst(row, col).setType(Piece.GRAY);
    }

    public static void setButtonInLst(int index){
        JButton btn = new JButton(String.format("%d", index + 1));
        Gui.getBtnLst()[index] = btn;
    }
}