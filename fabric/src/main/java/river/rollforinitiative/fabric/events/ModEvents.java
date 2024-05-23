package river.rollforinitiative.fabric.events;

import river.rollforinitiative.common.capability.RFIWorldComponent;

import static net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents.START_WORLD_TICK;

public class ModEvents {

    public static void addCommonEvents() {
        START_WORLD_TICK.register(world -> {
            RFIWorldComponent.get(world).get().onTick();
        });
    }
}
