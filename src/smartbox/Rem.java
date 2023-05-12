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
        Container container = (Container)model;
        String cmnd = Utilities.ask("Component name?");
        container.remComponent(cmnd);
    }

}
