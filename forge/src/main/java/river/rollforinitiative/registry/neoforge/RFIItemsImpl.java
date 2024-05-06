package river.rollforinitiative.registry.neoforge;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import river.rollforinitiative.contants.RFILocalization;
import river.rollforinitiative.registry.RFIBlocks;
import river.rollforinitiative.registry.RFIItems;

public class RFIItemsImpl {
    public static CreativeModeTab getGameMasterItemGroup() {
        return CreativeModeTab.builder().title(Component.translatable(RFILocalization.GAME_MASTER_TAB)).icon(() -> new ItemStack(RFIBlocks.ENCOUNTER_MANAGER.get())).build();
    }
    public static CreativeModeTab getPlayerItemGroup() {
        return CreativeModeTab.builder().title(Component.translatable(RFILocalization.PLAYER_TAB)).icon(() -> new ItemStack(RFIItems.CHARACTER_SHEET.get())).build();
    }

}