package sk.stuba.fei.uim.oop.doska;

import lombok.Getter;
import sk.stuba.fei.uim.oop.Tvar.Dom;
import sk.stuba.fei.uim.oop.Tvar.Strom;
import sk.stuba.fei.uim.oop.Tvar.Tvar;
import sk.stuba.fei.uim.oop.Tvar.Usecka;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Doska extends JPanel {
    @Getter
    private ArrayList<Tvar> tvary;
    private Tvar priehladnyTvar;
    private Usecka usecka;
    public Doska(){
        tvary = new ArrayList<>();
        setBackground(Color.WHITE);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(Tvar tvar : tvary){
            if(tvar instanceof Dom){
                tvar.nakresli(g);
            }
            if(tvar instanceof Strom){
                tvar.nakresli(g);
            }
            if(tvar instanceof Usecka){
                tvar.nakresli(g);
            }
        }
        if(priehladnyTvar != null){
            priehladnyTvar.nakresli(g);
        }
        if(usecka != null){
            usecka.nakresli(g);
        }
        this.repaint();
    }

    public void pridajTvar(Tvar tvar){
        tvary.add(tvar);
    }
    public void pridajPriehladyTvar(Tvar tvar){
        priehladnyTvar = tvar;
    }
    public void znazPriehladyTvar(){
        priehladnyTvar = null;
    }
    public void pridajUsecku(Tvar tvar){
        usecka = (Usecka) tvar;
    }
    public void zmazUsecku(){
        usecka = null;
    }

}
