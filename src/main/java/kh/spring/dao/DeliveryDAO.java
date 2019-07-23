package kh.spring.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kh.spring.dto.DeliveryDTO;

@Component
public class DeliveryDAO {
	@Autowired
	private SqlSessionTemplate sst;
	public int deli_insert(DeliveryDTO dto) { // 회원가입 
        return sst.insert("DeliveryDAO.deli_insert",dto);
     }
	public String lookup(String t_code,String t_invoice) throws IOException  {
		String apiURL = "http://info.sweettracker.co.kr/api/v1/trackingInfo?";
		apiURL += "t_key=Cmkzno9RMqEun5CbgAvSgA"  ;
		apiURL += "&t_code=" + t_code;
		apiURL += "&t_invoice=" + t_invoice;
		
		URL url = new URL(apiURL);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		BufferedReader br;
		if(responseCode==200) { // 정상 호출
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else {  // 에러 발생
			br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		String inputLine;
		StringBuffer res = new StringBuffer();
		while ((inputLine = br.readLine()) != null) {
			res.append(inputLine);
		}
		br.close();
		System.out.println(responseCode);
		if(responseCode==200) {
			return res.toString();
		}
		else
			return null;
	}
	public DeliveryDTO selectByNum(int num) {
		return sst.selectOne("DeliveryDAO.selectByNum", num);
	}
}
