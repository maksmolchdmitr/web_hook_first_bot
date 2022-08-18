package maks.molch.dmitr.webhookfirstbot.config;

import maks.molch.dmitr.webhookfirstbot.botconfig.TelegramBotConfig;
import maks.molch.dmitr.webhookfirstbot.model.TelegramBot;
import maks.molch.dmitr.webhookfirstbot.model.TelegramFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

@Configuration
public class AppConfig {
    private final TelegramBotConfig botConfig;

    public AppConfig(TelegramBotConfig botConfig) {
        this.botConfig = botConfig;
    }
    @Bean
    public SetWebhook setWebhookInstance(){
        return SetWebhook.builder().url(botConfig.getWebHookPath()).build();
    }
    @Bean
    public TelegramBot springWebhookBot(SetWebhook setWebhook, TelegramFacade telegramFacade){
        TelegramBot bot = new TelegramBot(telegramFacade, setWebhook);
        bot.setBotPath(botConfig.getWebHookPath());
        bot.setBotToken(botConfig.getBotToken());
        bot.setBotUsername(botConfig.getUserName());
        return bot;
    }
}
