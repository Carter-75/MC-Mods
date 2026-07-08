package com.resoursepackloader;

import com.resoursepackloader.loader.ResourcePackAutoLoader;
import net.fabricmc.api.ClientModInitializer;

public class ResoursePackLoaderClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ResourcePackAutoLoader.init();
	}
}