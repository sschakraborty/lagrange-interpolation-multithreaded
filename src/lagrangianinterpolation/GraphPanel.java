/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lagrangianinterpolation;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author sschakraborty
 */
public class GraphPanel extends JPanel {
    private double[] array = {};
    private double max = 1;
    
    public void repaint(double[] x, double max) {
        array = x;
        this.max = max;
        this.repaint();
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        double sx, sy;
        
        // Following two lines are for
        // Translating pixel representation
        // to normal graph representation
        
        g2.translate(0, this.getHeight());
        g2.scale(1, -1);
        g2.setStroke(new BasicStroke(1.5f));
        // Adding the grids
        g2.drawLine(50, 0, 50, this.getHeight());
        g2.drawLine(0, 50, this.getWidth(), 50);
        
        g2.translate(50, 50);
        sx = (this.getWidth()-50) / 100.0;
        sy = (this.getHeight()-50) / max;
        
        g2.setColor(Color.RED);
        int dx = 0, dy = 0, nx, ny;
        for(int x = 0; x < array.length; x++) {
            nx = x;
            ny = (int) array[x];
            g2.drawLine((int) (dx * sx) , (int) (dy * sy),
                    (int) (nx * sx), (int) (ny * sy));
            dx = nx;
            dy = ny;
        }
    }
}
