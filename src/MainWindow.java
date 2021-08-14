import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends JFrame {
    private Container mainContainer;
    private Map map;
    private Player player;

    public MainWindow() {
        setBounds(400, 100, 1000, 500);
        addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e){
                        System.exit(0);
                    }
                }
        );

        this.mainContainer = this.getContentPane();
        this.player = new Player();
        this.map = new Map(player);
        mainContainer.add(map);

        addKeyListener(new KeyMoveListener(map));

        setVisible(true);
    }
}
