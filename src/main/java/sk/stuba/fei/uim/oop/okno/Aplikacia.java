package sk.stuba.fei.uim.oop.okno;

import sk.stuba.fei.uim.oop.kontrola.LogikaHry;

import javax.swing.*;
import java.awt.*;

public class Aplikacia {
    public Aplikacia(){
        JFrame okno = new JFrame();
        okno.setFocusable(false);
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setSize(new Dimension(800,800));
        okno.setResizable(false);

        LogikaHry logika = new LogikaHry(okno);

        JButton strom = new JButton("Strom");
        strom.setFocusable(false);
        strom.addActionListener(logika);

        JButton dom = new JButton("Dom");
        dom.setFocusable(false);
        dom.addActionListener(logika);

        JButton cesta = new JButton("Cesta");
        cesta.setFocusable(false);
        cesta.addActionListener(logika);

        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(2,2));
        menu.add(strom);
        menu.add(dom);
        menu.add(cesta);
        menu.add(logika.getStavInformacie());

        okno.add(menu, BorderLayout.PAGE_START);
        okno.setVisible(true);
    }
}
