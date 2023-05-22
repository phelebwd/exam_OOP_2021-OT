package sk.stuba.fei.uim.oop.Tvar;

import java.awt.*;

public class Usecka extends Tvar{

    public Usecka(int x1, int y1, Color farba) {
        super(x1, y1, farba);
    }

    @Override
    public void nakresli(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.drawLine(x1,y1,x2,y2);
    }
}
