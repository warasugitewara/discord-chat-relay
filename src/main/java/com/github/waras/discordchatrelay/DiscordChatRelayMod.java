package com.github.waras.discordchatrelay;

import com.github.waras.discordchatrelay.config.ModConfig;
import com.github.waras.discordchatrelay.discord.DiscordBot;
import com.github.waras.discordchatrelay.listener.ChatListener;
import com.github.waras.discordchatrelay.hud.DiscordChatRelayHudProvider;

// Full Mod class requires Quilt Loader, which will be available in full build
/*
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class DiscordChatRelayMod implements ModInitializer {
	public static final String MOD_ID = "discord-chat-relay";
	public static final String MOD_NAME = "Discord Chat Relay";
	public static final String VERSION = "1.0.0";

	private static DiscordBot discordBot;
	private static ChatListener chatListener;

	@Override
	public void onInitialize(ModContainer mod) {
		ModConfig.load();
		
		// Initialize Discord bot
		discordBot = new DiscordBot();
		
		// Initialize chat listener
		chatListener = new ChatListener();
		
		// Initialize BetterF3 HUD provider
		DiscordChatRelayHudProvider.initialize();
		
		// Register tick event to handle periodic tasks
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (client.player != null && ModConfig.isEnabled()) {
				discordBot.checkConnection();
			}
		});
		
		System.out.println("[Discord Chat Relay] Mod initialized v" + VERSION);
	}

	public static DiscordBot getDiscordBot() {
		return discordBot;
	}

	public static ChatListener getChatListener() {
		return chatListener;
	}
}
*/

// Stub for CLI build - full implementation requires Quilt Loader
public class DiscordChatRelayMod {
	public static final String MOD_ID = "discord-chat-relay";
	public static final String MOD_NAME = "Discord Chat Relay";
	public static final String VERSION = "1.0.3";

	private static DiscordBot discordBot;
	private static ChatListener chatListener;

	public static void initialize() {
		ModConfig.load();
		discordBot = new DiscordBot();
		chatListener = new ChatListener();
		DiscordChatRelayHudProvider.initialize();
		System.out.println("[Discord Chat Relay] Mod initialized v" + VERSION);
	}

	public static DiscordBot getDiscordBot() {
		return discordBot;
	}

	public static ChatListener getChatListener() {
		return chatListener;
	}
}
