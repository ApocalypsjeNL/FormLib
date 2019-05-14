package nl.apocalypsje.bedrock.window;

import cn.nukkit.Player;
import cn.nukkit.network.protocol.ModalFormRequestPacket;
import com.google.gson.JsonObject;
import nl.apocalypsje.bedrock.FormAPI;
import org.jetbrains.annotations.NotNull;

public class Window {

    protected final JsonObject jsonObject = new JsonObject();

    private int windowId;
    private boolean cancelled;
    private WindowType windowType;

    Window(int windowId, @NotNull WindowType windowType) {
        this.windowId = windowId;
        this.windowType = windowType;
    }

    public int getWindowId() {
        return this.windowId;
    }

    @NotNull
    public WindowType getWindowType() {
        return this.windowType;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @NotNull
    public JsonObject getJsonData() {
        throw new UnsupportedOperationException("getJsonData isn't implemented in the chosen Window Type");
    }

    public Window send(@NotNull Player player) {
        ModalFormRequestPacket packet = new ModalFormRequestPacket();
        packet.formId = this.getWindowId();
        packet.data = this.getJsonData().toString();
        FormAPI.getWindowCache().put(this.getWindowId(), this);
        player.dataPacket(packet);
        return this;
    }

    @Override
    public String toString() {
        return "Window{" +
                "jsonObject=" + this.jsonObject +
                ", windowId=" + this.windowId +
                ", cancelled=" + this.cancelled +
                ", windowType=" + this.windowType +
                '}';
    }
}
