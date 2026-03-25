package com.jarurat.chatbot;

import com.jarurat.chatbot.model.ChatbotResponse;
import com.jarurat.chatbot.model.IncomingMessage;
import com.jarurat.chatbot.service.ChatbotService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChatbotServiceTest {

    @Autowired
    private ChatbotService chatbotService;

    @BeforeEach
    void setUp() {
        chatbotService.clearLogs();
    }

    @Test
    void testHiMessage_shouldReturnHello() {
        IncomingMessage msg = new IncomingMessage("+919876543210", "Hi", "2024-01-15T10:00:00");
        ChatbotResponse response = chatbotService.processMessage(msg);

        assertEquals("success", response.getStatus());
        assertTrue(response.getReply().toLowerCase().contains("hello"));
    }

    @Test
    void testByeMessage_shouldReturnGoodbye() {
        IncomingMessage msg = new IncomingMessage("+919876543210", "Bye", "2024-01-15T10:05:00");
        ChatbotResponse response = chatbotService.processMessage(msg);

        assertEquals("success", response.getStatus());
        assertTrue(response.getReply().toLowerCase().contains("goodbye"));
    }

    @Test
    void testUnknownMessage_shouldReturnUnrecognized() {
        IncomingMessage msg = new IncomingMessage("+919876543210", "random stuff", "2024-01-15T10:10:00");
        ChatbotResponse response = chatbotService.processMessage(msg);

        assertEquals("unrecognized", response.getStatus());
    }

    @Test
    void testLogging_shouldLogMessages() {
        chatbotService.processMessage(new IncomingMessage("+911111111111", "Hi", null));
        chatbotService.processMessage(new IncomingMessage("+922222222222", "Bye", null));

        assertEquals(2, chatbotService.getAllLogs().size());
    }

    @Test
    void testCaseInsensitivity_hiLowerCase() {
        IncomingMessage msg = new IncomingMessage("+919876543210", "hi", null);
        ChatbotResponse response = chatbotService.processMessage(msg);
        assertEquals("success", response.getStatus());
    }
}
