package kadai_final;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

public class Score extends SkillDraw{
  int score = 0;

  public void draw(Graphics g){
    super.draw(g, 380, 20, 20, "SCORE", score, Color.RED);
  }
}
