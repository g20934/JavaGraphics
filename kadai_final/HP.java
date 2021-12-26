package kadai_final;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

public class HP extends SkillDraw{
  int hp = 100;

  public void draw(Graphics g){
    super.draw(g, 380, 60, 20, "HP", hp, Color.GREEN);
  }
}
