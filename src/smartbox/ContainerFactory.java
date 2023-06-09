package smartbox;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public class ContainerFactory implements AppFactory {

    @Override
    public Model makeModel() {
        return new Container();
    }

    @Override
    public String[] getEditCommands() {
        return new String[] {"Add", "Rem", "Run"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object src) {
        if (type == "Add")
            return new Add(model);
        else if (type == "Rem")
            return new Rem(model);
        else if (type == "Run")
            return new Run(model);

        return null;
    }

    @Override
    public View makeView(Model model) {
        return new ContainerView(model);
    }

    @Override
    public String getTitle() {
        return "Smart Box";
    }

    @Override
    public String[] getHelp() {
        String[] cmmds = new String[3];
        cmmds[0] = "Select \"Add\" to add components";
        cmmds[1] = "Select \"Rem\" to remove components";
        cmmds[2] = "Select \"Run\" to run components";
        return cmmds;
    }

    @Override
    public String about() {
        return "SmartBox 1.0. Copyright 2023 by Rohith Iyengar";
    }


}
