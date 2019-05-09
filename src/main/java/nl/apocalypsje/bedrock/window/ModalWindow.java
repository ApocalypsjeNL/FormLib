package nl.apocalypsje.bedrock.window;

import com.google.gson.JsonObject;
import nl.apocalypsje.bedrock.FormAPI;
import nl.apocalypsje.bedrock.response.ModalResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class ModalWindow extends Window {

    private String formTitle;
    private String formContent;
    private String upperButtonText;
    private String lowerButtonText;

    private Consumer<ModalResponse> answer;

    public ModalWindow(@NotNull FormAPI formApi, int windowId) {
        super(formApi, windowId, WindowType.MODAL);
    }

    public ModalWindow(@NotNull FormAPI formApi, int windowId, @Nullable String formTitle) {
        super(formApi, windowId, WindowType.MODAL);
        this.formTitle = formTitle;
    }

    public ModalWindow(@NotNull FormAPI formApi, int windowId, @Nullable String formTitle, @Nullable String formContent) {
        super(formApi, windowId, WindowType.MODAL);
        this.formTitle = formTitle;
        this.formContent = formContent;
    }

    public ModalWindow(@NotNull FormAPI formApi, int windowId, @Nullable String formTitle, @Nullable String formContent, @Nullable String upperButtonText, @Nullable String lowerButtonText) {
        super(formApi, windowId, WindowType.MODAL);
        this.formTitle = formTitle;
        this.formContent = formContent;
        this.upperButtonText = upperButtonText;
        this.lowerButtonText = lowerButtonText;
    }

    @Nullable
    public String getFormTitle() {
        return this.formTitle;
    }

    @NotNull
    public ModalWindow title(@Nullable String formTitle) {
        this.formTitle = formTitle;
        return this;
    }

    @Nullable
    public String getFormContent() {
        return this.formContent;
    }

    @NotNull
    public ModalWindow content(@Nullable String formContent) {
        this.formContent = formContent;
        return this;
    }

    @Nullable
    public String getUpperButtonText() {
        return this.upperButtonText;
    }

    @NotNull
    public ModalWindow upperButton(@Nullable String upperButtonText) {
        this.upperButtonText = upperButtonText;
        return this;
    }

    @Nullable
    public String getLowerButtonText() {
        return this.lowerButtonText;
    }

    @NotNull
    public ModalWindow lowerButton(@Nullable String lowerButtonText) {
        this.lowerButtonText = lowerButtonText;
        return this;
    }

    public void supplyResponse(@NotNull ModalResponse response) {
        if(this.answer != null) {
            this.answer.accept(response);
        }
    }

    @NotNull
    public ModalWindow answer(@NotNull Consumer<ModalResponse> answer) {
        this.answer = answer;
        return this;
    }

    @Override
    @NotNull
    protected JsonObject getJsonData() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", this.getWindowType().getTypeName());
        jsonObject.addProperty("title", this.formTitle != null ? this.formTitle : "");
        jsonObject.addProperty("content", this.formContent != null ? this.formContent : "");
        jsonObject.addProperty("button1", this.upperButtonText != null ? this.upperButtonText : "");
        jsonObject.addProperty("button2", this.lowerButtonText != null ? this.lowerButtonText : "");
        return jsonObject;
    }
}
