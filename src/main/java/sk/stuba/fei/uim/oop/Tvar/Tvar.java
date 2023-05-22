package sk.stuba.fei.uim.oop.Tvar;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

public abstract class Tvar extends JPanel {
    @Setter @Getter
    protected int x1;
    protected int x2;
    @Setter @Getter
    protected int y1;
    protected int y2;
    @Setter
    protected Color farba;
    @Setter
    protected boolean priehladne;
    public Tvar(int x1, int y1, Color farba){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x1;
        this.y2 = y1;
        this.farba = farba;
        setOpaque(true);
    }

    public void nastavDruhyBod(int x2, int y2){
        this.x2 = x2;
        this.y2 = y2;
    }

    protected void nastavFarbu(Graphics2D g2d){
        g2d.setColor(farba);
    }

    public void priehladonost(Graphics2D g2d){
        if(priehladne){
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)0.5));
        }
    }

    public void nakresli(Graphics g){};
}
