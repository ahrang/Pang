package com.coupang.webapp007.tsy;

import java.util.Comparator;


public class ResultMap {

	/**
	 * 판매량
	 */
	private String cnt ;

	/**
	 * 판매량
	 */
	private Integer sortCnt;

	/**
	 * site
	 */
	private String site;

	/**
	 * 상품정보
	 */
	private String title;

	/**
	 * 검색 Url
	 */
	private String url;

	/**
	 * 판매가격
	 */
	private String price;


	public String getCnt() {
		return cnt;
	}

	public void setCnt(String cnt) {
		cnt = cnt.replace("구", "").replace("매", "").replace("중", "").replace("개", "").trim();
		setSortCnt( cnt );
		this.cnt = Util.LPAD( cnt ,12 ," ");
	}

	public Integer getSortCnt() {
		return sortCnt;
	}

	public void setSortCnt(String cnt) {
		this.sortCnt = Integer.parseInt(cnt.replace(",", ""));
	}

	public void setSortCnt(Integer sortCnt) {
		this.sortCnt = sortCnt;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site ;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		price = price.replace("~", "").replace("원", "").trim() + "원";
		this.price = Util.LPAD( price ,20 ," ");
	}

}


class CompareAsc implements Comparator<ResultMap> {

	  /**
	   * 오름차순(ASC) 정렬
	   */
	  @Override
	  public int compare(ResultMap o1, ResultMap o2) {
		  int v1 = o1.getSortCnt();
		  int v2 = o2.getSortCnt();
		  return v1 < v2 ? -1 : (v1 > v2 ? 1 : 0);
	  }
}


class CompareDesc implements Comparator<ResultMap> {

	  /**
	   * 내림차순(DESC) 정렬
	   */
	  @Override
	  public int compare(ResultMap o1, ResultMap o2) {
		  int v1 = o1.getSortCnt();
		  int v2 = o2.getSortCnt();
		  return v1 < v2 ? 1 : (v1 > v2 ? -1 : 0);
	  }
 }

