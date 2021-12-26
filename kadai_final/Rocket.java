package kadai_final;
import java.awt.Graphics;
import javax.imageio.*;
import java.io.*;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;


public class Rocket extends GameCharacter{

  public Rocket(int x, int y){
    try{
      super.img = ImageIO.read(new File("kadai_final/rocket.png"));
    }catch(Exception ex){}
      super.xpos = x;
      super.ypos = y;
      super.width = super.img.getWidth();
      super.height = super.img.getHeight();
  }
}
