package nl.apocalypsje.bedrock.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.server.DataPacketReceiveEvent;
import cn.nukkit.network.protocol.ModalFormResponsePacket;
import nl.apocalypsje.bedrock.FormAPI;
import nl.apocalypsje.bedrock.response.ModalResponse;
import nl.apocalypsje.bedrock.window.ModalWindow;
import nl.apocalypsje.bedrock.window.Window;
import org.jetbrains.annotations.NotNull;

public class FormDataListener implements Listener {

    private FormAPI formAPI;

    public FormDataListener(@NotNull FormAPI formAPI) {
        this.formAPI = formAPI;
    }

    @EventHandler
    public void onDataPacket(DataPacketReceiveEvent event) {
        if (!(event.getPacket() instanceof ModalFormResponsePacket)) {
            return;
        }

        ModalFormResponsePacket formResponsePacket = (ModalFormResponsePacket) event.getPacket();

        int formId = formResponsePacket.formId;
        if (this.formAPI.getWindowCache().containsKey(formId)) {
            Window window = this.formAPI.getWindowCache().remove(formId);
            String jsonData = formResponsePacket.data.trim();

            if (window instanceof ModalWindow) {
                ModalWindow modalWindow = (ModalWindow) window;
                switch (jsonData) {
                    case "null":
                        modalWindow.setCancelled(true);
                        modalWindow.supplyResponse(ModalResponse.CANCELLED);
                        break;
                    case "true":
                        modalWindow.supplyResponse(ModalResponse.UPPER_BUTTON);
                        break;
                    case "false":
                        modalWindow.supplyResponse(ModalResponse.LOWER_BUTTON);
                        break;
                    default:
                        modalWindow.supplyResponse(ModalResponse.UNKNOWN);
                        break;
                }
            }
        }
    }
}
