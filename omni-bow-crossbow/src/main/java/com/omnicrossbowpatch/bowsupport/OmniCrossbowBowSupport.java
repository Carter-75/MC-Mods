package com.omnicrossbowpatch.bowsupport;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OmniCrossbowBowSupport implements ModInitializer {
	public static final String MOD_ID = "omnicrossbow-bow-support";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("OmniCrossbow bow support loaded");
	}
}
