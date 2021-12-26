package kadai_final;
import java.util.Random;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class UFO extends GameItem{
  Random rnd = new Random();
  int a, b, c, d, xlimitMax, xlimitMin, ylimitMax, ylimitMin;
  public UFO(){
    this.setNumber();
  }

  public void setNumber(){
    a = rnd.nextInt(400);
    b = rnd.nextInt(255);
    c = rnd.nextInt(180);
    d = rnd.nextInt(180);
    if((a > 250 && b < 100)||a<50||b<60){
      setNumber();
    }else if(c < 100 || d < 100){
      setNumber();
    }
  }

  public void setColor(Graphics g, Color c){
    g.setColor(c);
  }

  public void drawCircle(Graphics g, int x, int y, int w, int h){
    g.fillOval(x, y, w, h);
  }

  public void drawhalf(Graphics g, int x, int y, int w, int h, int st, int ar){
    g.fillArc(x, y, w, h, st, ar);
  }

  public void drawTriangle(Graphics g, int n) {
     int xpoints[] = {a+30,a+26,a+33};
     int ypoints[] = {b-27,b+2,b+2};
     g.fillPolygon(xpoints, ypoints,n);
  }

  public void draw(Graphics g){
    //int a =200;
    //int b =100;
    xlimitMin = a - 50;
    xlimitMax = a + 50;
    ylimitMin = b - 50;
    ylimitMax = b + 50;

    setColor(g,new Color(192,192,192));
    drawTriangle(g,3);//アンテナの軸

    setColor(g,new Color(255,215,0));
    drawhalf(g,a+17,b+27,25,25,180,180);//ライト部分 真ん中

    setColor(g,new Color(255,215,0));
    drawhalf(g,a+40,b+22,25,25,180,190);//ライト部分　右

    setColor(g,new Color(255,215,0));
    drawhalf(g,a-6,b+22,25,25,170,180);//ライト部分　左

    setColor(g,new Color(b,c,d));
    drawCircle(g,a-12,b+17,84,27);//円盤の部分

    setColor(g,new Color(d, b, c));
    drawhalf(g,a, b,60,60,0,180);//胴体の部分

    setColor(g,new Color(d, b, c));
    drawCircle(g, a, b+20, 60, 15);//胴体の下の丸み部分

    setColor(g,new Color(255,255,0));
    drawCircle(g,a+24,b-26,12,12);//アンテナの先端

  }
}
