package nl.apocalypsje.bedrock.response;

import nl.apocalypsje.bedrock.element.ElementButton;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public enum SimpleResponse {

    CANCELLED,
    BUTTON,
    UNKNOWN;

    private ElementButton clickedButton;

    SimpleResponse() {
    }

    @Nullable
    public ElementButton getClickedButton() {
        return this.clickedButton;
    }

    @NotNull
    public SimpleResponse setClickedButton(@NotNull ElementButton clickedButton) {
        this.clickedButton = clickedButton;
        return this;
    }

    @Override
    public String toString() {
        return "SimpleResponse." + this.name() + "{" +
                "clickedButton=" + this.clickedButton +
                '}';
    }
}
