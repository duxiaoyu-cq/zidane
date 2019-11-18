package com.dxy.zidane.common.web.websocket;


import com.alibaba.fastjson.JSONObject;
import org.springframework.web.socket.*;

import java.util.HashMap;
import java.util.Map;


public class MyHandler implements WebSocketHandler {

    //在线用户列表
    private static final Map<String, WebSocketSession> usersSocketMap;

    static {
        usersSocketMap = new HashMap<>();
    }

    //新增socket
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String userId = session.getUri().toString().split("ID=")[1];
        System.out.println("又来了一个：" + userId);
        if (userId != null) {
            usersSocketMap.put(userId, session);
            session.sendMessage(new TextMessage("成功建立socket连接"));
        }
        System.out.println("当前在线人数：" + usersSocketMap.size());
    }

    //接收socket信息
    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        JSONObject jsonobject = JSONObject.parseObject((String) webSocketMessage.getPayload());
        String clientId = jsonobject.getString("id");
        String message = jsonobject.getString("message");
//            System.out.println(jsonobject.get("message") + ":来自" + (String) webSocketSession.getAttributes().get("WEBSOCKET_USERID") + "的消息");
        if (usersSocketMap.get(clientId) != null) {
            WebSocketSession session = usersSocketMap.get(clientId);
//            System.out.println("sendMessage:" + session);
            if (session.isOpen()) {
                session.sendMessage(new TextMessage("老子不是" + message + ", 我是白云."));
            }
        }
    }


    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
//        if (session.isOpen()) {
//            session.close();
//        }
        System.out.println("连接出错");
        usersSocketMap.remove(getClientId(session));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("连接已关闭：" + status);
        usersSocketMap.remove(getClientId(session));
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 获取用户标识
     *
     * @param session
     * @return
     */
    private Integer getClientId(WebSocketSession session) {
        try {
            Integer clientId = (Integer) session.getAttributes().get("WEBSOCKET_USERID");
            return clientId;
        } catch (Exception e) {
            return null;
        }
    }

}