package bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class MyBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {

    }

    @Override
    public String getBotUsername() {
        return "https://t.me/ElyorAzimovBlog_bot";
    }

    @Override
    public String getBotToken() {
        return "5841198405:AAF43I4ynTbEXdVxmyqKK6m6FlT7PHvUqEQ";
    }


}
