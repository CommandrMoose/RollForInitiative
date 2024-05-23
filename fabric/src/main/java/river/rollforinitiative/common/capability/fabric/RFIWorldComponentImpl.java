package river.rollforinitiative.common.capability.fabric;

import dev.onyxstudios.cca.api.v3.component.ComponentV3;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import river.rollforinitiative.RollForInitiative;
import river.rollforinitiative.common.capability.RFIWorldComponent;

import java.util.Objects;
import java.util.Optional;

public class RFIWorldComponentImpl extends RFIWorldComponent implements ComponentV3 {

    public RFIWorldComponentImpl(Level level) {
        super(level);
    }

    public static Optional<RFIWorldComponent> get(ServerLevel level) {
        if(level == null) {
            return Optional.empty();
        }
        try {
            return Optional.of(RFIComponents.RFI_DATA.get(level));
        } catch (Exception e) {
            RollForInitiative.LOGGER.info(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public void readFromNbt(CompoundTag tag) {
        this.deserializeNBT(tag);
    }

    @Override
    public void writeToNbt(CompoundTag tag) {
        CompoundTag nbt = this.serializeNBT();
        for (String key : nbt.getAllKeys()) {
            tag.put(key, Objects.requireNonNull(nbt.get(key)));
        }
    }
}
