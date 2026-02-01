package com.github.waras.discordchatrelay.command;

import com.github.waras.discordchatrelay.config.ModConfig;
import com.github.waras.discordchatrelay.discord.DiscordBot;
import com.github.waras.discordchatrelay.DiscordChatRelayMod;

/**
 * Handles /dcr command for configuration
 * Commands:
 * - /dcr token <token>     Set Discord bot token
 * - /dcr channel <id>      Set Discord channel ID
 * - /dcr toggle            Toggle ON/OFF
 * - /dcr status            Show current status
 * - /dcr reload            Reload configuration
 */
public class DiscordChatRelayCommand {
    
    public static boolean handleCommand(String message) {
        if (!message.startsWith("/dcr")) {
            return false;
        }
        
        String[] args = message.trim().split("\\s+");
        if (args.length < 2) {
            sendFeedback("§c/dcr <token|channel|toggle|status|reload> [args]");
            return true;
        }
        
        String subcommand = args[1].toLowerCase();
        
        switch (subcommand) {
            case "token":
                if (args.length < 3) {
                    sendFeedback("§c使用方法: /dcr token <bot_token>");
                    return true;
                }
                setToken(args[2]);
                break;
                
            case "channel":
                if (args.length < 3) {
                    sendFeedback("§c使用方法: /dcr channel <channel_id>");
                    return true;
                }
                setChannel(args[2]);
                break;
                
            case "toggle":
                toggleEnabled();
                break;
                
            case "status":
                showStatus();
                break;
                
            case "reload":
                reloadConfig();
                break;
                
            default:
                sendFeedback("§c不明なコマンド: " + subcommand);
                return true;
        }
        
        return true;
    }
    
    private static void setToken(String token) {
        if (token == null || token.isEmpty() || token.length() < 10) {
            sendFeedback("§cボットトークンが無効です");
            return;
        }
        
        ModConfig.setBotToken(token);
        ModConfig.save();
        sendFeedback("§aボットトークンを設定しました");
        
        // Reconnect with new token
        DiscordBot bot = DiscordChatRelayMod.getDiscordBot();
        if (bot != null) {
            bot.disconnect();
            bot.connect(token, ModConfig.getChannelId());
        }
    }
    
    private static void setChannel(String channelId) {
        if (channelId == null || channelId.isEmpty()) {
            sendFeedback("§cチャンネルIDが無効です");
            return;
        }
        
        try {
            Long.parseLong(channelId); // Validate it's a number
        } catch (NumberFormatException e) {
            sendFeedback("§cチャンネルIDは数値である必要があります");
            return;
        }
        
        ModConfig.setChannelId(channelId);
        ModConfig.save();
        sendFeedback("§aチャンネルIDを設定しました: " + channelId);
    }
    
    private static void toggleEnabled() {
        boolean newState = !ModConfig.isEnabled();
        ModConfig.setEnabled(newState);
        ModConfig.save();
        
        String state = newState ? "§a有効" : "§c無効";
        sendFeedback("§eDiscord Chat Relay: " + state);
    }
    
    private static void showStatus() {
        StringBuilder status = new StringBuilder();
        status.append("§6=== Discord Chat Relay Status ===\n");
        status.append("§b状態: ").append(ModConfig.isEnabled() ? "§a有効" : "§c無効").append("\n");
        
        DiscordBot bot = DiscordChatRelayMod.getDiscordBot();
        if (bot != null) {
            boolean connected = bot.isConnected();
            status.append("§b接続状態: ").append(connected ? "§a接続中" : "§c切断").append("\n");
        }
        
        String channelId = ModConfig.getChannelId();
        if (channelId != null && !channelId.isEmpty()) {
            status.append("§bチャンネルID: ").append(maskChannelId(channelId)).append("\n");
        }
        
        sendFeedback(status.toString());
    }
    
    private static void reloadConfig() {
        ModConfig.load();
        sendFeedback("§aコンフィグをリロードしました");
    }
    
    private static String maskChannelId(String channelId) {
        if (channelId.length() <= 5) {
            return "***" + channelId;
        }
        String suffix = channelId.substring(channelId.length() - 5);
        return "***" + suffix;
    }
    
    private static void sendFeedback(String message) {
        // Stub - actual implementation requires Minecraft client
        System.out.println("[DCR Command] " + message.replaceAll("§[a-f0-9]", ""));
    }
}
