import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    private final int gridSize = 8;
    private final int caseSize = 64;
    private final int grid[][] = {
            {1,1,1,1,1,1,1,1},
            {1,0,1,0,0,0,0,1},
            {1,0,1,0,0,0,0,1},
            {1,0,0,0,0,0,0,1},
            {1,0,0,0,0,1,0,1},
            {1,0,0,0,0,1,0,1},
            {1,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1}
    };
    private Player player;

    public Map(Player player) {
        this.player = player;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(new Color(111, 111, 111));
        g.fillRect(0, 0, 10000, 10000);

        for(int i = 0 ;  i < gridSize ; i++){
            for(int j = 0 ; j < gridSize ; j++){
                if(grid[i][j] == 0) g.setColor(new Color(255, 255, 255));
                else g.setColor(new Color(0, 0, 0));
                g.fillRect(i*caseSize, j*caseSize, caseSize, caseSize);
                g.setColor(new Color(111, 111, 111));
                g.drawRect(i*caseSize, j*caseSize, caseSize, caseSize);
            }
        }

        player.draw(g);
    }


    public void repaint(Graphics g) {
        player.draw(g);
    }

    public Player getPlayer() {
        return player;
    }

    public int[][] getGrid() {
        return grid;
    }

    public int getCaseSize() {
        return caseSize;
    }
}
