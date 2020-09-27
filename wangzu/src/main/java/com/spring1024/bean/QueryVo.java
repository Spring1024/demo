package com.spring1024.bean;

public class QueryVo {
		//房子编码
		private String hid;
		//房子标题
		private String hname;
		//地铁
		private String hsubway;
		//户型
		private String hmodel;
		//出租类型
		private int htype;
		//位置
		private String hposition;
		//价格区间 低价
		private Double lprice;
		//价格区间 高价价
		private Double hpric;
		//limit x
		private Integer x;
		//limit , y
		private Integer y;
		//区分前台还是后台访问 
		private Integer method;
		
		//搜索框不定查询
		private String searchVal;
		
		public String getHid() {
			return hid;
		}
		public void setHid(String hid) {
			this.hid = hid;
		}
		public String getHname() {
			return hname;
		}
		public void setHname(String hname) {
			this.hname = hname;
		}
		public String getHsubway() {
			return hsubway;
		}
		public void setHsubway(String hsubway) {
			this.hsubway = hsubway;
		}
		public String getHmodel() {
			return hmodel;
		}
		public void setHmodel(String hmodel) {
			this.hmodel = hmodel;
		}
		
		public int getHtype() {
			return htype;
		}
		public void setHtype(int htype) {
			this.htype = htype;
		}
		public String getHposition() {
			return hposition;
		}
		public void setHposition(String hposition) {
			this.hposition = hposition;
		}
		public Double getLprice() {
			return lprice;
		}
		public void setLprice(Double lprice) {
			this.lprice = lprice;
		}
		public Double getHpric() {
			return hpric;
		}
		public void setHpric(Double hpric) {
			this.hpric = hpric;
		}
		public Integer getX() {
			return x;
		}
		public void setX(Integer x) {
			this.x = x;
		}
		public Integer getY() {
			return y;
		}
		public void setY(Integer y) {
			this.y = y;
		}
		
		public String getSearchVal() {
			return searchVal;
		}
		public void setSearchVal(String searchVal) {
			this.searchVal = searchVal;
		}
		
		public Integer getMethod() {
			return method;
		}
		public void setMethod(Integer method) {
			this.method = method;
		}
		@Override
		public String toString() {
			return "QueryVo [hid=" + hid + ", hname=" + hname + ", hsubway=" + hsubway + ", hmodel=" + hmodel + ", htype="
					+ htype + ", hposition=" + hposition + ", lprice=" + lprice + ", hpric="
					+ hpric + ", x=" + x + ", y=" + y + ", searchVal=" + searchVal + "]";
		}
}
