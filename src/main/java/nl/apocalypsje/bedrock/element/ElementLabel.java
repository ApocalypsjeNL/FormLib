package nl.apocalypsje.bedrock.element;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ElementLabel extends Element {

    private String elementText;

    public ElementLabel() {
        super(ElementType.LABEL);
    }

    public ElementLabel(@Nullable String elementText) {
        super(ElementType.LABEL);
        this.elementText = elementText;
    }

    @Nullable
    public String getElementText() {
        return this.elementText;
    }

    @NotNull
    public ElementLabel elementText(@Nullable String elementText) {
        this.elementText = elementText;
        return this;
    }

    @Override
    @NotNull
    public JsonObject getJsonData() {
        this.jsonObject.addProperty("type", this.elementType.getElementTypeId());
        this.jsonObject.addProperty("text", this.elementText != null ? this.elementText : "");
        return this.jsonObject;
    }

    @Override
    public String toString() {
        return "ElementLabel{" +
                "elementText='" + this.elementText + '\'' +
                ", jsonObject=" + this.jsonObject +
                ", elementId='" + this.elementId + '\'' +
                ", elementType=" + this.elementType +
                '}';
    }
}
