package nl.apocalypsje.bedrock.window;

import org.jetbrains.annotations.NotNull;

public enum WindowType {

    MODAL("modal"),
    SIMPLE("form"),
    CUSTOM("custom_form");

    private String typeName;

    WindowType(@NotNull String typeName) {
        this.typeName = typeName;
    }

    @NotNull
    public String getTypeName() {
        return this.typeName;
    }

    @Override
    public String toString() {
        return "WindowType." + this.name() + "{" +
                "typeName='" + this.typeName + '\'' +
                '}';
    }
}
