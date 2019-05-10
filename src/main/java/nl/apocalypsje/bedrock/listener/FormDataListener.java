package nl.apocalypsje.bedrock.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.server.DataPacketReceiveEvent;
import cn.nukkit.network.protocol.ModalFormResponsePacket;
import nl.apocalypsje.bedrock.FormAPI;
import nl.apocalypsje.bedrock.element.ElementButton;
import nl.apocalypsje.bedrock.response.ModalResponse;
import nl.apocalypsje.bedrock.response.SimpleResponse;
import nl.apocalypsje.bedrock.window.CustomWindow;
import nl.apocalypsje.bedrock.window.ModalWindow;
import nl.apocalypsje.bedrock.window.SimpleWindow;
import nl.apocalypsje.bedrock.window.Window;

import java.util.ArrayList;

public class FormDataListener implements Listener {



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
                    modalWindow.supplyResponse(ModalResponse.UPPER_BUTTON);
                } else {
                    modalWindow.triggerLowerButtonClick();
                    modalWindow.supplyResponse(ModalResponse.LOWER_BUTTON);
                }
            } else if (window instanceof SimpleWindow) {
                SimpleWindow simpleWindow = (SimpleWindow) window;
                if (jsonData.equals("null")) {
                    simpleWindow.setCancelled(true);
                    simpleWindow.supplyResponse(SimpleResponse.CANCELLED);
                } else {
                    try {
                        int buttonId = Integer.valueOf(jsonData);
                        ElementButton button = new ArrayList<>(simpleWindow.getFormButtons().values()).get(buttonId);
                        button.triggerCick();
                        simpleWindow.supplyResponse(SimpleResponse.BUTTON.setClickedButton(button));
                    } catch (NumberFormatException e) {
                        simpleWindow.supplyResponse(SimpleResponse.UNKNOWN);
                    }
                }
            } else if (window instanceof CustomWindow) {
                CustomWindow customWindow = (CustomWindow) window;
                if (jsonData.equals("null")) {
                    customWindow.setCancelled(true);
                }
                //TODO handle the response
            }
        }
    }
}
