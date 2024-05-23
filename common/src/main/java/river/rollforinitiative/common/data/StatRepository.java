package river.rollforinitiative.common.data;

import river.rollforinitiative.common.stat.CharacterStats;

import java.util.ArrayList;

public class StatRepository {

    private static final ArrayList<CharacterStats> partyCharacterStats = new ArrayList<>();

    public static void addPartyCharacter(CharacterStats partyMember) {
        partyCharacterStats.add(partyMember);
    }

    public static ArrayList<CharacterStats> getPartyCharacterStats() {
        return partyCharacterStats;
    }

}
