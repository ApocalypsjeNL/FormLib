package nl.apocalypsje.bedrock.response.element;

public class StepSliderResponse extends Response {

    private int stepId;
    private String stepText;

    public StepSliderResponse(String elementId, int stepId, String stepText) {
        super(elementId);
        this.stepId = stepId;
        this.stepText = stepText;
    }

    public int getStepId() {
        return this.stepId;
    }

    public String getStepText() {
        return this.stepText;
    }

    @Override
    public String toString() {
        return "StepSliderResponse{" +
                "stepId=" + this.stepId +
                ", stepText='" + this.stepText + '\'' +
                ", elementId='" + this.elementId + '\'' +
                '}';
    }
}
