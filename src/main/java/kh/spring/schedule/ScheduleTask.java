package kh.spring.schedule;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kh.spring.dao.AdminDAO;
import kh.spring.project.HomeController;

@Component
public class ScheduleTask {
	
	@Autowired
	private AdminDAO dao;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
	
	// return, 인자 값을 다룰 수 없음.
	//@Scheduled(fixedRate=5000)	// 첫 번째 동작이 안 끝나도 설정된 초가 지나면 실행됨.	
	//@Scheduled(fixedDelay=5000)	// 첫 번째 동작이 안 끝나면 설정된 초가 지나도 실행이 안 됨.
	
	// @Scheduled(cron="30 59 23 * * * *")	
	@Scheduled(cron="1/10 * * * * *")		// "/" : 매 타임 마다    "A,B" : A와 B에 	"A-B" : A~B까지
	public void everyMidNight() {
		dao.insertVisitCount();
		HomeController.visitCount = 0;
		
		System.out.println(sdf.format(System.currentTimeMillis()) + 
				" : 방문자 수 초기화 확인 " + HomeController.visitCount + "명");
	}
	
}
