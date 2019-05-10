package nl.apocalypsje.bedrock.window;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import nl.apocalypsje.bedrock.element.Element;
import nl.apocalypsje.bedrock.element.ElementButton;
import nl.apocalypsje.bedrock.response.CustomResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class CustomWindow extends Window {

    private String formTitle;
    private ElementButton.ImageType formIconType;
    private String formIconData;
    private final Map<String, Element> elements = new LinkedHashMap<>();

    private Consumer<CustomResponse> answer;

    public CustomWindow(int windowId) {
        super(windowId, WindowType.CUSTOM);
    }

    public CustomWindow(int windowId, @Nullable String formTitle) {
        super(windowId, WindowType.CUSTOM);
        this.formTitle = formTitle;
    }

    public CustomWindow(int windowId, @Nullable String formTitle, @Nullable ElementButton.ImageType formIconType, @Nullable String formIconData) {
        super(windowId, WindowType.CUSTOM);
        this.formTitle = formTitle;
        this.formIconType = formIconType;
        this.formIconData = formIconData;
    }

    public CustomWindow(int windowId, @Nullable String formTitle, @NotNull List<Element> elements) {
        super(windowId, WindowType.CUSTOM);
        this.formTitle = formTitle;
        elements.forEach(element -> this.elements.put(element.getElementId(), element));
    }

    public CustomWindow(int windowId, @Nullable String formTitle, @Nullable ElementButton.ImageType formIconType, @Nullable String formIconData, @NotNull List<Element> elements) {
        super(windowId, WindowType.CUSTOM);
        this.formTitle = formTitle;
        this.formIconType = formIconType;
        this.formIconData = formIconData;
        elements.forEach(element -> this.elements.put(element.getElementId(), element));
    }

    @Nullable
    public String getFormTitle() {
        return this.formTitle;
    }

    @NotNull
    public CustomWindow title(@Nullable String formTitle) {
        this.formTitle = formTitle;
        return this;
    }

    @Nullable
    public ElementButton.ImageType getFormIconType() {
        return this.formIconType;
    }

    @NotNull
    public CustomWindow iconType(@Nullable ElementButton.ImageType formIconType) {
        this.formIconType = formIconType;
        return this;
    }

    @Nullable
    public String getFormIconData() {
        return this.formIconData;
    }

    @NotNull
    public CustomWindow iconData(@Nullable String formIconData) {
        this.formIconData = formIconData;
        return this;
    }

    @NotNull
    public Map<String, Element> getElements() {
        return this.elements;
    }

    @NotNull
    public CustomWindow addElement(@NotNull String elementId, @NotNull Element element) {
        this.elements.put(elementId, element.id(elementId));
        return this;
    }

    public void supplyResponse(@NotNull CustomResponse response) {
        if(this.answer != null) {
            this.answer.accept(response);
        }
    }

    @NotNull
    public CustomWindow onSubmit(@NotNull Consumer<CustomResponse> answer) {
        this.answer = answer;
        return this;
    }

    @Override
    @NotNull
    public JsonObject getJsonData() {
        this.jsonObject.addProperty("type", this.getWindowType().getTypeName());
        this.jsonObject.addProperty("title", this.formTitle != null ? this.formTitle : "");
        if(this.formIconType != null && this.formIconData != null) {
            JsonObject imageObject = new JsonObject();
            imageObject.addProperty("type", this.formIconType.getTypeString());
            imageObject.addProperty("data", this.formIconData);
            this.jsonObject.add("image", imageObject);
        }
        this.jsonObject.add("content", new JsonArray());
        this.elements.values().forEach(element -> this.jsonObject.getAsJsonArray("content").add(element.getJsonData()));
        return jsonObject;
    }

    @Override
    public String toString() {
        return "CustomWindow{" +
                "formTitle='" + this.formTitle + '\'' +
                ", formIconType=" + this.formIconType +
                ", formIconData='" + this.formIconData + '\'' +
                ", elements=" + this.elements +
                ", jsonObject=" + this.jsonObject +
                '}';
    }
}
