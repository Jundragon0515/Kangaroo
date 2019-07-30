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
		registry.enableSimpleBroker("/response","/board_re1","/board_re2","/board_re3","/board_re4","/board_re5","/board_re6","/board_re7","/board_re8","/board_re9","/board_re10","/response1","/response2","/response3","/response4","/response5","/response6","/response7","/response8","/response9","/response10","/response11","/response12","/response13","/response14","/response15","/response16","/response17","/response18","/response19","/response20","/response21","/response22","/response23","/response24","/response25","/response26","/response27","/response28","/response29","/response30","/response31","/response32","/response33","/response34","/response35","/response36","/response37","/response38","/response39","/response40","/response41","/response42","/response43","/response44","/response45","/response46","/response47","/response48","/response49","/response50","/response51","/response52","/response53","/response54","/response55","/response56","/response57","/response58","/response59","/response60","/response61","/response62","/response63","/response64","/response65","/response66","/response66","/response67","/response68","/response69","/response70","/response71","/response72","/response73","/response74","/response75","/response76","/response77","/response78","/response79","/response80","/response81","/response82","/response83","/response84","/response85","/response86","/response87","/response88","/response89","/response90","/response91","/response92","/response93","/response94","/response95","/response96","/response97","/response98","/response99","/response100","/ten1","/ten2","/ten3","/ten4","/ten5","/ten6","/ten7","/ten8","/ten9","/ten10","/ten11","/ten12","/ten13","/ten14","/ten15","/ten16","/ten17","/ten18","/ten19","/ten20","/ten21","/ten22","/ten23","/ten24","/ten25","/ten26","/ten27","/ten28","/ten29","/ten30","/ten31","/ten32","/ten33","/ten34","/ten35","/ten36","/ten37","/ten38","/ten39","/ten40","/ten41","/ten42","/ten43","/ten43","/ten44","/ten45","/ten46","/ten47","/ten48","/ten49","/ten50","/ten50","/ten51","/ten52","/ten53","/ten54","/ten55","/ten56","/ten57","/ten58","/ten59","/ten60","/ten61","/ten62","/ten63","/ten64","/ten65","/ten66","/ten67","/ten68","/ten69","/ten70","/ten71","/ten72","/ten73","/ten74","/ten75","/ten76","/ten77","/ten78","/ten79","/ten80","/ten81","/ten82","/ten83","/ten84","/ten85","/ten86","/ten87","/ten88","/ten89","/ten90","/ten91","/ten92","/ten93","/ten94","/ten95","/ten96","/ten97","/ten98","/ten99","/ten100");//응답을 받을 url
		
	}
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		StompWebSocketEndpointRegistration ser=registry.addEndpoint("/gettime");//endpoint(웹소켓이 연결을 처리할 로직) 만들기 설정정보 넣어줘야 한다. 
		ser.setAllowedOrigins("*");
		ser.addInterceptors(new HttpSessionHandshakeInterceptor());
		ser.withSockJS();//
	}
}
