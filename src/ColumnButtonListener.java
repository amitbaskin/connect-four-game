import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColumnButtonListener implements ActionListener {
    int col;

    public ColumnButtonListener(int column){ this.col = column; }

    @Override
    public void actionPerformed(ActionEvent e) {
        int curRow = Gui.getNextRowOfColLst()[getCol()];
        if (curRow == -1) return;
        GuiUtils.updatePanel(curRow, getCol());
        GuiUtils.updatePiece();
        Gui.getFrame().repaint();
        Gui.decrementNextRowAtCol(getCol());
    }

    public int getCol() { return col; }
}
