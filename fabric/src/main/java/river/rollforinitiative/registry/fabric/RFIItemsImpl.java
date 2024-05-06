package river.rollforinitiative.registry.fabric;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import river.rollforinitiative.contants.RFILocalization;
import river.rollforinitiative.registry.RFIBlocks;
import river.rollforinitiative.registry.RFIItems;
import river.rollforinitiative.registry.RegistrySupplier;

public class RFIItemsImpl {

    public static final CreativeModeTab GAME_MASTER_ITEM_GROUP = FabricItemGroup.builder().icon(() -> new ItemStack(RFIBlocks.ENCOUNTER_MANAGER.get())).displayItems((enabledFeatures, entries) -> {
        for (RegistrySupplier<Item> item : RFIItems.GAME_MASTER_TAB_ITEMS) {
            entries.accept(item.get());
        }
    }).title(Component.translatable(RFILocalization.GAME_MASTER_TAB)).build();

    public static final CreativeModeTab PLAYER_ITEM_GROUP = FabricItemGroup.builder().icon(() -> new ItemStack(RFIItems.CHARACTER_SHEET.get())).displayItems((enabledFeatures, entries) -> {
        for (RegistrySupplier<Item> item : RFIItems.PLAYER_TAB_ITEMS) {
            entries.accept(item.get());
        }
    }).title(Component.translatable(RFILocalization.PLAYER_TAB)).build();


    public static CreativeModeTab getGameMasterItemGroup() {
        return GAME_MASTER_ITEM_GROUP;
    }
    public static CreativeModeTab getPlayerItemGroup() {
        return PLAYER_ITEM_GROUP;
    }


}
