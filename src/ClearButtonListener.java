import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < Gui.getRowsAmount(); i++) {
            for (int j = 0; j < Gui.getColsAmount(); j++) {
                GuiUtils.initializeColumns();
                GuiUtils.restartSuperPanelInLst(i, j);
                Gui.repaint();
            }
        }
    }
}
