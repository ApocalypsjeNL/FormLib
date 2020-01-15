package nl.apocalypsje.bedrock.element;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ElementToggle extends Element {

    private String elementText;
    private boolean defaultValue;

    public ElementToggle() {
        super(ElementType.TOGGLE);
    }

    public ElementToggle(@Nullable String elementText) {
        super(ElementType.TOGGLE);
        this.elementText = elementText;
    }

    public ElementToggle(@Nullable String elementText, boolean defaultValue) {
        super(ElementType.TOGGLE);
        this.elementText = elementText;
        this.defaultValue = defaultValue;
    }

    @Nullable
    public String getElementText() {
        return this.elementText;
    }

    @NotNull
    public ElementToggle elementText(@Nullable String elementText) {
        this.elementText = elementText;
        return this;
    }

    public boolean isDefaultValue() {
        return this.defaultValue;
    }

    @NotNull
    public ElementToggle defaultValue(boolean defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    @Override
    @NotNull
    public JsonObject getJsonData() {
        this.jsonObject.addProperty("type", this.elementType.getElementTypeId());
        this.jsonObject.addProperty("text", this.elementText != null ? this.elementText : "");
        this.jsonObject.addProperty("default", this.defaultValue);
        return this.jsonObject;
    }

    @Override
    public String toString() {
        return "ElementToggle{" +
                "elementText='" + this.elementText + '\'' +
                ", default=" + this.defaultValue +
                ", jsonObject=" + this.jsonObject +
                ", elementId='" + this.elementId + '\'' +
                ", elementType=" + this.elementType +
                '}';
    }
}
