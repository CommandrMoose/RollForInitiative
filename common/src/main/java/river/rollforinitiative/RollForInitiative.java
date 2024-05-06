package river.rollforinitiative;

import com.mojang.logging.LogUtils;
import org.slf4j.Logger;
import river.rollforinitiative.network.RFINetwork;
import river.rollforinitiative.registry.RFIBlockEntities;
import river.rollforinitiative.registry.RFIBlocks;
import river.rollforinitiative.registry.RFIItems;

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
		RFINetwork.init();
		RFIBlockEntities.BLOCK_ENTITY_TYPES.register();


		LOGGER.info("Roll For Initiative ready to go!");
	}
}
