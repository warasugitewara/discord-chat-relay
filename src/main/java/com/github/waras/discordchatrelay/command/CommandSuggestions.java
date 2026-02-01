package com.github.waras.discordchatrelay.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides command completion/suggestions for /dcr command
 * Used for tab-completion in chat
 */
public class CommandSuggestions {
    
    public static List<String> getMainSuggestions() {
        List<String> suggestions = new ArrayList<>();
        suggestions.add("token");
        suggestions.add("channel");
        suggestions.add("toggle");
        suggestions.add("status");
        suggestions.add("reload");
        return suggestions;
    }
    
    public static List<String> getSuggestions(String input) {
        String[] parts = input.trim().split("\\s+");
        
        if (parts.length == 1) {
            // Suggest main commands
            return getMainSuggestions();
        }
        
        if (parts.length >= 2) {
            String subcommand = parts[1].toLowerCase();
            
            switch (subcommand) {
                case "token":
                    return getSuggestions_Token(parts);
                case "channel":
                    return getSuggestions_Channel(parts);
                case "toggle":
                    return new ArrayList<>(); // No further args
                case "status":
                    return new ArrayList<>(); // No further args
                case "reload":
                    return new ArrayList<>(); // No further args
            }
        }
        
        return new ArrayList<>();
    }
    
    private static List<String> getSuggestions_Token(String[] parts) {
        List<String> suggestions = new ArrayList<>();
        if (parts.length == 2) {
            suggestions.add("<bot_token>");
            suggestions.add("例: /dcr token YOUR_DISCORD_BOT_TOKEN");
        }
        return suggestions;
    }
    
    private static List<String> getSuggestions_Channel(String[] parts) {
        List<String> suggestions = new ArrayList<>();
        if (parts.length == 2) {
            suggestions.add("<channel_id>");
            suggestions.add("例: /dcr channel 1234567890");
        }
        return suggestions;
    }
}
