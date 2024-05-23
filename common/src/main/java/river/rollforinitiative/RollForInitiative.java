package river.rollforinitiative;

import com.mojang.logging.LogUtils;
import org.slf4j.Logger;
import river.rollforinitiative.common.stat.CharacterStats;
import river.rollforinitiative.registry.RFIBlockEntities;
import river.rollforinitiative.registry.RFIBlocks;
import river.rollforinitiative.registry.RFIItems;
import river.rollforinitiative.util.FileWriterUtil;

public class RollForInitiative
{
	public static final String MODID = "rollforinitiative";
	public static final String PLATFORM_ERROR = "Something has gone critically wrong with platform definitions. Please contact the mod author.";

	public static final Logger LOGGER = LogUtils.getLogger();

	public static void init() {

		LOGGER.info("Roll For Initiative starting!");

		RFIItems.TABS.register();
		RFIItems.ITEMS.register();
		RFIBlocks.BLOCKS.register();
		RFIBlockEntities.BLOCK_ENTITY_TYPES.register();

		CharacterStats hex = new CharacterStats("test_hex", "Hex", 30, 30, 16, 6);
		FileWriterUtil.writeCharacter(hex);

		FileWriterUtil.readPartyCharacters();

		LOGGER.info("Roll For Initiative ready to go!");
	}
}
