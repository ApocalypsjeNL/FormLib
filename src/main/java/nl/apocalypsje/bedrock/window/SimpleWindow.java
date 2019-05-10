package nl.apocalypsje.bedrock.window;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import nl.apocalypsje.bedrock.element.ElementButton;
import nl.apocalypsje.bedrock.util.Procedure;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleWindow extends Window {

    private String formTitle;
    private String formContent;

    private final Map<String, ElementButton> formButtons = new LinkedHashMap<>();

    private Procedure closeCallback;

    public SimpleWindow(int windowId) {
        super(windowId, WindowType.SIMPLE);
    }

    public SimpleWindow(int windowId, @Nullable String formTitle) {
        super(windowId, WindowType.SIMPLE);
        this.formTitle = formTitle;
    }

    public SimpleWindow(int windowId, @Nullable String formTitle, @Nullable String formContent) {
        super(windowId, WindowType.SIMPLE);
        this.formTitle = formTitle;
        this.formContent = formContent;
    }

    public SimpleWindow(int windowId, @Nullable String formTitle, @Nullable String formContent, @NotNull Map<String, ElementButton> formButtons) {
        super(windowId, WindowType.SIMPLE);
        this.formTitle = formTitle;
        this.formContent = formContent;
        this.formButtons.putAll(formButtons);
    }

    @Nullable
    public String getFormTitle() {
        return this.formTitle;
    }

    @NotNull
    public SimpleWindow title(@Nullable String formTitle) {
        this.formTitle = formTitle;
        return this;
    }

    @Nullable
    public String getFormContent() {
        return this.formContent;
    }

    @NotNull
    public SimpleWindow content(@Nullable String formContent) {
        this.formContent = formContent;
        return this;
    }

    @NotNull
    public Map<String, ElementButton> getFormButtons() {
        return this.formButtons;
    }

    @NotNull
    public SimpleWindow button(@NotNull ElementButton button) {
        this.formButtons.put(button.getElementId(), button);
        return this;
    }

    public void triggerClose() {
        if(this.closeCallback != null) {
            this.closeCallback.accept();
        }
    }

    @NotNull
    public SimpleWindow onClose(@NotNull Procedure closeCallback) {
        this.closeCallback = closeCallback;
        return this;
    }

    @Override
    @NotNull
    public JsonObject getJsonData() {
        this.jsonObject.addProperty("type", this.getWindowType().getTypeName());
        this.jsonObject.addProperty("title", this.formTitle != null ? this.formTitle : "");
        this.jsonObject.addProperty("content", this.formContent != null ? this.formContent : "");
        this.jsonObject.add("buttons", new JsonArray());
        this.formButtons.forEach((id, button) -> this.jsonObject.getAsJsonArray("buttons").add(button.getJsonData()));
        return jsonObject;
    }

    @Override
    public String toString() {
        return "SimpleWindow{" +
                "formTitle='" + this.formTitle + '\'' +
                ", formContent='" + this.formContent + '\'' +
                ", formButtons=" + this.formButtons +
                ", jsonObject=" + this.jsonObject +
                '}';
    }
}
