package river.rollforinitiative.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import net.neoforged.neoforge.common.data.LanguageProvider;
import river.rollforinitiative.RollForInitiative;
import river.rollforinitiative.contants.RFILocalization;
import river.rollforinitiative.registry.RFIBlocks;
import river.rollforinitiative.registry.RFIItems;

public class LangProviderEnglish extends LanguageProvider {


    public LangProviderEnglish(DataGenerator gen) {
        super(gen.getPackOutput(), RollForInitiative.MODID, "en_us");
    }

    public void add(ResourceKey<DamageType> damageSource, String message) {
        add("death.attack." + damageSource.location().getPath(), message);
        add("death.attack." + damageSource.location().getPath() + ".player", message);
    }

    @Override
    protected void addTranslations() {
        add(RFILocalization.GAME_MASTER_TAB, "RFI: Game Master");
        add(RFILocalization.PLAYER_TAB, "RFI: Common");
        add(RFILocalization.ENCOUNTER_LINKED, "Linked to Encounter Manager");

        add(RFIBlocks.ENCOUNTER_MANAGER.get(), "Encounter Manager");
        add(RFIItems.CHARACTER_SHEET.get(), "Character Sheet");
        add(RFIItems.GAME_MASTER_SCREEN.get(), "Game Master Screen");


    }
}
