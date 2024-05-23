package river.rollforinitiative.fabric;


import net.fabricmc.api.ModInitializer;
import river.rollforinitiative.RollForInitiative;
import river.rollforinitiative.fabric.events.ModEvents;
import river.rollforinitiative.network.RFINetwork;

public class RollForInitiativeFabric implements ModInitializer {
    @Override
    public void onInitialize() {

        ModEvents.addCommonEvents();
        RollForInitiative.init();
        RFINetwork.init();

    }
}