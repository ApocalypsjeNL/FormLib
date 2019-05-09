package nl.apocalypsje.bedrock.window;

import org.jetbrains.annotations.NotNull;

public enum WindowType {

    MODAL("modal"),
    SIMPLE("simple"),
    CUSTOM("custom");

    private String typeName;

    WindowType(@NotNull String typeName) {
        this.typeName = typeName;
    }

    @NotNull
    public String getTypeName() {
        return this.typeName;
    }
}
