package nl.apocalypsje.bedrock.response.element;

public class InputResponse extends Response {

    private String input;

    public InputResponse(String elementId, String input) {
        super(elementId);
        this.input = input;
    }

    public String getInput() {
        return this.input;
    }

    @Override
    public String toString() {
        return "InputResponse{" +
                "input='" + this.input + '\'' +
                ", elementId='" + this.elementId + '\'' +
                '}';
    }
}
