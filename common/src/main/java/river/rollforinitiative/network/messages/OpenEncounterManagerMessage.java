package river.rollforinitiative.network.messages;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.network.FriendlyByteBuf;
import org.jetbrains.annotations.NotNull;
import river.rollforinitiative.client.ScreenHandler;
import river.rollforinitiative.network.MessageContext;
import river.rollforinitiative.network.MessageS2C;
import river.rollforinitiative.network.MessageType;
import river.rollforinitiative.network.RFINetwork;

public class OpenEncounterManagerMessage extends MessageS2C {


    public OpenEncounterManagerMessage() {

    }

    public OpenEncounterManagerMessage(FriendlyByteBuf friendlyByteBuf) {

    }

    @NotNull
    @Override
    public MessageType getType() {
        return RFINetwork.OPEN_ENCOUNTER_MANAGER;
    }

    @Override
    public void toBytes(FriendlyByteBuf buf) {

    }

    @Override
    public void handle(MessageContext context) {
        handleScreens();
    }

    @Environment(EnvType.CLIENT)
    private void handleScreens() {
        // Open the monitor.
        ScreenHandler.openEncounterManagerScreen();
    }
}
