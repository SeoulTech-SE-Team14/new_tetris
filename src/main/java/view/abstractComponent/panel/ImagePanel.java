package view.abstractComponent.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
    
    private BufferedImage image;

    public ImagePanel(String pathname) {
        try {
            image = ImageIO.read(new File(pathname));
        } catch (Exception e) {
            System.out.println(e);
        }

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
        setPreferredSize(new Dimension());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
