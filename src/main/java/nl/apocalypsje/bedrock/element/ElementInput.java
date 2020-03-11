package nl.apocalypsje.bedrock.element;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ElementInput extends Element {

    private String elementText;
    private String placeholder;
    private String defaultText;

    public ElementInput() {
        super(ElementType.INPUT);
    }

    public ElementInput(@Nullable String elementText) {
        super(ElementType.INPUT);
        this.elementText = elementText;
    }

    public ElementInput(@Nullable String elementText, @Nullable String placeholder) {
        super(ElementType.INPUT);
        this.elementText = elementText;
        this.placeholder = placeholder;
    }

    public ElementInput(@Nullable String elementText, @Nullable String placeholder, @Nullable String defaultText) {
        super(ElementType.INPUT);
        this.elementText = elementText;
        this.placeholder = placeholder;
        this.defaultText = defaultText;
    }

    @Nullable
    public String getElementText() {
        return this.elementText;
    }

    @NotNull
    public ElementInput elementText(@Nullable String elementText) {
        this.elementText = elementText;
        return this;
    }

    @Nullable
    public String getPlaceholder() {
        return this.placeholder;
    }

    @NotNull
    public ElementInput placeholder(@Nullable String placeholder) {
        this.placeholder = placeholder;
        return this;
    }

    @Nullable
    public String getDefaultText() {
        return this.defaultText;
    }

    @NotNull
    public ElementInput defaultText(@Nullable String defaultText) {
        this.defaultText = defaultText;
        return this;
    }

    @Override
    @NotNull
    public JsonObject getJsonData() {
        this.jsonObject.addProperty("type", this.elementType.getElementTypeId());
        this.jsonObject.addProperty("text", this.elementText != null ? this.elementText : "");
        this.jsonObject.addProperty("placeholder", this.placeholder != null ? this.placeholder : "");
        this.jsonObject.addProperty("defaultText", this.defaultText != null ? this.defaultText : "");
        return this.jsonObject;
    }

    @Override
    public String toString() {
        return "ElementInput{" +
                "elementText='" + this.elementText + '\'' +
                ", placeholder='" + this.placeholder + '\'' +
                ", default='" + this.defaultText + '\'' +
                ", jsonObject=" + this.jsonObject +
                ", elementId='" + this.elementId + '\'' +
                ", elementType=" +this. elementType +
                '}';
    }
}
