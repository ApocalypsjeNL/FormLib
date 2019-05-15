package nl.apocalypsje.bedrock.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.server.DataPacketReceiveEvent;
import cn.nukkit.network.protocol.ModalFormResponsePacket;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import nl.apocalypsje.bedrock.FormAPI;
import nl.apocalypsje.bedrock.element.ElementButton;
import nl.apocalypsje.bedrock.response.CustomResponse;
import nl.apocalypsje.bedrock.window.CustomWindow;
import nl.apocalypsje.bedrock.window.ModalWindow;
import nl.apocalypsje.bedrock.window.SimpleWindow;
import nl.apocalypsje.bedrock.window.Window;

import java.util.ArrayList;

public class FormDataListener implements Listener {

    private final JsonParser jsonParser = new JsonParser();

    @EventHandler
    public void onDataPacket(DataPacketReceiveEvent event) {
        if (!(event.getPacket() instanceof ModalFormResponsePacket)) {
            return;
        }

        ModalFormResponsePacket formResponsePacket = (ModalFormResponsePacket) event.getPacket();

        int formId = formResponsePacket.formId;
        if (FormAPI.getWindowCache().containsKey(formId)) {
            Window window = FormAPI.getWindowCache().remove(formId);
            String jsonData = formResponsePacket.data.trim();

            if (window instanceof ModalWindow) {
                ModalWindow modalWindow = (ModalWindow) window;
                if (jsonData.equals("true")) {
                    modalWindow.triggerUpperClick();
                } else {
                    modalWindow.triggerLowerButtonClick();
                }
            } else if (window instanceof SimpleWindow) {
                SimpleWindow simpleWindow = (SimpleWindow) window;
                if (jsonData.equals("null")) {
                    simpleWindow.setCancelled(true);
                    simpleWindow.triggerClose();
                } else {
                    try {
                        int buttonId = Integer.valueOf(jsonData);
                        ElementButton button = new ArrayList<>(simpleWindow.getFormButtons().values()).get(buttonId);
                        button.triggerCick();
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            } else if (window instanceof CustomWindow) {
                CustomWindow customWindow = (CustomWindow) window;
                if (jsonData.equals("null")) {
                    customWindow.setCancelled(true);
                    customWindow.supplyResponse(new CustomResponse(customWindow));
                } else {
                    JsonArray array = this.jsonParser.parse(jsonData).getAsJsonArray();
                    customWindow.supplyResponse(new CustomResponse(customWindow, array));
                }
            }
        }
    }
}
