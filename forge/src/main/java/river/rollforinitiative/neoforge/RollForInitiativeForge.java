package river.rollforinitiative.neoforge;

import net.minecraft.data.DataGenerator;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import river.rollforinitiative.RollForInitiative;
import river.rollforinitiative.data.ItemModelProvider;
import river.rollforinitiative.data.LangProviderEnglish;
import river.rollforinitiative.data.BlockModelProvider;
import river.rollforinitiative.data.TestPartyProvider;
import river.rollforinitiative.network.RFINetwork;

@Mod(RollForInitiative.MODID)
public class RollForInitiativeForge {
    public RollForInitiativeForge() {

        RollForInitiative.init();
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::onGatherData);
        RFINetwork.init();

    }

    public void onGatherData(GatherDataEvent e) {
        DataGenerator generator = e.getGenerator();
        ExistingFileHelper existingFileHelper = e.getExistingFileHelper();

        // Resources
        generator.addProvider(e.includeClient(), new LangProviderEnglish(generator));
        generator.addProvider(e.includeClient(), new BlockModelProvider(generator, existingFileHelper));
        generator.addProvider(e.includeClient(), new ItemModelProvider(generator, existingFileHelper));

        TestPartyProvider.createParty();



    }
}