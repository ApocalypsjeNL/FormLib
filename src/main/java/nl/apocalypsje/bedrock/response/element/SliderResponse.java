package nl.apocalypsje.bedrock.response.element;

public class SliderResponse extends Response {

    private float minimum;
    private float maximum;
    private int step;
    private float value;

    public SliderResponse(String elementId, float minimum, float maximum, int step, float value) {
        super(elementId);
        this.minimum = minimum;
        this.maximum = maximum;
        this.step = step;
        this.value = value;
    }

    public float getMinimum() {
        return this.minimum;
    }

    public float getMaximum() {
        return this.maximum;
    }

    public int getStep() {
        return this.step;
    }

    public float getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "SliderResponse{" +
                "minimum=" + this.minimum +
                ", maximum=" + this.maximum +
                ", step=" + this.step +
                ", value=" + this.value +
                ", elementId='" + this.elementId + '\'' +
                '}';
    }
}
