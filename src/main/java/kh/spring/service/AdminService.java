package kh.spring.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import kh.spring.dao.AdminDAO;
import kh.spring.dao.CartDAO;

@Component
public class AdminService {

   @Autowired
   private HttpSession session;
   @Autowired
   private AdminDAO dao;
   
   @Transactional("txManager")
   public void boardDelete(String value[]) {
         for(int i=0; i<value.length; i++) {
            try {
               dao.boardWriteDelete(value[i]);
               dao.boardImgDelete(value[i]);
               dao.cartDelete(value[i]);
            } catch (Exception e) {
               e.printStackTrace();
            }
      }
   }
   
   @Transactional("txManager")
   public void auctionBoardDelete(String value[]) {
         for(int i=0; i<value.length; i++) {
            try {
               dao.auctionBoardDelete(value[i]);
               dao.auctionBoardImgDelete(value[i]);
               dao.cartAuctionDelete(value[i]);
            } catch (Exception e) {
               e.printStackTrace();
            }
      }
   }
   
}