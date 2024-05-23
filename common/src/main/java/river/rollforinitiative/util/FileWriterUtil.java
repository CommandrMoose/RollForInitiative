package river.rollforinitiative.util;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import river.rollforinitiative.RollForInitiative;
import river.rollforinitiative.common.data.StatRepository;
import river.rollforinitiative.common.stat.CharacterStats;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileWriterUtil {

    private static Gson gson = new Gson();
    private static String MAIN_DIRECTORY = "./rollforinitiative/";

    public static void writeCharacter(CharacterStats characterStats) {

        try {

            FileWriter file = new FileWriter(MAIN_DIRECTORY + "party/" + characterStats.getId() + ".json");

            String characterJson = gson.toJson(characterStats);

            file.write(characterJson);
            file.flush();
            file.close();
            RollForInitiative.LOGGER.info("Written " + characterStats.getId() + " to file.");

        } catch (Exception exception) {
            RollForInitiative.LOGGER.error("ERROR: Could not write character " + characterStats.getId());
        }

    }

    public static void readPartyCharacters() {

        File partyFolder = new File(MAIN_DIRECTORY + "party/");
        File[] listOfFiles = partyFolder.listFiles();

        RollForInitiative.LOGGER.info("Attempting to read characters from the following location " + partyFolder.getAbsolutePath());

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().contains(".json")) {

                    try(FileInputStream inputStream = new FileInputStream(file)) {
                        String characterContent = IOUtils.toString(inputStream);
                        CharacterStats characterStats = gson.fromJson(characterContent, CharacterStats.class);

                        StatRepository.addPartyCharacter(characterStats);

                        RollForInitiative.LOGGER.info("Found " + characterStats.getId());

                    }catch (Exception ex) {
                        RollForInitiative.LOGGER.error("ERROR: Could not read file " + file.getName());
                    }
                }
            }
        }

        RollForInitiative.LOGGER.info("Found and read " + StatRepository.getPartyCharacterStats().size() + " characters.");
    }

}
