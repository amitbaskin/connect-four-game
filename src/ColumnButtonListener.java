import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ColumnButtonListener implements ActionListener {
    private static final String FULL_COLUMN_MSG = "This column is full!";
    private final int col;

    public ColumnButtonListener(int column){ this.col = column; }
    int getCol() { return col; }

    @Override
    public void actionPerformed(ActionEvent e) {
        int curRow = Gui.getNextRowOfColLst()[getCol()];
        if (curRow == -1) {
            JOptionPane.showMessageDialog(Gui.getFrame(), FULL_COLUMN_MSG);
            return;
        }
        GuiUtils.updatePanel(curRow, getCol());
        Gui.getFrame().repaint();
        if(DetermineWin.isWin(Gui.getNextRowOfColFromLst(getCol()), getCol(), Gui.getCurPiece())){
            GuiUtils.restartAllSuperPanels();
            switch(Gui.getCurPiece()){
                case RED:
                    GuiUtils.incrementRedScoreLabelText();
                    break;
                case BLUE:
                    GuiUtils.incrementBlueScoreLabelText();
            }
        }
        else {
            GuiUtils.updatePiece();
            Gui.decrementNextRowAtCol(getCol());
        }
    }
}
