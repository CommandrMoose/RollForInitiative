package river.rollforinitiative.network.messages;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;
import river.rollforinitiative.common.blockentity.EncounterManagerBlockEntity;
import river.rollforinitiative.common.capability.RFIWorldComponent;
import river.rollforinitiative.common.managers.EncounterManager;
import river.rollforinitiative.network.MessageC2S;
import river.rollforinitiative.network.MessageContext;
import river.rollforinitiative.network.MessageType;
import river.rollforinitiative.network.RFINetwork;

public class StartEncounterMessage extends MessageC2S {

    private BlockPos encounterBlockPosition;

    public StartEncounterMessage(BlockPos encounterBlockPosition) {
        this.encounterBlockPosition = encounterBlockPosition;
    }

    public StartEncounterMessage(FriendlyByteBuf friendlyByteBuf) {
        this.encounterBlockPosition = friendlyByteBuf.readBlockPos();
    }

    @NotNull
    @Override
    public MessageType getType() {
        return RFINetwork.START_ENCOUNTER;
    }

    @Override
    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBlockPos(this.encounterBlockPosition);
    }

    @Override
    public void handle(MessageContext context) {

        ServerLevel level = context.getPlayer().serverLevel();

        RFIWorldComponent.get(level).ifPresent(x -> {

            if (level.getBlockEntity(encounterBlockPosition) instanceof EncounterManagerBlockEntity encounterManagerBlockEntity) {

                EncounterManager encounterManager = x.getEncounterManager();

                encounterManager.setEncounterManagerBlockEntity(encounterManagerBlockEntity);
                encounterManager.start();
            }
        });

    }
}
