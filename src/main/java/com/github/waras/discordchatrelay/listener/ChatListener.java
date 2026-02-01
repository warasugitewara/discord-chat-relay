package com.github.waras.discordchatrelay.listener;

import com.github.waras.discordchatrelay.DiscordChatRelayMod;
import com.github.waras.discordchatrelay.config.ModConfig;
import com.github.waras.discordchatrelay.command.DiscordChatRelayCommand;

// Fabric API dependencies only available in full build
/*
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.minecraft.network.chat.Component;

public class ChatListener {
	
	public ChatListener() {
		// Register chat event listener
		ClientReceiveMessageEvents.CHAT.register((message, overlay) -> {
			if (!overlay && ModConfig.isEnabled()) {
				String plainText = message.getString();
				
				// Check for /dcr command
				if (plainText.startsWith("/dcr")) {
					DiscordChatRelayCommand.handleCommand(plainText);
					return;
				}
				
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
*/

// Stub implementation with command handling
public class ChatListener {
	public ChatListener() {
		// Stub - requires Fabric API for full implementation
	}
	
	public static boolean processCommand(String message) {
		return DiscordChatRelayCommand.handleCommand(message);
	}
}
