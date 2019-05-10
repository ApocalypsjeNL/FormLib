package nl.apocalypsje.bedrock.element;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ElementSlider extends Element {

    private String elementText;
    private float minimal;
    private float maximal;
    private int stepCount;
    private float defaultValue;

    public ElementSlider() {
        super(ElementType.SLIDER);
    }

    public ElementSlider(@Nullable String elementText) {
        super(ElementType.SLIDER);
        this.elementText = elementText;
        this.minimal = 0f;
        this.maximal = 100f;
        this.stepCount = 1;
        this.defaultValue = 0f;
    }

    public ElementSlider(@Nullable String elementText, float minimal, float maximal) {
        super(ElementType.SLIDER);
        if(minimal >= maximal) {
            throw new IllegalArgumentException("Maximal value can't be smaller or equal to the minimal value");
        }
        this.elementText = elementText;
        this.minimal = minimal;
        this.maximal = maximal;
        this.stepCount = 1;
        this.defaultValue = minimal;
    }

    public ElementSlider(@Nullable String elementText, float minimal, float maximal, int stepCount) {
        super(ElementType.SLIDER);
        if(minimal >= maximal) {
            throw new IllegalArgumentException("Maximal value can't be smaller or equal to the minimal value");
        }
        this.elementText = elementText;
        this.minimal = minimal;
        this.maximal = maximal;
        this.stepCount = stepCount;
        this.defaultValue = minimal;
    }

    public ElementSlider(@Nullable String elementText, float minimal, float maximal, int stepCount, float defaultValue) {
        super(ElementType.SLIDER);
        if(minimal >= maximal) {
            throw new IllegalArgumentException("Maximal value can't be smaller or equal to the minimal value");
        }
        this.elementText = elementText;
        this.minimal = minimal;
        this.maximal = maximal;
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

    public float getMinimal() {
        return this.minimal;
    }

    @NotNull
    public ElementSlider minimal(float minimal) {
        this.minimal = minimal;
        return this;
    }

    public float getMaximal() {
        return this.maximal;
    }

    @NotNull
    public ElementSlider maximal(float maximal) {
        this.maximal = maximal;
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
        this.jsonObject.addProperty("min", this.minimal);
        this.jsonObject.addProperty("max", this.maximal);
        this.jsonObject.addProperty("step", this.stepCount);
        this.jsonObject.addProperty("defaultValue", this.defaultValue);
        return this.jsonObject;
    }

    @Override
    public String toString() {
        return "ElementSlider{" +
                "elementText='" + this.elementText + '\'' +
                ", minimal=" + this.minimal +
                ", maximal=" + this.maximal +
                ", stepCount=" + this.stepCount +
                ", defaultValue=" + this.defaultValue +
                ", jsonObject=" + this.jsonObject +
                ", elementId='" + this.elementId + '\'' +
                ", elementType=" + this.elementType +
                '}';
    }
}
