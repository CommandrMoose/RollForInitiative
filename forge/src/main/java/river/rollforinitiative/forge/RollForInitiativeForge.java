package river.rollforinitiative.forge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import river.rollforinitiative.RollForInitiative;

@Mod(RollForInitiative.MODID)
public class RollForInitiativeForge {
    public RollForInitiativeForge() {
        RollForInitiative.init();
    }
}