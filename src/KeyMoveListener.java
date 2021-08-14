import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class KeyMoveListener implements KeyListener {

    private Map map;

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
            map.getPlayer().rotate((float)-0.1);

            if(map.getPlayer().getAngle() > Math.PI * 2){
                map.getPlayer().rotate(-2* Math.PI);
            }

            map.getPlayer().setDx((float) Math.cos(map.getPlayer().getAngle()) * 5);
            map.getPlayer().setDy((float) Math.sin(map.getPlayer().getAngle()) * 5);
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            map.getPlayer().rotate((float)0.1);

            if(map.getPlayer().getAngle() < 0){
                map.getPlayer().rotate(2* Math.PI);
            }

            map.getPlayer().setDx((float) Math.cos(map.getPlayer().getAngle()) * 5);
            map.getPlayer().setDy((float) Math.sin(map.getPlayer().getAngle()) * 5);
        }

        map.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
