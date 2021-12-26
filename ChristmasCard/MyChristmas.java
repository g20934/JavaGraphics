//プレゼントを運ぶサンタ

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.Font;
import javax.swing.JTextField;

public class MyChristmas{
  static class MyPanel extends JPanel{
    public void setColor(Graphics g, Color c){//色指定
      g.setColor(c);
    }

    public void setStroke(Graphics g, int n){//線幅の変更
      Graphics2D g2 =(Graphics2D)g;
      BasicStroke bs = new BasicStroke(n);
      g2.setStroke(bs);
    }

    public void drawLine(Graphics g, int n, int x1, int y1, int x2, int y2) {//線を書く
      this.setStroke(g, n);
      g.drawLine(x1, y1, x2, y2);
    }

    public void fillPolygon(Graphics g, int[] xArray, int[] yArray, int nPoints){//多角形を書く
      int xPoint[] = xArray;
      int yPoint[] = yArray;
      g.fillPolygon(xPoint, yPoint, nPoints);
    }

    public void turnOval(Graphics g, int n, int centralX, int centralY, int x, int y, int w, int h){//回転した楕円を書く
      Graphics2D g2 =(Graphics2D)g;
      AffineTransform at = new AffineTransform();
      at.setToRotation(n*Math.PI/180.0f, centralX, centralY);
      g2.setTransform(at);
      Ellipse2D ellipse = new Ellipse2D.Double(x, y, w, h);
      g2.fill(ellipse);
    }

    public void makeSanta(Graphics g){
      //サンタを作る
      //足1
      this.setColor(g, Color.BLACK);
      g.fillOval(285, 470, 40, 20);
      this.setColor(g, Color.GRAY);
      this.setStroke(g, 2);
      g.drawOval(285, 470, 40, 20);

      //腕1
      this.setColor(g, new Color(230, 0, 51));
      g.fillOval(260, 340, 100, 30);
      this.setColor(g, Color.GRAY);
      this.setStroke(g, 2);
      g.drawOval(260, 340, 100, 30);

      //手1
      this.setColor(g, Color.BLACK);
      g.fillOval(225, 340, 40, 30);
      this.setColor(g, Color.GRAY);
      g.drawOval(225, 340, 40, 30);

      //胴体
      this.setColor(g, new Color(230, 0, 51));
      g.fillOval(270, 330, 120, 150);

      //足2
      this.setColor(g, Color.BLACK);
      g.fillOval(305, 475, 40, 20);

      this.setColor(g, Color.GRAY);
      this.setStroke(g, 2);
      g.drawOval(305, 475, 40, 20);

      //腕2
      this.setColor(g, new Color(230, 0, 51));
      g.fillOval(240, 355, 120, 40);
      this.setColor(g, Color.GRAY);
      this.setStroke(g, 2);
      g.drawOval(240, 355, 120, 40);

      //手2
      this.setColor(g, Color.BLACK);
      g.fillOval(220, 360, 40, 30);
      this.setColor(g, Color.GRAY);
      g.drawOval(220, 360, 40, 30);

      //ベルト
      this.setColor(g, Color.BLACK);
      this.drawLine(g, 20, 280, 405, 380, 405);
      //this.setColor(g, new Color(245, 229, 107));
      //this.drawLine(g, 20, 280, 405, 300,405);

      //顔
      this.setColor(g, new Color(252, 213, 197));
      g.fillOval(280, 270, 90, 90);

      //ヒゲ
      this.setColor(g, Color.WHITE);
      g.fillOval(275, 320, 15, 20);
      g.fillOval(283, 325, 30, 30);
      g.fillOval(300, 325, 45, 30);
      g.fillOval(330, 325, 40, 25);
      g.fillOval(290, 340, 30, 30);
      g.fillOval(330, 338, 30, 20);
      g.fillOval(305, 351, 40, 15);

      //鼻
      this.setColor(g, new Color(252, 213, 197));
      g.fillOval(275, 305, 20, 20);

      //目
      this.setColor(g, Color.BLACK);
      g.fillOval(315, 300, 10, 10);
    }

    public void makePresent(Graphics g){
      //プレゼントを作る
      this.setColor(g, new Color(46, 139, 87));
      int[] x1={120, 250, 240, 160};
      int[] y1={270, 250, 360, 380};
      this.fillPolygon(g, x1, y1, 4);

      this.setColor(g, new Color(230, 0, 51));
      this.drawLine(g, 20, 185, 268, 200, 363);//縦のライン
      this.drawLine(g, 20, 148, 325, 237, 309);//横のライン

      //リボンを作る
      int[] x2={185, 220, 230};
      int[] y2={260, 225, 250};
      this.fillPolygon(g, x2, y2, 3);//左側リボン

      int[] x3={180, 135, 128};
      int[] y3={260, 240, 265};
      this.fillPolygon(g, x3, y3, 3);//右側リボン
    }

    public void makeHat(Graphics g){
      //サンタの帽子を作る
      int[] x4={325, 370, 420};
      int[] y4={265, 310, 250};
      this.fillPolygon(g, x4, y4, 3);//右側リボン
      this.setColor(g, Color.WHITE);
      this.turnOval(g, 135, 350, 300, 335, 270, 20, 80);
    }

    public void setBackground(Graphics g){
      //背景色の設定&塗りつぶし
      this.setColor(g, new Color(255, 204, 102));
      g.fillRect(0, 0, 430, 510);
    }

    public void decoration(Graphics g){
      //画面上部のデコレーション
      int x = 40;
      int y = 0;
      for(int i = 0; i<5; i++){
        y = 0;
        for(int j = 0; j<6; j++){
          this.setColor(g, Color.WHITE);
          g.fillOval(x, y, 5, 5);
          y+=10;
        }
        this.setColor(g, new Color(220, 20, 60));
        g.fillOval(x-10, 40, 30, 30);
        x+=85;
      }
    }

    public void message(Graphics g){
      //「Merry Christmas」の表示
      this.setColor(g, Color.WHITE);
      g.setFont(new Font("Impact", Font.ITALIC, 50));
      g.drawString("MERRY CHRISTMAS", 23, 170);

      this.setColor(g, new Color(25, 25, 112));
      g.drawString("MERRY CHRISTMAS", 26, 170);
    }

    public void paintComponent(Graphics g){
      //背景色の設定&塗りつぶし
      this.setBackground(g);

      //上の方をデコレーションする
      this.decoration(g);

      //「Merry Christmas」の表示
      this.message(g);

      //サンタを作る
      this.makeSanta(g);

      //プレゼントを作る
      this.makePresent(g);

      //帽子
      this.makeHat(g);

    }
  }

  public static void main(String[] args){
    JFrame app = new JFrame();
    app.add(new MyPanel());
    app.setSize(450, 550);
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    app.setVisible(true);
  }
}
