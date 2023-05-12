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
            System.out.println("Entered add");
            Container container = (Container) model;
            String cmnd = Utilities.ask("Component name?");
            container.addComponent(cmnd);
        } catch (Exception e) {
            //System.err.println("Error adding element: " + e.getMessage());
        }
    }

}
