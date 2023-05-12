package smartbox;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

public class Add extends Command {

    public Add(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        try {
            Container container = (Container) model;
            String cmnd = Utilities.ask("Component name?");
            container.addComponent(cmnd);
        } catch (Exception e) {
            mvc.Utilities.error("Error adding element: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
