package river.rollforinitiative.common.capability.fabric;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import dev.onyxstudios.cca.api.v3.world.WorldComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.world.WorldComponentInitializer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import river.rollforinitiative.RollForInitiative;

public class RFIComponents implements WorldComponentInitializer {


    public static final ComponentKey<RFIWorldComponentImpl> RFI_DATA = ComponentRegistryV3.INSTANCE.getOrCreate(new ResourceLocation(RollForInitiative.MODID, "rfi_data"), RFIWorldComponentImpl.class);

    @Override
    public void registerWorldComponentFactories(WorldComponentFactoryRegistry registry) {
        registry.register(RFI_DATA, level -> {
            if (level instanceof ServerLevel serverLevel) {
                return new RFIWorldComponentImpl(serverLevel);
            }

            return new RFIWorldComponentDummy(level);
        });
    }
}
