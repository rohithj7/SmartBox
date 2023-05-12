package smartbox;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

public class Rem extends Command {

    public Rem(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        try {
            Container container = (Container) model;
            String cmnd = Utilities.ask("Component name?");
            container.remComponent(cmnd);
        } catch (Exception e) {
            mvc.Utilities.error("Error removing element: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
