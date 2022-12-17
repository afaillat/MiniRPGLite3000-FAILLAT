package com.isep.jfx;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GameController extends JFrame {
    public GameController() {
        this.setTitle(" Bienvenue dans Mini RPG Lite 3000");
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());
        JButton startGameButton = new JButton("Lancer le jeu");
        this.add(startGameButton, "Center");
        startGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameController.this.setVisible(false);
                GameController.this.dispose();
                (new HeroSelectionWindow()).setVisible(true);
            }
        });
        startGameButton.setPreferredSize(new Dimension(100, 100));
        startGameButton.setMaximumSize(new Dimension(100, 100));
        startGameButton.addActionListener(e -> (new HeroSelectionWindow()).setVisible(true));
    }

    public static void main(String[] args) {
        (new GameController()).setVisible(true);
    }
}
