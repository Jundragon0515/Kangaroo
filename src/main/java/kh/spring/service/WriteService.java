package kh.spring.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kh.spring.dao.BoardDAO;
import kh.spring.dto.Auction_boardDTO;
import kh.spring.dto.Auction_img_boardDTO;
import kh.spring.dto.Used_transaction_boardDTO;
import kh.spring.dto.Used_transaction_img_boardDTO;

@Component
public class WriteService {
	
	@Autowired
	private BoardDAO bdao;
	@Autowired
	private HttpSession session;
	
	@Transactional("txManager")
	public void goodsInsert(MultipartHttpServletRequest mtfRequest,Used_transaction_boardDTO dto,Used_transaction_img_boardDTO udto)throws Exception{
		String uploadPath = session.getServletContext().getRealPath("/resources/img/middle");
		System.out.println("asd"+udto.getMiddle2_img());
		List<MultipartFile> fileList = mtfRequest.getFiles("file");
		System.out.println(uploadPath);
		int a =1;
		for (MultipartFile mf : fileList) {
			String originFileName = mf.getOriginalFilename(); // 원본 파일 명
			long fileSize = mf.getSize(); // 파일 사이즈
			System.out.println("originFileName : " + originFileName);
			System.out.println("fileSize : " + fileSize);
			
			String newName = System.currentTimeMillis()+"a.png";
			String safeFile = uploadPath+"/"+newName;
			if(a==1) {
			udto.setMiddle1_img(newName);
			a++;
			}else if(a==2) {
				udto.setMiddle2_img(newName);
				a++;
			}else if(a==3) {
				udto.setMiddle3_img(newName);
				a++;
			}else if(a==4) {
				udto.setMiddle4_img(newName);
				a++;
			}else if(a==5) {
				udto.setMiddle5_img(newName);
				a++;
			}else if(a==6) {
				udto.setMiddle6_img(newName);
				a++;
			}else if(a==7) {
				udto.setMiddle7_img(newName);
				a++;
			}else if(a==8) {
				udto.setMiddle8_img(newName);
				a++;
			}else if(a==9) {
				udto.setMiddle9_img(newName);
				a++;
			}else if(a==10) {
				udto.setMiddle10_img(newName);
				a++;
			}else {
				System.out.println("a");
			}
			try {
				mf.transferTo(new File(safeFile));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		bdao.writeInsert(dto);
		bdao.imgInsert(udto);
	}
	
	@Transactional("txManager")
	public void actionInsert(MultipartHttpServletRequest mtfRequest,Auction_boardDTO adto , Auction_img_boardDTO idto)throws Exception{
		String uploadPath = session.getServletContext().getRealPath("/resources/img/middle");
		List<MultipartFile> fileList = mtfRequest.getFiles("file");
		System.out.println(uploadPath);
		int a =1;
		for (MultipartFile mf : fileList) {
			String originFileName = mf.getOriginalFilename(); // 원본 파일 명
			long fileSize = mf.getSize(); // 파일 사이즈
			System.out.println("originFileName : " + originFileName);
			System.out.println("fileSize : " + fileSize);
			
			String newName = System.currentTimeMillis()+originFileName;
			String safeFile = uploadPath+"/"+newName;
			if(a==1) {
				idto.setMiddle1_img(newName);
			a++;
			}else if(a==2) {
				idto.setMiddle2_img(newName);
				a++;
			}else if(a==3) {
				idto.setMiddle3_img(newName);
				a++;
			}else if(a==4) {
				idto.setMiddle4_img(newName);
				a++;
			}else if(a==5) {
				idto.setMiddle5_img(newName);
				a++;
			}else if(a==6) {
				idto.setMiddle6_img(newName);
				a++;
			}else if(a==7) {
				idto.setMiddle7_img(newName);
				a++;
			}else if(a==8) {
				idto.setMiddle8_img(newName);
				a++;
			}else if(a==9) {
				idto.setMiddle9_img(newName);
				a++;
			}else if(a==10) {
				idto.setMiddle10_img(newName);
				a++;
			}else {
				System.out.println("a");
			}
			try {
				mf.transferTo(new File(safeFile));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		bdao.actionWriteInsert(adto);
		bdao.actionImgInsert(idto);
	}
	
	
	public static String addDate(String dt,int d) throws Exception  {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        Date date = format.parse(dt);
        cal.setTime(date);      
        cal.add(Calendar.DATE, d);     //일 더하기
        return format.format(cal.getTime());
    } //일 을 더해주는 것
}
