package com.team1.controller.safetySocket;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.ScheduledFuture;

@Component
@EnableScheduling
public class SafetySocket extends TextWebSocketHandler implements DisposableBean{


    private List<WebSocketSession> 접속명단 = new Vector<>(); // 동기화 떄문에 벡터 사용

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("session = " + session);
        //1.접속한 세션정보를 리스트에 담기
        접속명단.add(session);
        System.out.println("접속명단 = " + 접속명단);

    }


    @Autowired
    private TaskScheduler taskScheduler;

    private ScheduledFuture<?> scheduledFuture;

    @PostConstruct
    public void initialize() {
        startScheduler();
    }

    public void startScheduler() {
        scheduledFuture = taskScheduler.scheduleAtFixedRate(this::doPost, 10000);
    }

    public void stopScheduler() {
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }
    @Override
    public void destroy() throws Exception {
        stopScheduler();
    } //

    //스케쥴러 안쓰기해볼때용

    public void doPost() {
        try {
            WebSocketMessage<String> sendmessage = new TextMessage((int)(Math.random()*100)+"");
            for (WebSocketSession webSocketSession : 접속명단) {
                webSocketSession.sendMessage(sendmessage);
            }
            System.out.println(sendmessage);
        }
        catch (Exception e ){
            System.out.println(e);
        }
    }


    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        접속명단.remove(session);
    }

}
