package nl.apocalypsje.bedrock.response.element;

public class DropdownResponse extends Response {

    private int optionId;
    private String optionText;

    public DropdownResponse(String elementId, int optionId, String optionText) {
        super(elementId);
        this.optionId = optionId;
        this.optionText = optionText;
    }

    public int getOptionId() {
        return this.optionId;
    }

    public String getOptionText() {
        return this.optionText;
    }

    @Override
    public String toString() {
        return "DropdownResponse{" +
                "optionId=" + this.optionId +
                ", optionText='" + this.optionText + '\'' +
                ", elementId='" + this.elementId + '\'' +
                '}';
    }
}
