package river.rollforinitiative.common.capability.fabric;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import river.rollforinitiative.RollForInitiative;
import river.rollforinitiative.common.capability.RFIWorldComponent;

import java.util.Optional;

public class RFIWorldComponentDummy extends RFIWorldComponentImpl {

    public RFIWorldComponentDummy(Level level) {
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
    public void writeToNbt(CompoundTag tag) {

    }

    @Override
    public void readFromNbt(CompoundTag tag) {

    }


}
