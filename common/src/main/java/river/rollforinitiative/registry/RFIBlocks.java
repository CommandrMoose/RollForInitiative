package river.rollforinitiative.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import river.rollforinitiative.RollForInitiative;
import river.rollforinitiative.common.block.EncounterManagerBlock;

import java.util.function.Supplier;


public class RFIBlocks {

    public static final DeferredRegistry<Block> BLOCKS = DeferredRegistry.create(RollForInitiative.MODID, Registries.BLOCK);

    public static final RegistrySupplier<EncounterManagerBlock> ENCOUNTER_MANAGER = register("encounter_manager", () -> new EncounterManagerBlock(BlockBehaviour.Properties.of().strength(1000, 1000).sound(SoundType.METAL)), true, RFIItems.GAME_MASTER_TAB);
    public static final RegistrySupplier<Block> BATTLE_MAP = register("battle_map", () -> new Block(BlockBehaviour.Properties.of().strength(1000, 1000).sound(SoundType.WOOD)), true, RFIItems.GAME_MASTER_TAB);

    private static <T extends Block> RegistrySupplier<T> register(String id, Supplier<T> blockSupplier, boolean registerItem, RegistrySupplier<CreativeModeTab> tab) {
        RegistrySupplier<T> registryObject = BLOCKS.register(id, blockSupplier);
        if (registerItem) {
            RegistrySupplier<Item> itemSupplier = RFIItems.ITEMS.register(id, () -> new BlockItem(registryObject.get(), new Item.Properties()));

            if(tab != null) {

                if (tab == RFIItems.GAME_MASTER_TAB) {
                    RFIItems.GAME_MASTER_TAB_ITEMS.add(itemSupplier);
                }

                if (tab == RFIItems.PLAYER_TAB) {
                    RFIItems.PLAYER_TAB_ITEMS.add(itemSupplier);
                }
            }
        }
        return registryObject;
    }

    private static <T extends Block> RegistrySupplier<T> register(String id, Supplier<T> blockSupplier) {
        return register(id, blockSupplier, false, null);
    }

}
