import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ClearButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        GuiUtils.restartAllPiecePanels();
    }
}