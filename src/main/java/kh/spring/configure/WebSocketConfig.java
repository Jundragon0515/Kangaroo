package kh.spring.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.StompWebSocketEndpointRegistration;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration //설정을 위한 파일 이다
@EnableWebSocketMessageBroker// 중계자 역할을 할것이다.
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {//
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.setApplicationDestinationPrefixes("/app");//채팅 처리할 url 앞에 붙을 url websocket통신이라는걸 표시
		registry.enableSimpleBroker("/response");//응답을 받을 url
		
	}
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		StompWebSocketEndpointRegistration ser=registry.addEndpoint("/gettime");//endpoint(웹소켓이 연결을 처리할 로직) 만들기 설정정보 넣어줘야 한다. 
		ser.setAllowedOrigins("*");
		ser.addInterceptors(new HttpSessionHandshakeInterceptor());
		ser.withSockJS();//
	}
}
