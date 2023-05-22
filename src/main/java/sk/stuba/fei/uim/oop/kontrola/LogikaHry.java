package sk.stuba.fei.uim.oop.kontrola;

import lombok.Getter;
import sk.stuba.fei.uim.oop.Tvar.Dom;
import sk.stuba.fei.uim.oop.Tvar.Strom;
import sk.stuba.fei.uim.oop.Tvar.Tvar;
import sk.stuba.fei.uim.oop.Tvar.Usecka;
import sk.stuba.fei.uim.oop.doska.Doska;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class LogikaHry extends UniverzalnyAdapter {
    private JFrame okno;
    private final String DOM = "Dom";
    private final String STROM = "Strom";
    private final String CESTA = "Cesta";
    @Getter
    private JLabel stavInformacie;
    private String stav;
    private Doska doska;
    private Color farba;
    private Dom priehladnyDom;
    private Strom priehladnyStrom;
    private Usecka usecka;

    private Tvar tvar1;
    public LogikaHry(JFrame okno){
        stav = DOM;
        this.okno = okno;
        this.farba = Color.RED;
        priehladnyDom = priehladnyDom();
        priehladnyStrom = priehladnyStrom();
        stavInformacie = new JLabel("     Dom");
        stavInformacie.setOpaque(true);
        stavInformacie.setBackground(farba);
        this.doska = new Doska();
        doska.addMouseMotionListener(this);
        doska.addMouseListener(this);
        this.okno.add(doska);
    }

    private Dom priehladnyDom(){
        Dom dom = new Dom(0,0,farba);
        dom.setPriehladne(true);
        return dom;
    }

    private Strom priehladnyStrom(){
        Strom strom = new Strom(0,0,farba);
        strom.setPriehladne(true);
        return strom;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (stav) {
            case DOM: {
                Dom tvar = new Dom(e.getX(), e.getY(), farba);
                tvar.addMouseListener(this);
                tvar.addMouseMotionListener(this);
                this.doska.pridajTvar(tvar);
                zmenaFarby();
                break;
            }
            case STROM: {
                Strom tvar = new Strom(e.getX(), e.getY(), farba);
                tvar.addMouseListener(this);
                tvar.addMouseMotionListener(this);
                this.doska.pridajTvar(tvar);
                zmenaFarby();
                break;
            }
            case CESTA: {
                for(int i=this.doska.getTvary().size()-1; i>=0; i--){
                    if(this.doska.getTvary().get(i) instanceof Dom){
                        if(((Dom) this.doska.getTvary().get(i)).tvar().contains(e.getX(),e.getY())){
                            tvar1 = this.doska.getTvary().get(i);
                            Usecka usecka = new Usecka(tvar1.getX1(), tvar1.getY1(), farba);
                            this.doska.pridajUsecku(usecka);
                            this.usecka = usecka;
                        }
                    }
                    if(this.doska.getTvary().get(i) instanceof Strom){
                        if(((Strom) this.doska.getTvary().get(i)).tvar().contains(e.getX(),e.getY())){
                            tvar1 = this.doska.getTvary().get(i);
                            Usecka usecka = new Usecka(tvar1.getX1(), tvar1.getY1(), farba);
                            this.doska.pridajUsecku(usecka);
                            this.usecka = usecka;
                        }
                    }
                }
                break;
            }
        }
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(usecka != null && stav.equals(CESTA)){
            for(int i=this.doska.getTvary().size()-1; i>=0; i--){
                if(this.doska.getTvary().get(i) instanceof Dom && tvar1 instanceof Strom){
                    if(((Dom) this.doska.getTvary().get(i)).tvar().contains(e.getX(),e.getY())){
                        Usecka usecka = new Usecka(tvar1.getX1(),tvar1.getY1(),Color.black);
                        usecka.nastavDruhyBod(this.doska.getTvary().get(i).getX1(),this.doska.getTvary().get(i).getY1());
                        this.doska.pridajTvar(usecka);
                    }
                }
                if(this.doska.getTvary().get(i) instanceof Strom && tvar1 instanceof Dom){
                    if(((Strom) this.doska.getTvary().get(i)).tvar().contains(e.getX(),e.getY())){
                        Usecka usecka = new Usecka(tvar1.getX1(),tvar1.getY1(),Color.black);
                        usecka.nastavDruhyBod(this.doska.getTvary().get(i).getX1(),this.doska.getTvary().get(i).getY1());
                        this.doska.pridajTvar(usecka);
                    }
                }
            }
        }
        this.doska.zmazUsecku();
        this.doska.repaint();
    }


    @Override
    public void mouseExited(MouseEvent e) {
        this.doska.znazPriehladyTvar();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(this.usecka != null){
            this.usecka.nastavDruhyBod(e.getX(),e.getY());
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(stav.equals(DOM)){
            priehladnyDom.setX1(e.getX());
            priehladnyDom.setY1(e.getY());
            priehladnyDom.setFarba(farba);
            this.doska.pridajPriehladyTvar(priehladnyDom);
        }
        if(stav.equals(STROM)){
            priehladnyStrom.setX1(e.getX());
            priehladnyStrom.setY1(e.getY());
            priehladnyStrom.setFarba(farba);
            this.doska.pridajPriehladyTvar(priehladnyStrom);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case DOM:
                stav = DOM;
                stavInformacie.setText("     Dom");
                break;
            case STROM:
                stav = STROM;
                stavInformacie.setText("     Strom");
                break;
            case CESTA:
                stav = CESTA;
                stavInformacie.setText("     Cesta");
                break;
        }
    }

    private void zmenaFarby(){
        if (this.farba == Color.RED){
            this.farba = Color.BLUE;
        }
        else if (this.farba == Color.BLUE){
            this.farba = Color.GREEN;
        }
        else if (this.farba == Color.GREEN){
            this.farba = Color.RED;
        }
        stavInformacie.setBackground(farba);
    }
}
