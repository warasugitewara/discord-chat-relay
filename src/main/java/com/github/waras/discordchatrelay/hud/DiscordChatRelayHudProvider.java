package com.github.waras.discordchatrelay.hud;

import com.github.waras.discordchatrelay.DiscordChatRelayMod;
import com.github.waras.discordchatrelay.config.ModConfig;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.List;

public class DiscordChatRelayHudProvider {
	
	private static boolean betterF3Available = false;

	public static void initialize() {
		try {
			Class.forName("me.cominixo.betterf3.api.HudProviderRegistry");
			registerWithBetterF3();
			betterF3Available = true;
			System.out.println("[Discord Chat Relay] BetterF3 integration enabled");
		} catch (ClassNotFoundException e) {
			System.out.println("[Discord Chat Relay] BetterF3 not found, HUD display disabled");
		}
	}

	private static void registerWithBetterF3() {
		try {
			// Dynamically register with BetterF3 if available
			me.cominixo.betterf3.api.HudProviderRegistry.register(new me.cominixo.betterf3.api.HudProvider() {
				@Override
				public List<Component> getLines(me.cominixo.betterf3.api.Sections section) {
					List<Component> lines = new ArrayList<>();

					// Show in MISC section
					if (section == me.cominixo.betterf3.api.Sections.MISC) {
						lines.add(Component.literal("§e--- Discord Chat Relay ---"));
						
						String statusText = ModConfig.isEnabled() 
							? (DiscordChatRelayMod.getDiscordBot().isConnected() ? "§aConnected" : "§cConnecting...")
							: "§7Disabled";
						lines.add(Component.literal("Status: " + statusText));
						
						String channelDisplay = ModConfig.getChannelId().isEmpty() 
							? "§cNot Set" 
							: "§a" + ModConfig.getChannelId().substring(Math.max(0, ModConfig.getChannelId().length() - 5));
						lines.add(Component.literal("Channel: " + channelDisplay));
					}

					return lines;
				}

				@Override
				public String getName() {
					return "Discord Chat Relay";
				}

				@Override
				public double getPriority() {
					return 100;
				}
			});
		} catch (Exception e) {
			System.out.println("[Discord Chat Relay] Failed to register with BetterF3: " + e.getMessage());
		}
	}

	public static boolean isBetterF3Available() {
		return betterF3Available;
	}
}
