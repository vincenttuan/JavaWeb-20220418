package websocket;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websockettest")
public class WebSocketEndpointTest {
    // 用來存放WebSocket已連接的Socket
    static CopyOnWriteArraySet<Session> sessions;
    static {
    	if (sessions == null) {
            sessions = new CopyOnWriteArraySet<Session>();
        }
    }
    @OnOpen
    public void onOpen(Session session) {
        //紀錄連接到sessions中
        System.out.println("有連線進來: " + session.getId());
        sessions.add(session);
        System.out.println("目前連線數量: " + sessions.size());
    }
    
    @OnMessage
    public void onMessage(String message, Session session) throws IOException,
            InterruptedException, EncodeException {
    	System.out.println(session.getId() + " 說: " + message);
    	// 廣播
    	for(Session s : sessions) {
    		if(s.isOpen()) {
    			s.getAsyncRemote().sendText(message);
    		}
    	}
    }
    
    @OnClose
    public void onClose(Session session) {
        System.out.println("關閉連線: " + session.getId());
        sessions.remove(session); 
        System.out.println("目前連線數量: " + sessions.size());
    }
}
