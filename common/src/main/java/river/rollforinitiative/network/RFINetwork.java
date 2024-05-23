package river.rollforinitiative.network;

import net.minecraft.resources.ResourceLocation;
import river.rollforinitiative.RollForInitiative;
import river.rollforinitiative.network.messages.OpenCharacterSheetMessage;
import river.rollforinitiative.network.messages.OpenEncounterManagerMessage;
import river.rollforinitiative.network.messages.StartEncounterMessage;

public class RFINetwork {

    public static final NetworkManager NETWORK = NetworkManager.create(new ResourceLocation(RollForInitiative.MODID, "channel"));

    public static MessageType OPEN_ENCOUNTER_MANAGER, OPEN_CHARACTER_SHEET, START_ENCOUNTER;

    public static void init() {
        // S2C Messages
        OPEN_ENCOUNTER_MANAGER = NETWORK.registerS2C("open_monitor", OpenEncounterManagerMessage::new);
        OPEN_CHARACTER_SHEET = NETWORK.registerS2C("open_character_sheet", OpenCharacterSheetMessage::new);

        // C2S Messages
        START_ENCOUNTER = NETWORK.registerC2S("start_encounter", StartEncounterMessage::new);
    }

}
