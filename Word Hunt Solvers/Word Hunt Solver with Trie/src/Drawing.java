import javax.swing.*;
import java.awt.*;
import java.util.List;
import javax.swing.JComponent;
public class Drawing extends JComponent {
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private boolean test = false;
    private String[][] in;
    private List<Location> paths;
    public Drawing(int x1,int y1,int x2,int y2){
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
    }
    public Drawing(int x1, int y1,String t){
        this.x1 = x1;
        this.y1 = y1;
        test=true;
    }
    public Drawing(String[][] inp,List<Location> paths){
        in=inp;
        this.paths =paths;
    }
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        for(int i = 0; i < 4;i++){
            for(int j = 0; j <4; j++){
                g2.drawString(in[i][j],(j*100)+50,(i*100)+50);
            }
        }
        //g2.drawOval((paths.get(0).getCol()*100)+50,(paths.get(0).getRow()*100)+50,20,20);
        g2.setColor(Color.red);
        g2.fillOval((paths.get(0).getCol()*100)+50,(paths.get(0).getRow()*100)+50,20,20);
        g2.setColor(Color.black);
        for(int i = 0; i <paths.size()-1; i++){
            g2.drawLine((paths.get(i).getCol()*100)+50,(paths.get(i).getRow()*100)+50,(paths.get(i+1).getCol()*100)+50,(paths.get(i+1).getRow()*100)+50);
        }
    }
}
