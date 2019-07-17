package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.GoodsTradeDAO;
import kh.spring.dto.GoodsTradeDTO;

@Service
public class GoodsTradeService {

   @Autowired
   private GoodsTradeDAO gdao;

   public List<GoodsTradeDTO> tradeList(int start, int end){
      return gdao.selectList(start, end);
   }

   public List<GoodsTradeDTO> tradeListPrice(int start, int end, String price){
      List<GoodsTradeDTO> result=null;
      
      if(price.equals("low")) {
         result = gdao.selectListLowPrice(start, end);   
      }else {
         result = gdao.selectListHighPrice(start, end);
      }
      return result;
   }

   public String tradeBoardNavi(int currentPage, int recordCountPerPage) {
      return gdao.getNavi(currentPage, recordCountPerPage);
   }
  
   
   public String tradeBoardNaviView(int currentPage, int recordCountPerPage, int view , String price) {
      return gdao.getNaviView(currentPage, recordCountPerPage , view , price);
   }
   public String tradeBoardNaviView(int currentPage, int recordCountPerPage, int view) {
      return gdao.getNaviView(currentPage, recordCountPerPage , view);
   }


}