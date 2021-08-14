import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    private final Integer mapX = 8;
    private final Integer mapY = 8;
    private final Integer size = 64;
    private final Integer  field[] = {
            1,1,1,1,1,1,1,1,
            1,0,1,0,0,0,0,1,
            1,0,1,0,0,0,0,1,
            1,0,0,0,0,0,0,1,
            1,0,0,0,0,1,0,1,
            1,0,0,0,0,1,0,1,
            1,0,0,0,0,0,0,1,
            1,1,1,1,1,1,1,1
    };
    private Player player;

    public Map(Player player) {
        this.player = player;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int xo;
        int yo;

        g.setColor(new Color(111, 111, 111));
        g.fillRect(0, 0, size*mapX*2, size*mapY*2);


        for (int y = 0; y < mapY ; y++){
            for (int x = 0; x < mapX ; x++){
                if(field[y*mapX+x] == 1){
                    g.setColor(new Color(255, 255, 255));
                }
                else{
                    g.setColor(new Color(0, 0, 0));
                }
                xo = x*size + x;
                yo = y*size+ y;
                g.fillRect(xo, yo, size, size);
            }
        }

        player.draw(g);
    }

    public void repaint(Graphics g){
        player.draw(g);
    }

    public Player getPlayer() {
        return player;
    }
}
