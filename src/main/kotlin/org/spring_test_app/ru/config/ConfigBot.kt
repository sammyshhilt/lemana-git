package org.spring_test_app.ru.config


import org.spring_test_app.ru.bot.TGBot
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession


@Configuration
class ConfigBot {
    @Bean
    fun telegramBotsApi(bot: TGBot): TelegramBotsApi =
        TelegramBotsApi(DefaultBotSession::class.java).apply {
            registerBot(bot)
        }

}