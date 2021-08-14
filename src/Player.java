import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.lang.Object.*;

public class Player {
    private float x, y, dx, dy, a;
    private Rectangle2D rectangle;
    private Map map;

    public Player() {
        this.x =  150;
        this.y = 400;
        this.a = (float) 0;
        this.dx = (float) Math.cos(a) * 5;
        this.dy = (float) Math.sin(a) * 5;
        this.rectangle = new Rectangle2D.Float(x, y, 6, 6);
    }

    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(255,0,0));

        AffineTransform old = g2d.getTransform();
        g2d.rotate(a, x+3, y+3);
        g2d.draw(rectangle);
        g2d.fill(rectangle);
        g2d.setTransform(old);

        g2d.draw(new Line2D.Float(x + 3, y+3, x+dx*5 + 3, y+dy*5 + 3));
    }

    public void forward(){
        int ix = (int) (x+3 + dx) /map.getCaseSize();
        int iy = (int) (y+3 + dy) /map.getCaseSize();
        if(map.getGrid()[ix][iy] != 1){
            x += dx;
            y += dy;
            rectangle = new Rectangle2D.Float(x, y, 6, 6);
        }
    }

    public void backward(){
        x -= dx;
        y -= dy;
        rectangle = new Rectangle2D.Float(x, y, 6, 6);
    }

    public void rotateLeft(){
        if(a < 0) a += 2* Math.PI;
        a -= 0.1;
        dx = (float) Math.cos(a) * 5;
        dy = (float) Math.sin(a) * 5;
    }

    public void rotateRight(){
        if(a > Math.PI * 2) a -= 2* Math.PI;
        a += 0.1;
        dx = (float) Math.cos(a) * 5;
        dy = (float) Math.sin(a) * 5;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
