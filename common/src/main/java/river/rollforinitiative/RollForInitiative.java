package river.rollforinitiative;

import com.mojang.logging.LogUtils;
import org.slf4j.Logger;
import river.rollforinitiative.registry.RFIBlocks;

public class RollForInitiative
{
	public static final String MODID = "rollforinitiative";
	public static final String PLATFORM_ERROR = "Something has gone critically wrong with platform definitions. Please contact the mod author.";

	public static final Logger LOGGER = LogUtils.getLogger();

	public static void init() {

		LOGGER.info("Roll For Initiative starting!");

		RFIBlocks.BLOCKS.register();

		LOGGER.info("Roll For Initiative ready to go!");
	}
}
