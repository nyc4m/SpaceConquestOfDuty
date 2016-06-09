/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HUD;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Baptiste
 */
public class MissileIcone extends iut.Sprite{
    
    public MissileIcone() throws IOException {
        super(ImageIO.read(new File("Images/missile.png")));
    }
    
}
