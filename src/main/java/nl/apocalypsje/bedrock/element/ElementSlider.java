package nl.apocalypsje.bedrock.element;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ElementSlider extends Element {

    private String elementText;
    private float minimum;
    private float maximum;
    private int stepCount;
    private float defaultValue;

    public ElementSlider() {
        super(ElementType.SLIDER);
    }

    public ElementSlider(@Nullable String elementText) {
        super(ElementType.SLIDER);
        this.elementText = elementText;
        this.minimum = 0f;
        this.maximum = 100f;
        this.stepCount = 1;
        this.defaultValue = 0f;
    }

    public ElementSlider(@Nullable String elementText, float minimum, float maximum) {
        super(ElementType.SLIDER);
        if(minimum >= maximum) {
            throw new IllegalArgumentException("Maximal value can't be smaller or equal to the minimal value");
        }
        this.elementText = elementText;
        this.minimum = minimum;
        this.maximum = maximum;
        this.stepCount = 1;
        this.defaultValue = minimum;
    }

    public ElementSlider(@Nullable String elementText, float minimum, float maximum, int stepCount) {
        super(ElementType.SLIDER);
        if(minimum >= maximum) {
            throw new IllegalArgumentException("Maximal value can't be smaller or equal to the minimal value");
        }
        this.elementText = elementText;
        this.minimum = minimum;
        this.maximum = maximum;
        this.stepCount = stepCount;
        this.defaultValue = minimum;
    }

    public ElementSlider(@Nullable String elementText, float minimum, float maximum, int stepCount, float defaultValue) {
        super(ElementType.SLIDER);
        if(minimum >= maximum) {
            throw new IllegalArgumentException("Maximal value can't be smaller or equal to the minimal value");
        }
        this.elementText = elementText;
        this.minimum = minimum;
        this.maximum = maximum;
        this.stepCount = stepCount;
        this.defaultValue = defaultValue;
    }

    @Nullable
    public String getElementText() {
        return this.elementText;
    }

    @NotNull
    public ElementSlider elementText(@Nullable String elementText) {
        this.elementText = elementText;
        return this;
    }

    public float getMinimum() {
        return this.minimum;
    }

    @NotNull
    public ElementSlider minimum(float minimum) {
        this.minimum = minimum;
        return this;
    }

    public float getMaximum() {
        return this.maximum;
    }

    @NotNull
    public ElementSlider maximum(float maximum) {
        this.maximum = maximum;
        return this;
    }

    public int getStepCount() {
        return this.stepCount;
    }

    @NotNull
    public ElementSlider stepCount(int stepCount) {
        this.stepCount = stepCount;
        return this;
    }

    public float getDefaultValue() {
        return this.defaultValue;
    }

    @NotNull
    public ElementSlider defaultValue(float defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    @Override
    @NotNull
    public JsonObject getJsonData() {
        this.jsonObject.addProperty("type", this.elementType.getElementTypeId());
        this.jsonObject.addProperty("text", this.elementText != null ? this.elementText : "");
        this.jsonObject.addProperty("min", this.minimum);
        this.jsonObject.addProperty("max", this.maximum);
        this.jsonObject.addProperty("step", this.stepCount);
        this.jsonObject.addProperty("defaultValue", this.defaultValue);
        return this.jsonObject;
    }

    @Override
    public String toString() {
        return "ElementSlider{" +
                "elementText='" + this.elementText + '\'' +
                ", minimum=" + this.minimum +
                ", maximum=" + this.maximum +
                ", stepCount=" + this.stepCount +
                ", defaultValue=" + this.defaultValue +
                ", jsonObject=" + this.jsonObject +
                ", elementId='" + this.elementId + '\'' +
                ", elementType=" + this.elementType +
                '}';
    }
}
