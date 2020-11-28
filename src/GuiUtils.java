import javax.swing.*;
import java.awt.event.ActionListener;

abstract class GuiUtils {
    private static final String SCORE_MSG = "%s score: %d";

    static void initializeSuperPanelLst() {
        for (int i = 0; i < Gui.getRowsAmount(); i++) {
            for (int j = 0; j < Gui.getColsAmount(); j++) {
                Gui.getSuperPanelLst()[i][j] = new SuperPanel(Piece.GRAY);
                Gui.addComponent(Gui.getSuperPanelFromLst(i, j));
            }
        }
    }

    static void initializeButtons(){
        for (int i = 0; i < 7; i++) {
            setButtonInLst(i);
            addActionListenerToBtnInLst(i);
            Gui.addComponent(Gui.getBtnFromLst(i));
        }
    }

    static void initializeClearButton(){
        Gui.getClearBtn().addActionListener(new ClearButtonListener());
        Gui.addComponent(Gui.getClearBtn());
    }

    static void initializeScores(){
        Gui.getResetScoreBtn().addActionListener(new ResetScoreButtonListener());
        Gui.addComponent(Gui.getResetScoreBtn());
        Gui.addComponent(new JPanel());
        Gui.addComponent(Gui.getRedScoreLabel());
        Gui.addComponent(Gui.getBlueScoreLabel());
    }

    static void initializeColumns(){
        for (int i=0; i<Gui.getColsAmount(); i++) Gui.getNextRowOfColLst()[i] = Gui.getRowsAmount() - 1;
    }

    static void updatePanel(int row, int col){
        Gui.getSuperPanelLst()[row][col].setType(Gui.getCurPiece());
    }

    static void updatePiece(){
        switch (Gui.getCurPiece()) {
            case RED:
                Gui.setCurPiece(Piece.BLUE);
                break;
            case BLUE:
                Gui.setCurPiece(Piece.RED);
                break;
        }
    }

    static void addActionListenerToBtnInLst(int index){
        JButton btn = Gui.getBtnFromLst(index);
        ActionListener listener = new ColumnButtonListener(index);
        btn.addActionListener(listener);
    }

    static void restartAllSuperPanels(){
        for (int i = 0; i < Gui.getRowsAmount(); i++) {
            for (int j = 0; j < Gui.getColsAmount(); j++) {
                GuiUtils.initializeColumns();
                GuiUtils.restartSuperPanelInLst(i, j);
            }
        } Gui.repaint();
    }

    static void restartSuperPanelInLst(int row, int col){
        Gui.getSuperPanelFromLst(row, col).setType(Piece.GRAY);
    }

    static void setButtonInLst(int index){
        JButton btn = new JButton(String.format("%d", index + 1));
        Gui.getBtnLst()[index] = btn;
    }

    static void incrementRedScoreLabelText(){
        Gui.incrementRedScore();
        Gui.getRedScoreLabel().setText(String.format(SCORE_MSG, Piece.RED, Gui.getRedScore()));
        Gui.repaint();
    }

    static void incrementBlueScoreLabelText(){
        Gui.incrementBlueScore();
        Gui.getBlueScoreLabel().setText(String.format(SCORE_MSG, Piece.BLUE, Gui.getBlueScore()));
        Gui.repaint();
    }

    static void resetScores(){
        Gui.resetRedScore();
        Gui.resetBlueScore();
    }

    static void resetScoresLabels(){
        resetScores();
        Gui.getRedScoreLabel().setText(String.format(SCORE_MSG, Piece.RED, 0));
        Gui.getBlueScoreLabel().setText(String.format(SCORE_MSG, Piece.BLUE, 0));
    }
}