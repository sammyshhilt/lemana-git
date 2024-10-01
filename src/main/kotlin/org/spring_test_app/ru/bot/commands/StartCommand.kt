package org.spring_test_app.ru.bot.commands


import org.spring_test_app.ru.model.CommandName
import org.spring_test_app.ru.util.sendMessage
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Chat
import org.telegram.telegrambots.meta.api.objects.User
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand
import org.telegram.telegrambots.meta.bots.AbsSender

@Component
class StartCommand : BotCommand(CommandName.START.text, "") {

    fun execute(absSender: AbsSender, user: User, chat: Chat, arguments: Array<out String>) {
        absSender.execute(sendMessage(chat.id.toString(), "Добро пожаловать!"))
    }
}
