package river.rollforinitiative.contants;

import river.rollforinitiative.RollForInitiative;

public class RFILocalization {

    // Creative Tabs
    public static String GAME_MASTER_TAB = "itemGroup."+ RollForInitiative.MODID + ".gmtab";
    public static String PLAYER_TAB = "itemGroup."+ RollForInitiative.MODID + ".playertab";


    // Items
    public static String ENCOUNTER_LINKED = message("encounter_linked");

    public static String message(String translationKey){
        return "message." + RollForInitiative.MODID + "." + translationKey;
    }
}
