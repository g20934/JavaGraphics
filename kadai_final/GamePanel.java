package kadai_final;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;



public class GamePanel extends JPanel{
  final int MAX = 100;
  GameItem itemTable[] = new GameItem[MAX];//GameItemを入れる事ができる配列を作る（インスタンスを作った訳ではない）
  int numItem = 0;
  GameCharacter movingCharacter = null;
  Score s = new Score();
  HP h = new HP();
  Bullet b;
  UFO uTable[] = new UFO[10];
  UFO u;
  Rocket r;

  public GamePanel(){
    //UFOを作る
    for(int i = 0; i < uTable.length; i++){
      u = new UFO();
      this.addItem(u);
      uTable[i] = u;
    }

    //弾を作る
    b = new Bullet();
    this.addItem(b);

    //ロケットを作る
    r = new Rocket(200, 470);
    this.addItem(r);
    this.setMovingCharacter(r);

    //ロケットをドラッグした時のロケットと弾の動き
    setOpaque(false);
    addMouseMotionListener(new MouseMotionAdapter(){
      int x, y;
      public void mouseDragged(MouseEvent evt){
        x = evt.getX();
        y = evt.getY();
        if(x > 450|| y > 540|| x < 50|| y < 50){return;}
        else if(evt.isShiftDown()){
          //シフトキーが押されると弾が発射する
          movingCharacter.moveTo(x, y);
          b.moveTo(x, y);
          h.hp -= 2;
          repaint();
        }else{
          movingCharacter.moveTo(x, y);
          repaint();
        }
      }
    });
  }

  public void setBackground(Graphics g, Color col){
    g.setColor(col);
    g.fillRect(0, 0, 500, 600);
    g.setColor(Color.YELLOW);//星
    for(int i = -10; i <= 500; i += 10){
      for(int j = 0; j <= 600; j += 10){
      g.drawOval(i + 10, j, 1,1);
      }
    }
    s.draw(g);
    h.draw(g);
  }

  private void addItem(GameItem gi){
      itemTable[numItem] = gi;
      numItem++;

  }

  public void setMovingCharacter(GameCharacter c){
    movingCharacter = c;
  }

  public boolean uTableAllNullCheck(){
    int check = 0;
    for(int i = 0; i < uTable.length; i++){
      if(uTable[i] == null){
        check++;
      }
    }
    if(check == uTable.length)return true;
    else return false;
  }

  public void paintComponent(Graphics g){
    this.setBackground(g, new Color(37, 42, 53));

    for(int i = 0; i < uTable.length; i++){
      if(uTable[i] == null){
      }
      else if((b.xpos > uTable[i].xlimitMin && b.xpos < uTable[i].xlimitMax)&&(b.ypos > uTable[i].ylimitMin && b.ypos < uTable[i].ylimitMax)&& s.score <= 100){
        uTable[i] = null;
        s.score += 10;
      }else{
        itemTable[i].draw(g);
      }
    }

    for(int i = uTable.length; i < numItem; i++){
      itemTable[i].draw(g);
    }

    if(h.hp < 0){
      g.setColor(Color.YELLOW);
      g.setFont(new Font("Impact", Font.ITALIC, 50));
      g.drawString("Game Over", 100, 250);
    }else if(uTableAllNullCheck()){
      g.setColor(Color.YELLOW);
      g.setFont(new Font("Impact", Font.ITALIC, 50));
      g.drawString("Game Clear", 100, 250);
    }
  }
}
