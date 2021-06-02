package nl.apocalypsje.bedrock.element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ElementDropdown extends Element {

    private String elementText;
    private final List<String> dropdownOptions = new ArrayList<>();
    private int defaultOptionIndex = 0;

    public ElementDropdown() {
        super(ElementType.DROPDOWN);
    }

    public ElementDropdown(@Nullable String elementText) {
        super(ElementType.DROPDOWN);
        this.elementText = elementText;
    }

    public ElementDropdown(@Nullable String elementText, @NotNull List<String> dropdownOptions) {
        super(ElementType.DROPDOWN);
        this.elementText = elementText;
        this.dropdownOptions.addAll(dropdownOptions);
    }

    public ElementDropdown(@Nullable String elementText, @NotNull List<String> dropdownOptions, int defaultOptionIndex) {
        super(ElementType.DROPDOWN);
        this.elementText = elementText;
        this.dropdownOptions.addAll(dropdownOptions);
        this.defaultOptionIndex = defaultOptionIndex;
    }

    @Nullable
    public String getElementText() {
        return this.elementText;
    }

    @NotNull
    public ElementDropdown elementText(@Nullable String elementText) {
        this.elementText = elementText;
        return this;
    }

    @NotNull
    public List<String> getDropdownOptions() {
        return this.dropdownOptions;
    }

    @NotNull
    public ElementDropdown addOptions(@NotNull List<String> options) {
        this.dropdownOptions.addAll(options);
        return this;
    }

    @NotNull
    public ElementDropdown addOption(@NotNull String option) {
        this.dropdownOptions.add(option);
        return this;
    }

    public int getDefaultOptionIndex() {
        return this.defaultOptionIndex;
    }

    @NotNull
    public ElementDropdown defaultIndex(int defaultOptionIndex) {
        this.defaultOptionIndex = defaultOptionIndex;
        return this;
    }

    @NotNull
    public ElementDropdown defaultIndex(@NotNull String option) {
        if(this.dropdownOptions.indexOf(option) != -1) {
            this.defaultOptionIndex = this.dropdownOptions.indexOf(option);
        } else {
            this.dropdownOptions.add(option);
            this.defaultOptionIndex = this.dropdownOptions.size() - 1;
        }
        return this;
    }

    @Override
    @NotNull
    public JsonObject getJsonData() {
        this.jsonObject.addProperty("type", this.elementType.getElementTypeId());
        this.jsonObject.addProperty("text", this.elementText != null ? this.elementText : "");
        this.jsonObject.add("options", new JsonArray());
        if(!this.dropdownOptions.isEmpty()) {
            this.dropdownOptions.forEach(this.jsonObject.getAsJsonArray("options")::add);
            this.jsonObject.addProperty("default", this.defaultOptionIndex);
        } else {
            this.jsonObject.getAsJsonArray("options").add("No options provided.");
            this.jsonObject.addProperty("default", 0);
        }
        return this.jsonObject;
    }

    @Override
    public String toString() {
        return "ElementDropdown{" +
                "elementText='" + this.elementText + '\'' +
                ", options=" + this.dropdownOptions +
                ", default=" + this.defaultOptionIndex +
                ", jsonObject=" + this.jsonObject +
                ", elementId='" + this.elementId + '\'' +
                ", elementType=" + this.elementType +
                '}';
    }
}
