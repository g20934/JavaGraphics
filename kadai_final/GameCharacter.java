package kadai_final;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class GameCharacter extends GameItem{
  BufferedImage img;
  int xpos, ypos, width, height;

  public void moveTo(int x, int y){//x,yはドラッグ後の位置（画像真ん中）
    this.xpos = x;
    this.ypos = y;
  }
  public void draw(Graphics g){//x、yはロケット左上座標
    int x = xpos - width/2;
    int y = ypos - height/2;
    g.drawImage(img, x, y, null);
  }
}
