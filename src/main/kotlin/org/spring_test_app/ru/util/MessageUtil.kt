package org.spring_test_app.ru.util


import org.telegram.telegrambots.meta.api.methods.send.SendMessage

fun sendMessage(chatId: String, text: String) =
    SendMessage(chatId, text)
        .apply { enableMarkdown(true) }
        .apply { disableWebPagePreview() }