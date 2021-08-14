import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class KeyMoveListener implements KeyListener {

    Map map;

    public KeyMoveListener(Map map) {
        this.map = map;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_Z){
            map.getPlayer().forward();
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            map.getPlayer().backward();
        }
        if(e.getKeyCode() == KeyEvent.VK_Q){
            map.getPlayer().rotateLeft();
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            map.getPlayer().rotateRight();
        }

        map.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
