package nl.apocalypsje.bedrock.response;

/**
 * Response for the {@link nl.apocalypsje.bedrock.window.ModalWindow} window.
 * When the window is pressed away used the back or ESC key, the {@link ModalResponse#LOWER_BUTTON} response will be returned.
 */

public enum ModalResponse {
    /**
     * Returned when the upper button is clicked.
     */
    UPPER_BUTTON,
    /**
     * Returned when the lower button is clicked or when the window got clicked away using the back or ESC key.
     */
    LOWER_BUTTON;

    @Override
    public String toString() {
        return "ModalResponse." + this.name() + "{}";
    }
}
