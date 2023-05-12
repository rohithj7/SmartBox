package mvc;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Nathan Duong
 * 3/14/2023
 * Removed initSupport() from setModel(), moved to AppPanel
 *
 * Rohith Iyengar
 * 3/21
 */

public class View extends JPanel implements PropertyChangeListener {

    protected Model model;

    public View(Model m) {
        model = m;
        model.addPropertyChangeListener(this);
        setBackground(Color.LIGHT_GRAY);
    }

    public void setModel(Model newModel) {
        model.removePropertyChangeListener(this);
        model = newModel;
        this.model.initSupport();
        model.addPropertyChangeListener(this);
        model.changed();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }


}
