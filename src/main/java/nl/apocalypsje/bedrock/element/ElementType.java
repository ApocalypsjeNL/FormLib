package nl.apocalypsje.bedrock.element;

import org.jetbrains.annotations.NotNull;

public enum ElementType {

    BUTTON("button"),
    DROPDOWN("dropdown"),
    INPUT("input"),
    LABEL("label"),
    SLIDER("slider"),
    STEP_SLIDER("step_slider"),
    TOGGLE("toggle");

    private String elementTypeId;

    ElementType(@NotNull String elementTypeId) {
        this.elementTypeId = elementTypeId;
    }

    @NotNull
    public String getElementTypeId() {
        return this.elementTypeId;
    }

    @Override
    public String toString() {
        return "ElementType." + this.name() + "{" +
                "elementTypeId='" + this.elementTypeId + '\'' +
                '}';
    }
}
