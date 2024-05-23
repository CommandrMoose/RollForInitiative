package river.rollforinitiative.data;

import com.google.gson.JsonObject;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import river.rollforinitiative.RollForInitiative;
import river.rollforinitiative.registry.RFIBlocks;

public class BlockModelProvider extends BlockStateProvider {
    public BlockModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator.getPackOutput(), RollForInitiative.MODID, existingFileHelper);
    }

    public JsonObject customLocation(Block block, ResourceLocation resourceLocation) {
        return getVariantBuilder(block).partialState().modelForState().modelFile(models().getExistingFile(resourceLocation)).addModel().toJson();
    }

    @Override
    protected void registerStatesAndModels() {

        simpleBlock(RFIBlocks.ENCOUNTER_MANAGER.get());
        customLocation(RFIBlocks.BATTLE_MAP.get(), new ResourceLocation(RollForInitiative.MODID, "block/battle_map"));

    }
}
