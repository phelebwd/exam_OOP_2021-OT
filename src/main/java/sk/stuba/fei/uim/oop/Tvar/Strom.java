package sk.stuba.fei.uim.oop.Tvar;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;

public class Strom extends Tvar {

    public Strom(int x1, int y1, Color farba) {
        super(x1, y1, farba);
    }

    @Override
    public void nakresli(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        nastavFarbu(g2d);
        priehladonost(g2d);
        g2d.fillOval(x1-25,y1-25,50,33);
        g2d.setStroke(new BasicStroke(17));
        g2d.drawLine(x1,y1+15,x1,y1+15);
    }
    public Shape tvar(){
        Path2D tvar = new Path2D.Double();
        Ellipse2D elipsa = new Ellipse2D.Double(x1-25,y1-25,50,33);
        Line2D usecka = new Line2D.Double(x1,y1+15,x1,y1+15);
        Stroke hrubkaUsecky = new BasicStroke(17);
        tvar.append(hrubkaUsecky.createStrokedShape(usecka), false);
        tvar.append(elipsa,false);
        return tvar;
    }
}
