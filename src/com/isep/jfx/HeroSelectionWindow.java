package com.isep.jfx;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class HeroSelectionWindow extends JFrame {
    public HeroSelectionWindow() {
        this.setTitle("Choix des héros");
        this.setSize(500, 500);
        JPanel panel = new JPanel();
        JTextField heroesNumberField = new JTextField(5);
        panel.add(new JLabel("Veuillez indiquer le nombre de héros souhaité, choisissez entre 1 et 5 héros :"));
        panel.add(heroesNumberField);
        JTextField heroNameField = new JTextField(20);
        panel.add(new JLabel("Quel nom souhaitez vous donner à votre héro :"));
        panel.add(heroNameField);
        this.add(panel);
    }
}