package com.github.waras.discordchatrelay.listener;

import com.github.waras.discordchatrelay.DiscordChatRelayMod;
import com.github.waras.discordchatrelay.config.ModConfig;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.minecraft.network.chat.Component;

public class ChatListener {
	
	public ChatListener() {
		// Register chat event listener
		ClientReceiveMessageEvents.CHAT.register((message, overlay) -> {
			if (!overlay && ModConfig.isEnabled()) {
				handleChatMessage(message, false);
			}
		});
		
		// Register system message listener
		ClientReceiveMessageEvents.GAME.register((message, overlay) -> {
			if (!overlay && ModConfig.isEnabled()) {
				handleChatMessage(message, true);
			}
		});
	}

	private void handleChatMessage(Component message, boolean isSystemMessage) {
		String plainText = message.getString();
		
		// Don't relay empty messages
		if (plainText.trim().isEmpty()) {
			return;
		}
		
		// Extract player name from message if it's a chat message
		String playerName = "Player";
		String messageText = plainText;
		
		if (!isSystemMessage && plainText.contains(": ")) {
			String[] parts = plainText.split(": ", 2);
			playerName = parts[0];
			messageText = parts.length > 1 ? parts[1] : plainText;
		}
		
		// Send to Discord
		DiscordChatRelayMod.getDiscordBot().sendMessage(playerName, messageText, isSystemMessage);
	}
}
