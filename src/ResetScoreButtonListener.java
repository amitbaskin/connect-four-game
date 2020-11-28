import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ResetScoreButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        GuiUtils.resetScoresLabels();
        Gui.repaint();
    }
}