package river.rollforinitiative.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import river.rollforinitiative.RollForInitiative;
import river.rollforinitiative.registry.RFIBlocks;
import river.rollforinitiative.registry.RFIItems;

public class ItemModelProvider extends net.neoforged.neoforge.client.model.generators.ItemModelProvider {

    public ItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator.getPackOutput(), RollForInitiative.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        registerBlockModels();

        basicItem(RFIItems.CHARACTER_SHEET.getId());
        basicItem(RFIItems.GAME_MASTER_SCREEN.getId());

    }

    private void registerBlockModels() {
        blockItem(RFIBlocks.ENCOUNTER_MANAGER.getId());
    }


    public ItemModelBuilder blockItem(ResourceLocation item) {
        return getBuilder(item.toString()).parent(new ModelFile.UncheckedModelFile(new ResourceLocation(item.getNamespace(), "block/" + item.getPath())));
    }

    public ItemModelBuilder blockItem(ResourceLocation item, ResourceLocation modelLocation) {
        return getBuilder(item.toString()).parent(new ModelFile.UncheckedModelFile(modelLocation));
    }
}
