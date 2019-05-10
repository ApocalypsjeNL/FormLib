package nl.apocalypsje.bedrock.response;

import com.google.gson.JsonArray;
import nl.apocalypsje.bedrock.element.*;
import nl.apocalypsje.bedrock.response.element.*;
import nl.apocalypsje.bedrock.window.CustomWindow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CustomResponse {

    private final CustomWindow window;
    private final JsonArray response;
    private final Map<String, Element> responseElements = new LinkedHashMap<>();
    private final List<String> elementIdList = new ArrayList<>();

    public CustomResponse(@NotNull CustomWindow window) {
        this.window = window;
        this.response = null;
        this.responseElements.putAll(this.window.getElements());
        this.elementIdList.addAll(this.window.getElements().keySet());
    }

    public CustomResponse(@NotNull CustomWindow window, @NotNull JsonArray response) {
        this.window = window;
        this.response = response;
        this.responseElements.putAll(this.window.getElements());
        this.elementIdList.addAll(this.window.getElements().keySet());
    }

    @Nullable
    public DropdownResponse getDropdown(@NotNull String elementId) {
        if(!this.responseElements.containsKey(elementId) && !(this.responseElements.get(elementId) instanceof ElementDropdown)) {
            return null;
        }

        ElementDropdown elementDropdown = (ElementDropdown) this.responseElements.get(elementId);
        int optionId = this.response == null ? elementDropdown.getDefaultOptionIndex() : this.response.get(this.elementIdList.indexOf(elementId)).getAsInt();

        return new DropdownResponse(elementId, optionId, elementDropdown.getDropdownOptions().get(optionId));
    }

    @Nullable
    public InputResponse getInput(@NotNull String elementId) {
        if(!this.responseElements.containsKey(elementId) && !(this.responseElements.get(elementId) instanceof ElementInput)) {
            return null;
        }

        ElementInput elementInput = (ElementInput) this.responseElements.get(elementId);
        String input = this.response == null ? elementInput.getDefaultText() : this.response.get(this.elementIdList.indexOf(elementId)).getAsString();

        return new InputResponse(elementId, input);
    }

    @Nullable
    public SliderResponse getSlider(@NotNull String elementId) {
        if(!this.responseElements.containsKey(elementId) && !(this.responseElements.get(elementId) instanceof ElementSlider)) {
            return null;
        }

        ElementSlider elementSlider = (ElementSlider) this.responseElements.get(elementId);
        float value = this.response == null ? elementSlider.getDefaultValue() : this.response.get(this.elementIdList.indexOf(elementId)).getAsFloat();

        return new SliderResponse(elementId, elementSlider.getMinimum(), elementSlider.getMaximum(), elementSlider.getStepCount(), value);
    }

    @Nullable
    public StepSliderResponse getStepSlider(@NotNull String elementId) {
        if(!this.responseElements.containsKey(elementId) && !(this.responseElements.get(elementId) instanceof ElementStepSlider)) {
            return null;
        }

        ElementStepSlider elementStepSlider = (ElementStepSlider) this.responseElements.get(elementId);
        int stepId = this.response == null ? elementStepSlider.getDefaultStepIndex() : this.response.get(this.elementIdList.indexOf(elementId)).getAsInt();

        return new StepSliderResponse(elementId, stepId, elementStepSlider.getStepOptions().get(stepId));
    }

    @Nullable
    public ToggleResponse getToggle(@NotNull String elementId) {
        if(!this.responseElements.containsKey(elementId) && !(this.responseElements.get(elementId) instanceof ElementToggle)) {
            return null;
        }

        ElementToggle elementToggle = (ElementToggle) this.responseElements.get(elementId);
        boolean toggle = this.response == null ? elementToggle.isDefaultValue() : this.response.get(this.elementIdList.indexOf(elementId)).getAsBoolean();

        return new ToggleResponse(elementId, toggle);
    }

    @Override
    public String toString() {
        return "CustomResponse{" +
                "window=" + this.window +
                ", response=" + this.response +
                ", responseElements=" + this.responseElements +
                ", elementIdList=" + this.elementIdList +
                '}';
    }
}
