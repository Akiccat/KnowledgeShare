package com.akicat.knowledgeshare.controller;

import cn.hutool.http.server.HttpServerResponse;
import com.akicat.knowledgeshare.app.*;
import com.alibaba.fastjson.JSON;
import com.plexpt.chatgpt.ChatGPT;
import com.plexpt.chatgpt.ChatGPTStream;
import com.plexpt.chatgpt.entity.chat.ChatCompletionResponse;
import com.plexpt.chatgpt.entity.chat.Message;

import io.micrometer.core.ipc.http.HttpSender;
import net.dreamlu.mica.http.HttpRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Slf4j
@RestController
@RequestMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
@RequiredArgsConstructor
public class ChatController {
    final KeyManager keyManager;
    static Proxy proxy = Proxy.NO_PROXY;
    private static Map<String, List<Message>> context = new HashMap<>();
    @GetMapping(value = "/chat/sse",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter sseEmitter(@RequestParam("key") String key, String id, String prompt) {
        boolean haskey = !StringUtils.isEmpty(key);
        String APIKEY = keyManager.getKey();

        if (haskey) {
            APIKEY = key;
        }
        ChatGPTStream chatGPTStream = ChatGPTStream.builder()
                .timeout(200)
                .apiKey(APIKEY)
                .proxy(proxy)
                .apiHost("https://api.chatanywhere.com.cn/")
                .build()
                .init();

        SseEmitter sseEmitter = new SseEmitter(-1L);

        GPTEventSourceListener listener = new GPTEventSourceListener(sseEmitter);
        Message message = Message.of(prompt);

        List<Message> messages = get(id);
        messages.add(message);
        listener.setOnComplate(msg -> {
            add(id, message);
            add(id, Message.ofAssistant(msg));

        });
        chatGPTStream.streamChatCompletion(messages, listener);
        return sseEmitter;
    }
    public List<Message> get(String id) {
        List<Message> messages = context.get(id);
        if (messages == null) {
            messages = new ArrayList<>();
            context.put(id, messages);
        }

        return messages;
    }

    public void add(String id, String msg) {

        Message message = Message.builder().content(msg).build();
        add(id, message);
    }

    public void add(String id, Message message) {
        List<Message> messages = context.get(id);
        if (messages == null) {
            messages = new ArrayList<>();
            context.put(id, messages);
        }
        messages.add(message);
    }
}