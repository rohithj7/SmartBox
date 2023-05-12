package smartbox;

import java.util.*;
import mvc.*;

public class Container extends Model {

    private Map<Class<?>, Component> providedInterfaces = new HashMap<Class<?>, Component>();
    private Map<Class<?>, Component> requiredInterfaces = new HashMap<Class<?>, Component>();
    private Map<String, Component> components = new HashMap<String, Component>();

    public Collection<Component> getComponents() {
        return components.values();
    }

    public void addComponent(String name) throws Exception {
        String qualName = "smartbox.components." + name;
        Object obj;
        Class<?> clazz = Class.forName(qualName);
        obj = clazz.newInstance();
        addComponent((Component) obj);
    }


    private void addComponent(Component component) throws Exception {
        component.setContainer(this);
        components.put(component.name, component);
        for (Class<?> intf : component.getProvidedInterfaces()) {
            providedInterfaces.put(intf, component);
        }
        for (Class<?> intf : component.getRequiredInterfaces()) {
            requiredInterfaces.put(intf, component);
        }
        //???
        //find providers for the new component and hook him up:
        findProviders();
        // mvc stuff:
        changed();
    }

    public void remComponent(String name) throws Exception {

        Component component = components.get(name);
        components.remove(name);
        // unhook removed guy from any clients:
        for (Class<?> intf : component.getProvidedInterfaces()) {
            for (Component client : components.values()) {
                if (client.getRequiredInterfaces().contains(intf)) {
                    client.setProvider(intf, null);
                    requiredInterfaces.put(intf, client);
                }
            }
        }
        changed();
    }

    // each time we add a new component we try to connect as many clients and providers as we can:
    private void findProviders() throws Exception {
        Set<Class<?>> reqInterfaces = requiredInterfaces.keySet();
        for (Class<?> intf : reqInterfaces) {
            Component client = requiredInterfaces.get(intf);
            Component provider = providedInterfaces.get(intf);
            if (client != null && provider != null) {
                client.setProvider(intf, provider);
                //requiredInterfaces.remove(intf); this line makes iterator obsolete
                requiredInterfaces.put(intf, null);
            }
        }
    }

    public void launch(String name) {
        try {
            // look up component and call main if it's an App
            if(components.get(name) instanceof App) {
                App app = (App) components.get(name);
                app.main();
            } else {
                mvc.Utilities.error("Input is not an instance of App");
            }
        } catch (Exception e) {
            mvc.Utilities.error(e.getMessage());
            e.printStackTrace();
        }
    }

    // needed by File/Open
    public void initSupport() {
        super.initSupport();
        for (Component c : components.values()) c.initSupport();
        changed(); // needed?
    }

}

