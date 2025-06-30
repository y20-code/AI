package com.yls.consultant.aiservice;


import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import reactor.core.publisher.Flux;

@AiService(
    wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "openAiChatModel",
        streamingChatModel = "openAiStreamingChatModel",
        chatMemory = "chatMemory", //配置会话记忆对象
        chatMemoryProvider = "chatMemoryProvider"  //配置会话记忆提供者对象
)
public interface ConsultantService {


//    @SystemMessage("你是高考填报志愿助手")
    @SystemMessage(fromResource = "system.txt")
//    @UserMessage("你是高考填报志愿助手！{{it}}")
    public Flux<String> chat(@MemoryId String memoryId, @UserMessage String message);
}
