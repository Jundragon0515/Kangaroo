package kh.spring.dto;

import java.sql.Timestamp;

public class MemberDTO {
	 private String id;
	   private String pw;
	   private String name;
	   private String phone;
	   private String zipcode;
	   private String address1;
	   private String address2;
	   private Timestamp joindate;
	   private String ipaddress;
	   private String logintype;
	   private String admin;
	   private int point;
	   private String member_class;
	   private String blacklist;
	   public MemberDTO(String id, String pw, String name, String phone, String zipcode, String address1,
	         String address2, Timestamp joindate, String ipaddress, String logintype, String admin,
	         int point, String member_class, String blacklist) {
	      super();
	      this.id = id;
	      this.pw = pw;
	      this.name = name;
	      this.phone = phone;
	      this.zipcode = zipcode;
	      this.address1 = address1;
	      this.address2 = address2;
	      this.joindate = joindate;
	      this.ipaddress = ipaddress;
	      this.logintype = logintype;
	      this.admin = admin;
	      this.point = point;
	      this.member_class = member_class;
	      this.blacklist = blacklist;
	   }
	   public MemberDTO(String id, String pw, String name, String phone, String zipcode, String address1,
	         String address2) {
	      super();
	      this.id = id;
	      this.pw = pw;
	      this.name = name;
	      this.phone = phone;
	      this.zipcode = zipcode;
	      this.address1 = address1;
	      this.address2 = address2;
	   }
	   public MemberDTO() {
	      super();
	   }

	   public String getId() {
	      return id;
	   }

	   public void setId(String id) {
	      this.id = id;
	   }

	   public String getPw() {
	      return pw;
	   }

	   public void setPw(String pw) {
	      this.pw = pw;
	   }

	   public String getName() {
	      return name;
	   }

	   public void setName(String name) {
	      this.name = name;
	   }

	   public String getPhone() {
	      return phone;
	   }

	   public void setPhone(String phone) {
	      this.phone = phone;
	   }

	   public String getZipcode() {
	      return zipcode;
	   }

	   public void setZipcode(String zipcode) {
	      this.zipcode = zipcode;
	   }

	   public String getAddress1() {
	      return address1;
	   }

	   public void setAddress1(String address1) {
	      this.address1 = address1;
	   }

	   public String getAddress2() {
	      return address2;
	   }

	   public void setAddress2(String address2) {
	      this.address2 = address2;
	   }

	   public Timestamp getJoindate() {
	      return joindate;
	   }

	   public void setJoindate(Timestamp joindate) {
	      this.joindate = joindate;
	   }

	   public String getIpaddress() {
	      return ipaddress;
	   }

	   public void setIpaddress(String ipaddress) {
	      this.ipaddress = ipaddress;
	   }

	   public String getLogintype() {
	      return logintype;
	   }

	   public void setLogintype(String logintype) {
	      this.logintype = logintype;
	   }

	   public String getAdmin() {
	      return admin;
	   }

	   public void setAdmin(String admin) {
	      this.admin = admin;
	   }

	   public int getPoint() {
	      return point;
	   }

	   public void setPoint(int point) {
	      this.point = point;
	   }

	   public String getMember_class() {
	      return member_class;
	   }

	   public void setMember_class(String member_class) {
	      this.member_class = member_class;
	   }

	   public String getBlacklist() {
	      return blacklist;
	   }

	   public void setBlacklist(String blacklist) {
	      this.blacklist = blacklist;
	   }
}
