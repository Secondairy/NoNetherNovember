package me.secondairy.nonethernovember;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class nonethernovember implements ModInitializer {

    public static final Logger LOGGER = LogManager.getLogger("NoNetherNovember");

    @Override
    public void onInitialize() {
        nonethernovember.LOGGER.info("NoNetherNovember has started!");
    }
}
