package com.isxcode.torch.modules.app.bot;

import com.isxcode.torch.api.ai.dto.AuthConfig;
import com.isxcode.torch.api.chat.dto.ChatContent;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class BotChatContext {

    private String prompt;

    private AuthConfig authConfig;

    private Integer nowChatIndex;

    private String chatId;

    private List<ChatContent> chats;
}
