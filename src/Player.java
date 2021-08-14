import javax.swing.event.AncestorEvent;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class Player {
    private Float x,y;
    private Float dx, dy;
    private Float angle;
    private Rectangle2D rectangle;

    public Player() {
        this.x = (float) 150;
        this.y = (float) 400;
        this.angle = (float) Math.PI/2;
        this.dx = (float) Math.cos(angle) * 5;
        this.dy = (float) Math.sin(angle) * 5;
        this.rectangle = new Rectangle2D.Float(x, y, 6, 6);
    }

    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(255,0,0));

        AffineTransform old = g2d.getTransform();
        g2d.rotate(angle, x+3, y+3);
        g2d.draw(rectangle);
        g2d.fill(rectangle);
        g2d.setTransform(old);

        g2d.draw(new Line2D.Float(x + 3, y+3, x+dx*5 + 3, y+dy*5 + 3));

    }



    public void forward(){
        x += dx;
        y += dy;
        rectangle = new Rectangle2D.Float(x, y, 6, 6);
    }

    public void backward(){
        x -= dx;
        y -= dy;
        rectangle = new Rectangle2D.Float(x, y, 6, 6);
    }

    public void rotate(double a){
        angle += (float) a;

        rectangle = new Rectangle2D.Float(x, y, 6, 6);
    }

    public void setDx(float dx) {
        this.dx = dx;
    }

    public void setDy(float dy) {
        this.dy = dy;
    }

    public float getAngle() {
        return angle;
    }
}
