package river.rollforinitiative.fabric;


import net.fabricmc.api.ModInitializer;
import river.rollforinitiative.RollForInitiative;

public class RollForInitiativeFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        RollForInitiative.init();
    }
}