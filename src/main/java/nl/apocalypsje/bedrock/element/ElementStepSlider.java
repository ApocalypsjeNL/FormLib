package nl.apocalypsje.bedrock.element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ElementStepSlider extends Element {

    private String elementText;
    private final List<String> stepOptions = new ArrayList<>();
    private int defaultStepIndex = 0;

    public ElementStepSlider() {
        super(ElementType.STEP_SLIDER);
    }

    public ElementStepSlider(@Nullable String elementText) {
        super(ElementType.STEP_SLIDER);
        this.elementText = elementText;
    }

    public ElementStepSlider(@Nullable String elementText, @NotNull List<String> stepOptions) {
        super(ElementType.STEP_SLIDER);
        this.elementText = elementText;
        this.stepOptions.addAll(stepOptions);
    }

    public ElementStepSlider(@Nullable String elementText, @NotNull List<String> stepOptions, int defaultStepIndex) {
        super(ElementType.STEP_SLIDER);
        this.elementText = elementText;
        this.stepOptions.addAll(stepOptions);
        this.defaultStepIndex = defaultStepIndex;
    }

    @Nullable
    public String getElementText() {
        return this.elementText;
    }

    @NotNull
    public ElementStepSlider elementText(@Nullable String elementText) {
        this.elementText = elementText;
        return this;
    }

    @NotNull
    public List<String> getStepOptions() {
        return this.stepOptions;
    }

    @NotNull
    public ElementStepSlider addStepOption(@NotNull String stepOption) {
        this.stepOptions.add(stepOption);
        return this;
    }

    public int getDefaultStepIndex() {
        return this.defaultStepIndex;
    }

    @NotNull
    public ElementStepSlider defaultIndex(int defaultStepIndex) {
        this.defaultStepIndex = defaultStepIndex;
        return this;
    }

    @NotNull
    public ElementStepSlider defaultIndex(@NotNull String stepOption) {
        if(this.stepOptions.indexOf(stepOption) != -1) {
            this.defaultStepIndex = this.stepOptions.indexOf(stepOption);
        } else {
            this.stepOptions.add(stepOption);
            this.defaultStepIndex = this.stepOptions.size() - 1;
        }
        return this;
    }

    @Override
    @NotNull
    public JsonObject getJsonData() {
        this.jsonObject.addProperty("type", this.elementType.getElementTypeId());
        this.jsonObject.addProperty("text", this.elementText != null ? this.elementText : "");
        this.jsonObject.add("steps", new JsonArray());
        if(!this.stepOptions.isEmpty()) {
            this.stepOptions.forEach(this.jsonObject.getAsJsonArray("steps")::add);
            this.jsonObject.addProperty("defaultStepIndex", this.defaultStepIndex);
        } else {
            this.jsonObject.getAsJsonArray("steps").add("No options provided.");
            this.jsonObject.addProperty("defaultStepIndex", 0);
        }
        return this.jsonObject;
    }

    @Override
    public String toString() {
        return "ElementStepSlider{" +
                "elementText='" + this.elementText + '\'' +
                ", stepOptions=" + this.stepOptions +
                ", defaultStepIndex=" + this.defaultStepIndex +
                ", jsonObject=" + this.jsonObject +
                ", elementId='" + this.elementId + '\'' +
                ", elementType=" + this.elementType +
                '}';
    }
}
