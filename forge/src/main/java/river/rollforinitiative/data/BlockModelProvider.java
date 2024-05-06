package river.rollforinitiative.data;

import net.minecraft.data.DataGenerator;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import river.rollforinitiative.RollForInitiative;
import river.rollforinitiative.registry.RFIBlocks;

public class BlockModelProvider extends BlockStateProvider {
    public BlockModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator.getPackOutput(), RollForInitiative.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        simpleBlock(RFIBlocks.ENCOUNTER_MANAGER.get());
    }
}
