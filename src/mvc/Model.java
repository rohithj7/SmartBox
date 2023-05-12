package mvc;

public class Model extends Bean
{
    private static final long serialVersionUID = 1L;
    private boolean unsavedChanges;
    private String fileName;

    public Model() {
        unsavedChanges = false;
        fileName = null;
    }

    public void changed() {
        unsavedChanges = true;
        firePropertyChange(null,null,null);
    }

    public void setFileName(String fName) {
        fileName = fName;
    }

    public void setUnsavedChanges(boolean unsavedChanges) {
        this.unsavedChanges = unsavedChanges;
    }

    public String getFileName() {
        return fileName;
    }

    public boolean getUnsavedChanges() {
        return unsavedChanges;
    }

}
