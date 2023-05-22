package sk.stuba.fei.uim.oop.Tvar;

import lombok.Getter;

import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

public class Dom extends Tvar{
    int[] yBody;
    int[] xBody;
    public Dom(int x1, int y1, Color farba) {
        super(x1, y1, farba);
    }
    @Override
    public void nakresli(Graphics g){
        Graphics2D g2d = (Graphics2D) g.create();
        nastavFarbu(g2d);
        priehladonost(g2d);
        yBody = new int[]{y1 - 13, y1, y1};
        xBody = new int[]{x1, x1 - 13, x1 + 13};
        g2d.fillPolygon(xBody, yBody, 3);
        g2d.fillRect(x1-13,y1,26,25);
    }

    public Shape tvar(){
        Path2D tvar = new Path2D.Double();
        Rectangle2D stvorec = new Rectangle2D.Double(x1-13,y1,26,25);
        Polygon trojuholnik = new Polygon(xBody, yBody, 3);
        tvar.append(stvorec,false);
        tvar.append(trojuholnik,false);
        return tvar;
    }
}
