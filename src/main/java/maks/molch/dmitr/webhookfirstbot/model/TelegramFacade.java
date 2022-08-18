package maks.molch.dmitr.webhookfirstbot.model;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
@Component
public class TelegramFacade {
    public BotApiMethod<?> handlerUpdate(Update update) {
        if(update.hasCallbackQuery()){
            CallbackQuery callbackQuery = update.getCallbackQuery();
            System.out.println("Callback and null");
            return null;
        }else{
            Message message = update.getMessage();
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(String.valueOf(message.getChatId()));
            if(message.hasText()){
                System.out.println("Text: "+message.getText());
                sendMessage.setText("Hello, hi!");
                return sendMessage;
            }
        }
        System.out.println("Null");
        return null;
    }
}
