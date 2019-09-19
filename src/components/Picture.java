package components;
import javax.swing.*;

import java.awt.*;

@SuppressWarnings("serial")
public class Picture extends JComponent {
  ImageIcon image;
  
  public Picture (String imageFile){
    super ();
    image = new ImageIcon (imageFile);
    this.setPreferredSize (new Dimension (500,500));
  }
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Image pic = image.getImage();
    g.drawImage (pic,0,0,null);
  }

}