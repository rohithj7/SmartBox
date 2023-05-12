package smartbox;

import mvc.AppFactory;
import mvc.AppPanel;
import mvc.Utilities;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

public class ContainerPanel extends AppPanel {

    private JButton add;
    private JButton rem;
    private JButton run;

    public ContainerPanel(AppFactory factory) {
        super(factory);
        Container container = (Container) model;

        this.setLayout(new GridLayout(1, 2));

        container.addPropertyChangeListener(this);
        controlPanel.setLayout(new GridLayout(3,1));
        add = new JButton("Add");
        add.addActionListener(this);
        controlPanel.add(add);
        rem = new JButton("Rem");
        rem.addActionListener(this);
        controlPanel.add(rem);
        run = new JButton("Run");
        run.addActionListener(this);
        controlPanel.add(run);

        //ContainerView view = new ContainerView(model);

    }

    public static void main(String[] args) {
        AppFactory factory = new ContainerFactory();
        AppPanel panel = new ContainerPanel(factory);
        panel.display();
    }

}
