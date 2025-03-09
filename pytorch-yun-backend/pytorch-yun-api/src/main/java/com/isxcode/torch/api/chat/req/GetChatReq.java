package com.isxcode.torch.api.chat.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class GetChatReq {

    @Schema(title = "回话id", example = "123")
    @NotEmpty(message = "回话id不能为空")
    private String chatId;

    @Schema(title = "回话index", example = "")
    private Integer chatIndex;

}
