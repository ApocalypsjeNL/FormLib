package nl.apocalypsje.bedrock.response.element;

public class ToggleResponse extends Response {

    private boolean toggled;

    public ToggleResponse(String elementId, boolean toggled) {
        super(elementId);
        this.toggled = toggled;
    }

    public boolean isToggled() {
        return this.toggled;
    }

    @Override
    public String toString() {
        return "ToggleResponse{" +
                "toggled=" + this.toggled +
                ", elementId='" + this.elementId + '\'' +
                '}';
    }
}
