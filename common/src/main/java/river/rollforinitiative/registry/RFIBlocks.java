package river.rollforinitiative.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import river.rollforinitiative.RollForInitiative;

import java.util.function.Supplier;

public class RFIBlocks {

    public static final DeferredRegistry<Block> BLOCKS = DeferredRegistry.create(RollForInitiative.MODID, Registries.BLOCK);

    private static <T extends Block> RegistrySupplier<T> register(String id, Supplier<T> blockSupplier, boolean addToTab, boolean registerItem) {
        return BLOCKS.register(id, blockSupplier);
    }

    private static <T extends Block> RegistrySupplier<T> register(String id, Supplier<T> blockSupplier, boolean addToTab) {
        return register(id, blockSupplier, addToTab, true);
    }

}
