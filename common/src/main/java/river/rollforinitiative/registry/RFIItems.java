package river.rollforinitiative.registry;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import river.rollforinitiative.RollForInitiative;
import river.rollforinitiative.common.item.CharacterSheetItem;
import river.rollforinitiative.common.item.GameMasterScreenItem;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class RFIItems {

    public static final DeferredRegistry<Item> ITEMS = DeferredRegistry.create(RollForInitiative.MODID, Registries.ITEM);
    public static List<RegistrySupplier<Item>> GAME_MASTER_TAB_ITEMS = new ArrayList<>();
    public static List<RegistrySupplier<Item>> PLAYER_TAB_ITEMS = new ArrayList<>();
    public static final DeferredRegistry<CreativeModeTab> TABS = DeferredRegistry.create(RollForInitiative.MODID, Registries.CREATIVE_MODE_TAB);

    public static final RegistrySupplier<CreativeModeTab> GAME_MASTER_TAB = TABS.register("game_master_tab", RFIItems::getGameMasterItemGroup);
    public static final RegistrySupplier<CreativeModeTab> PLAYER_TAB = TABS.register("player_tab", RFIItems::getPlayerItemGroup);

    // Items
    public static final RegistrySupplier<CharacterSheetItem> CHARACTER_SHEET = register("character_sheet", () -> new CharacterSheetItem(new Item.Properties()), PLAYER_TAB);
    public static final RegistrySupplier<GameMasterScreenItem> GAME_MASTER_SCREEN = register("game_master_screen", () -> new GameMasterScreenItem(new Item.Properties()), GAME_MASTER_TAB);



    private static <T extends Item> RegistrySupplier<T> register(String id, Supplier<T> itemSupplier, RegistrySupplier<CreativeModeTab> tab) {
        RegistrySupplier<T> item = ITEMS.register(id, itemSupplier);

        if(tab != null) {

            if (tab == GAME_MASTER_TAB) {
                GAME_MASTER_TAB_ITEMS.add((RegistrySupplier<Item>) item);
            }

            if (tab == PLAYER_TAB) {
                PLAYER_TAB_ITEMS.add((RegistrySupplier<Item>) item);
            }
        }

        return item;
    }


    @ExpectPlatform
    public static CreativeModeTab getGameMasterItemGroup() {
        throw new RuntimeException(RollForInitiative.PLATFORM_ERROR);
    }

    @ExpectPlatform
    public static CreativeModeTab getPlayerItemGroup() {
        throw new RuntimeException(RollForInitiative.PLATFORM_ERROR);
    }

}
