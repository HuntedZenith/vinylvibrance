package io.github.huntedzenith.vinylvibrance;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.resources.Identifier;

import net.minecraft.world.item.CreativeModeTabs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VinylVibrance implements ModInitializer {
	public static final String MOD_ID = "vinyl-vibrance";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

		ModItem.initialize();
		ModTrimPatterns.initialize();
		ModLootTables.initialize();

		CreativeModeTabEvents
				.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
				.register(output -> {
					output.accept(ModItem.DREAMS);
					output.accept(ModItem.SAILS);
					output.accept(ModItem.PURPUR);
					output.accept(ModItem.CANNONS);
					output.accept(ModItem.TREASURE);
					output.accept(ModItem.STORM);
				});

		CreativeModeTabEvents
				.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
				.register(output -> {
					output.accept(ModItem.BLANK_MUSIC_DISC);
					output.accept(ModTrimPatterns.RECORD);
					output.accept(ModTrimPatterns.NOTES);
				});
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
