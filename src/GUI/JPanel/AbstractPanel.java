package GUI.JPanel;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractPanel extends JPanel{
    protected static final Dimension SCREENSIZE=Toolkit.getDefaultToolkit().getScreenSize();
    protected static final int WIDTH=SCREENSIZE.width;
    protected static final int HEIGHT= SCREENSIZE.height;

    protected JPanel panel;
    protected JFrame frame;

    public AbstractPanel(JPanel jPanel, JFrame jFrame){
        this.panel=jPanel;
        this.frame=jFrame;
    }

    /*protected static JPanel getInstance(JPanel jPanel,JFrame jFrame){
        panel=jPanel;
        frame=jFrame;
        return panel;
    }*/

    public abstract JPanel initPanel();

}
