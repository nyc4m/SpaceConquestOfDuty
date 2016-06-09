/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HUD;

import iut.Game;
import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author Baptiste
 */
public class HUD {

    private ArrayList<VieIcone> vie = new ArrayList();
    private ArrayList<MissileIcone> missile = new ArrayList();
    private int x;
    private int y;
    private int score = 0;
    private Game g;

    public HUD(Game g, int nbVie, int nbMissiles, int x, int y) {
        for (int i = 0; i < 3; i++) {
            this.vie.add(new VieIcone());
            this.missile.add(new MissileIcone());
        }
        this.x = x;
        this.y = y;
        this.g = g;
    }
    
    
    public void enleverVie(){
        this.vie.remove(this.vie.size()-1); //on enlève le dernier élément de la liste
    }
    
    public void ajouterVie(){
        this.vie.add(new VieIcone());
    }
    
    public void enleverMissile(){
        this.missile.remove(this.missile.size()-1);
    }
    
    public void ajouterMissile(){
        this.missile.add(new MissileIcone());
    }
    
    public void afficher(){
        for(int i = 0; i < this.vie.size(); i++){
            this.vie.get(i).draw(g.getGraphics(), x+2*i, y); //On espace chaque element de ix2
        }
        
        for(int i = 0; i < this.missile.size(); i++){
            this.missile.get(i).draw(g.getGraphics(), x+2*i, y+6); //On decale d'une ligne
        }
    }
}
