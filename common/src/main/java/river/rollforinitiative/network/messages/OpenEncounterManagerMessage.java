package river.rollforinitiative.network.messages;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import org.jetbrains.annotations.NotNull;
import river.rollforinitiative.client.ScreenHandler;
import river.rollforinitiative.network.MessageContext;
import river.rollforinitiative.network.MessageS2C;
import river.rollforinitiative.network.MessageType;
import river.rollforinitiative.network.RFINetwork;

public class OpenEncounterManagerMessage extends MessageS2C {

    private BlockPos encounterBlockPosition;

    public OpenEncounterManagerMessage(BlockPos encounterBlockPosition) {
        this.encounterBlockPosition = encounterBlockPosition;
    }

    public OpenEncounterManagerMessage(FriendlyByteBuf friendlyByteBuf) {
        this.encounterBlockPosition = friendlyByteBuf.readBlockPos();
    }

    @NotNull
    @Override
    public MessageType getType() {
        return RFINetwork.OPEN_ENCOUNTER_MANAGER;
    }

    @Override
    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBlockPos(this.encounterBlockPosition);
    }

    @Override
    public void handle(MessageContext context) {
        handleScreens();
    }

    @Environment(EnvType.CLIENT)
    private void handleScreens() {
        // Open the monitor.
        ScreenHandler.openEncounterManagerScreen(encounterBlockPosition);
    }
}
