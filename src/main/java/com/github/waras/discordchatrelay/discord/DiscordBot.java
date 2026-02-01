package com.github.waras.discordchatrelay.discord;

import com.github.waras.discordchatrelay.config.ModConfig;
import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.entity.channel.TextChannel;
import discord4j.rest.util.Color;
import discord4j.core.spec.EmbedCreateSpec;
import reactor.core.publisher.Mono;

public class DiscordBot {
	private GatewayDiscordClient client;
	private boolean isConnected = false;
	private long lastReconnectAttempt = 0;
	private static final long RECONNECT_COOLDOWN = 30000; // 30 seconds

	public void connect() {
		if (isConnected || ModConfig.getBotToken().isEmpty()) {
			return;
		}

		long now = System.currentTimeMillis();
		if (now - lastReconnectAttempt < RECONNECT_COOLDOWN) {
			return;
		}

		lastReconnectAttempt = now;

		try {
			DiscordClient discordClient = DiscordClient.create(ModConfig.getBotToken());
			client = discordClient.login().block();
			
			if (client != null) {
				isConnected = true;
				System.out.println("[Discord Chat Relay] Connected to Discord!");
			}
		} catch (Exception e) {
			System.out.println("[Discord Chat Relay] Failed to connect to Discord: " + e.getMessage());
		}
	}

	public void disconnect() {
		if (client != null) {
			client.logout().block();
			client = null;
			isConnected = false;
		}
	}

	public void sendMessage(String playerName, String message, boolean isSystemMessage) {
		if (!isConnected || ModConfig.getChannelId().isEmpty()) {
			return;
		}

		try {
			long channelId = Long.parseLong(ModConfig.getChannelId());
			TextChannel channel = client.getChannelById(discord4j.common.util.Snowflake.of(channelId))
					.ofType(TextChannel.class)
					.block();

			if (channel != null) {
				String displayName = isSystemMessage ? "[SYSTEM]" : playerName;
				String messageContent = displayName + ": " + message;
				
				if (messageContent.length() > 2000) {
					messageContent = messageContent.substring(0, 1997) + "...";
				}
				
				channel.createMessage(messageContent).subscribe();
			}
		} catch (NumberFormatException e) {
			System.out.println("[Discord Chat Relay] Invalid Channel ID: " + ModConfig.getChannelId());
		} catch (Exception e) {
			System.out.println("[Discord Chat Relay] Failed to send message: " + e.getMessage());
		}
	}

	public void checkConnection() {
		if (ModConfig.isEnabled() && !isConnected) {
			connect();
		} else if (!ModConfig.isEnabled() && isConnected) {
			disconnect();
		}
	}

	public boolean isConnected() {
		return isConnected;
	}
}
