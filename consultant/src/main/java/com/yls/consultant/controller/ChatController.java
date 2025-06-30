package com.yls.consultant.controller;

import com.yls.consultant.aiservice.ConsultantService;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ChatController {

    @Autowired
    private ConsultantService consultantService;

    @RequestMapping(value = "/chat",produces = "text/html;charset=utf-8")
    public Flux<String> chat(String memoryId,String message){
        Flux<String> result = consultantService.chat(memoryId,message);
        return result;
    }

//    @RequestMapping("/chat")
//    public String chat(String message){
//        String result = consultantService.chat(message);
//        return result;
//    }
            
            

//    @Autowired
//    private OpenAiChatModel openAiChatModel;
//
//    @RequestMapping("/chat")
//    public String chat(String message){ //浏览器传递的用户的问题
//        String result = openAiChatModel.chat(message);
//
//        return result;
//    }

}
