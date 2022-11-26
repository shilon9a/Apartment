package GUI.JPanel;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends AbstractPanel{
    public MainPanel(JPanel jPanel, JFrame jFrame) {
        super(jPanel, jFrame);
    }

    @Override
    public JPanel initPanel() {
        panel.setLayout(null);
        panel.setBounds(0,0,jFrame.getWidth(),jFrame.getHeight());
        panel.setBackground(Color.cyan);


        panel.setVisible(true);
        return panel;
    }
}
