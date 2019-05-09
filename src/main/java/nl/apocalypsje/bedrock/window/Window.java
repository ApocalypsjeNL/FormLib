package nl.apocalypsje.bedrock.window;

import cn.nukkit.Player;
import cn.nukkit.network.protocol.ModalFormRequestPacket;
import com.google.gson.JsonObject;
import nl.apocalypsje.bedrock.FormAPI;
import org.jetbrains.annotations.NotNull;

public class Window {

    private final FormAPI formApi;

    private int windowId;
    private boolean cancelled;
    private WindowType windowType;

    Window(@NotNull FormAPI formApi, int windowId, @NotNull WindowType windowType) {
        this.formApi = formApi;
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
    protected JsonObject getJsonData() {
        throw new UnsupportedOperationException("getJsonData isn't implemented in the chosen Window Type");
    }

    public void send(@NotNull Player player) {
        ModalFormRequestPacket packet = new ModalFormRequestPacket();
        packet.formId = this.getWindowId();
        packet.data = this.getJsonData().toString();
        formApi.getWindowCache().put(this.getWindowId(), this);
        player.dataPacket(packet);
    }
}
