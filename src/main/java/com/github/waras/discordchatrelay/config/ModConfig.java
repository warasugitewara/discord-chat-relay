package com.github.waras.discordchatrelay.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ModConfig {
	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	private static final String CONFIG_DIR = "config";
	private static final String CONFIG_FILE = CONFIG_DIR + File.separator + "discord-chat-relay.json";

	private static ConfigData config = new ConfigData();

	public static void load() {
		try {
			File file = new File(CONFIG_FILE);
			if (file.exists()) {
				try (FileReader reader = new FileReader(file)) {
					config = GSON.fromJson(reader, ConfigData.class);
				}
			} else {
				save();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void save() {
		try {
			Files.createDirectories(Paths.get(CONFIG_DIR));
			try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
				GSON.toJson(config, writer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getBotToken() {
		return config.botToken != null ? config.botToken : "";
	}

	public static void setBotToken(String token) {
		config.botToken = token;
		save();
	}

	public static String getChannelId() {
		return config.channelId != null ? config.channelId : "";
	}

	public static void setChannelId(String channelId) {
		config.channelId = channelId;
		save();
	}

	public static boolean isEnabled() {
		return config.enabled;
	}

	public static void setEnabled(boolean enabled) {
		config.enabled = enabled;
		save();
	}

	public static class ConfigData {
		public String botToken = "";
		public String channelId = "";
		public boolean enabled = false;
	}
}
