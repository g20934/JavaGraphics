package kadai_final;
import javax.swing.JFrame;

public class Main{
  public static void main(String[] args){
    JFrame app = new JFrame();
    app.add(new GamePanel());
    app.setSize(500,600);
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    app.setVisible(true);
  }
}
