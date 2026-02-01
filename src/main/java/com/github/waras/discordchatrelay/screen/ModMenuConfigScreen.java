package com.github.waras.discordchatrelay.screen;

import com.github.waras.discordchatrelay.config.ModConfig;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class ModMenuConfigScreen implements ModMenuApi {

	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return screen -> createConfigScreen(screen);
	}

	private static Screen createConfigScreen(Screen parent) {
		ConfigBuilder builder = ConfigBuilder.create()
				.setParentScreen(parent)
				.setTitle(Component.literal("Discord Chat Relay Config"));

		ConfigCategory generalCategory = builder.getOrCreateCategory(Component.literal("General"));

		// Enabled toggle
		generalCategory.addEntry(
				builder.entryBuilder()
						.startBooleanToggle(Component.literal("Enabled"), ModConfig.isEnabled())
						.setSaveConsumer(ModConfig::setEnabled)
						.build()
		);

		// Bot Token field
		generalCategory.addEntry(
				builder.entryBuilder()
						.startStrField(Component.literal("Bot Token"), ModConfig.getBotToken())
						.setErrorSupplier(token -> {
							if (!ModConfig.isEnabled() || token.isEmpty()) {
								return java.util.Optional.empty();
							}
							if (token.length() < 50) {
								return java.util.Optional.of(Component.literal("Token seems too short"));
							}
							return java.util.Optional.empty();
						})
						.setSaveConsumer(ModConfig::setBotToken)
						.build()
		);

		// Channel ID field
		generalCategory.addEntry(
				builder.entryBuilder()
						.startStrField(Component.literal("Channel ID"), ModConfig.getChannelId())
						.setErrorSupplier(channelId -> {
							if (!ModConfig.isEnabled() || channelId.isEmpty()) {
								return java.util.Optional.empty();
							}
							try {
								Long.parseLong(channelId);
								return java.util.Optional.empty();
							} catch (NumberFormatException e) {
								return java.util.Optional.of(Component.literal("Invalid Channel ID (must be a number)"));
							}
						})
						.setSaveConsumer(ModConfig::setChannelId)
						.build()
		);

		return builder.build();
	}
}
