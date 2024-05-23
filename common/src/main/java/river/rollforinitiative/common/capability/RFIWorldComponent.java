package river.rollforinitiative.common.capability;


import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import river.rollforinitiative.common.managers.EncounterManager;

import java.util.Optional;

public class RFIWorldComponent {

    private EncounterManager encounterManager;

    public RFIWorldComponent(Level level) {
        encounterManager = new EncounterManager(this);
    }

    @ExpectPlatform
    public static Optional<RFIWorldComponent> get(ServerLevel level) {
        throw new AssertionError();
    }

    public CompoundTag serializeNBT() {
        CompoundTag compoundTag = new CompoundTag();
        return compoundTag;
    }

    public void deserializeNBT( CompoundTag compoundTag) {

    }

    public void onTick() {

    }

    public EncounterManager getEncounterManager() {
        return encounterManager;
    }
}
