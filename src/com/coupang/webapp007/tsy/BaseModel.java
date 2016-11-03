/**
 *
 */
package com.coupang.webapp007.tsy;

/**
 * @author TaeSung
 *
 */
public class BaseModel {

	/**
	 * 검색어 저장 변수
	 */
	private String keyWord;

	/**
	 * 검색Site 출처표시
	 */
	private String siteName;

	/**
	 * 함수실행 최대값.(원하는 스크립트를 못가져올때 무한루프방지 최대값)
	 */
	private int maxCnt = 10;

	/**
	 * 각 함수 실행 횟수 초기값1
	 */
	private int runCnt = 1;

	/**
	 * 각 함수 실행 결과 초기값0
	 */
	private  int getCnt = 0;

	/**
	 * 각 Site 검색 주소
	 */
	private String siteUrl;

	/**
	 * 소스내 검색결과 DIV 의 ID
	 */
	private String divId;

	/**
	 * 소스내 검색결과 DIV 의 ID 안에서 가져올 상품의 제목
	 */
	private String titleClass;

	/**
	 * 소스내 검색결과 DIV 의 ID 안에서 가져올 상품의 가격
	 */
	private String priceClass;

	/**
	 * 소스내 검색결과 DIV 의 ID 안에서 가져올 상품의 판매수량
	 */
	private String saleClass;


	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public int getMaxCnt() {
		return maxCnt;
	}

	public void setMaxCnt(int maxCnt) {
		this.maxCnt = maxCnt;
	}

	public int getRunCnt() {
		return runCnt;
	}

	public void setRunCnt(int runCnt) {
		this.runCnt = runCnt;
	}

	/**
	 * 함수호출시 실행횟수 자동증가.
	 */
	public void setRunCnt( ) {
		this.runCnt++;
	}

	public int getGetCnt() {
		return getCnt;
	}

	public void setGetCnt(int getCnt) {
		this.getCnt = getCnt;
	}

	public String getSiteUrl() {
		return siteUrl;
	}

	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}

	public String getDivId() {
		return divId;
	}

	public void setDivId(String divId) {
		this.divId = divId;
	}

	public String getTitleClass() {
		return titleClass;
	}

	public void setTitleClass(String titleClass) {
		this.titleClass = titleClass;
	}

	public String getPriceClass() {
		return priceClass;
	}

	public void setPriceClass(String priceClass) {
		this.priceClass = priceClass;
	}

	public String getSaleClass() {
		return saleClass;
	}

	public void setSaleClass(String saleClass) {
		this.saleClass = saleClass;
	}


}
