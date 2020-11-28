import javax.swing.*;
import java.awt.*;


enum Piece {GRAY, RED, BLUE}

class SuperPanel extends JPanel{
    int PIECE_SIZE = 90;
    Piece type;

    SuperPanel(Piece type){
        this.type = type;
    }

    void setType(Piece type) {
        this.type = type;
    }

    Piece getType() { return type; }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch(type){
            case GRAY:
                g.setColor(Color.GRAY);
                g.fillOval(0, 0, PIECE_SIZE, PIECE_SIZE);
                break;
            case RED:
                g.setColor(Color.RED);
                g.fillOval(0, 0, PIECE_SIZE, PIECE_SIZE);
                break;
            case BLUE:
                g.setColor(Color.BLUE);
                g.fillOval(0, 0, PIECE_SIZE, PIECE_SIZE);
                break;
        }
    }
}