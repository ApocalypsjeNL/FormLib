package nl.apocalypsje.bedrock.element;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.NotNull;

public class Element {

    protected final JsonObject jsonObject = new JsonObject();
    protected String elementId;
    protected ElementType elementType;

    Element(@NotNull ElementType elementType) {
        this.elementType = elementType;
    }

    @NotNull
    public String getElementId() {
        return this.elementId;
    }

    @NotNull
    public Element id(@NotNull String elementId) {
        this.elementId = elementId;
        return this;
    }

    @NotNull
    public JsonObject getJsonData() {
        throw new UnsupportedOperationException("getJsonData isn't implemented in the chosen Element");
    }

    @Override
    public String toString() {
        return "Element{" +
                "jsonObject=" + this.jsonObject +
                ", elementId='" + this.elementId + '\'' +
                '}';
    }
}
