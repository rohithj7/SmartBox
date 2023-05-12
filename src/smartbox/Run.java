package smartbox;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

public class Run extends Command {

    public Run(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        Container container = (Container)model;
        String cmnd = Utilities.ask("Component name?");
        container.launch(cmnd);
    }

}
