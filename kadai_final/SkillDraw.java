package kadai_final;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

public class SkillDraw{
  int x, y, r, skill;
  
  public void setStroke(Graphics g, int n){//線幅の変更
    Graphics2D g2 =(Graphics2D)g;
    BasicStroke bs = new BasicStroke(n);
    g2.setStroke(bs);
  }

  public void draw(Graphics g, int x, int y, int r, String skillName, int skill, Color c){
    this.setStroke(g, 7);
    this.x = x;
    this.y = y;
    this.r = r;
    g.setColor(Color.WHITE);
    g.setFont(new Font("Impact", Font.ITALIC, 20));
    if(skillName.equals("SCORE")){
      g.drawString(skillName, x-70, y+20);
    }else{
      g.drawString(skillName, x-50, y+20);
    }
    g.drawLine(x, y, x+100, y);
    g.drawLine(x, y+20 , x+100 , y+20);
    g.drawArc(x-10, y, r, r, -270, 180);
    g.drawArc(x+90, y, r, r, -90, 180);
    g.setColor(c);
    g.fillArc(x-10, y, r, r, -270, 180);
    g.fillRect(x, y, skill, r);

  }
}
