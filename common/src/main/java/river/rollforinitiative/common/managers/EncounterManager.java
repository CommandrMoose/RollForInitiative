package river.rollforinitiative.common.managers;

import net.minecraft.network.chat.Component;
import river.rollforinitiative.common.blockentity.EncounterManagerBlockEntity;
import river.rollforinitiative.common.capability.RFIWorldComponent;
import river.rollforinitiative.common.stat.CharacterStats;
import river.rollforinitiative.util.PlayerUtil;

import java.util.List;

public class EncounterManager {

    private RFIWorldComponent worldComponent;
    private EncounterManagerBlockEntity encounterManagerBlockEntity;

    private List<CharacterStats> charactersInEncounter;

    private int encounterIndex = 0;
    private CharacterStats currentCharacter;

    public EncounterManager(RFIWorldComponent worldComponent) {
        this.worldComponent = worldComponent;
    }

    public void setEncounterManagerBlockEntity(EncounterManagerBlockEntity encounter) {
        encounterManagerBlockEntity = encounter;
    }

    public void start() {
        System.out.println("ENCOUNTER STARTED");
        PlayerUtil.globalMessage(Component.translatable("Encounter Started"), encounterManagerBlockEntity.getLevel().getServer());
        this.charactersInEncounter = encounterManagerBlockEntity.getCharactersInInitiative();
        this.encounterIndex = 0;

        advanceInitiative();
    }

    public void advanceInitiative() {

        this.encounterIndex += 1;
        if (this.encounterIndex >= this.charactersInEncounter.size()) {
            this.encounterIndex = 0;
        }

        CharacterStats nextCharacter = charactersInEncounter.get(this.encounterIndex);

        String nextCharacterName = nextCharacter.getName();
        this.currentCharacter = nextCharacter;
        PlayerUtil.globalMessage(Component.translatable("Next in encounter: ").append(nextCharacterName), encounterManagerBlockEntity.getLevel().getServer());

    }


}
