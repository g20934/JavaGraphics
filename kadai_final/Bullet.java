package kadai_final;
import java.awt.Graphics;
import java.awt.Color;

public class Bullet extends GameItem{
  int xpos, ypos;

  public void moveTo(int x, int y){//x,yはドラッグ後の位置
    this.xpos = x;
    this.ypos = y - 10;
    if(ypos < 0) ypos = y - 50;
  }

  public void draw(Graphics g){
    this.moveTo(this.xpos, this.ypos);
    g.setColor(Color.WHITE);
    g.fillRect(this.xpos ,this.ypos, 15, 15);
  }
}
