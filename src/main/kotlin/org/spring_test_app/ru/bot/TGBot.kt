package org.spring_test_app.ru.bot
import org.spring_test_app.ru.bot.commands.StartCommand
import org.spring_test_app.ru.util.sendMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand
import org.telegram.telegrambots.meta.api.objects.Update
//import org.telegram.telegrambots.meta.api.objects.commands.BotCommand

@Service
class TGBot(
    @Autowired private val startCommand: StartCommand,
    commands: Set<BotCommand>,
    @Value("\${bot.token}")
    token: String) : TelegramLongPollingBot(token) {

    init {
        registerAll(*commands.toTypedArray())
    }

    @Value("\${bot.name}")
    private val botUsername: String? = null

    @Value("\${bot.token}")
    private val botToken: String? = null



    override fun getBotUsername(): String? {
        return botUsername
    }

    override fun onUpdateReceived(update: Update) {
        if (update.hasMessage() && update.message.hasText()) {
            val chatId = update.message.chatId
            val text = update.message.text

            if (text == "/start") {
                execute(sendMessage(chatId.toString(), "Hey"))
            } else {
                execute(sendMessage(chatId.toString(), "I don't understand("))
            }
        }
    }




    fun processNonCommandUpdate(update: Update) {
        if (update.hasMessage()) {
            val chatId = update.message.chatId.toString()
            if (update.message.hasText()) {
                execute(sendMessage(chatId.toString(), "Вы написали: *${update.message.text}*"))
            } else {
                execute(sendMessage(chatId.toString(), "Я понимаю только текст!"))
            }
        }
    }}
//
//    fun createMessage(chatId: String, text: String) =
//        SendMessage(chatId, text)
//            .apply { enableMarkdown(true) }
//            .apply { disableWebPagePreview() }
//
//}