/**
 *
 */
package com.coupang.webps001.tsy;

/**
 * @author TaeSung
 *
 */
public class BaseModel {

	/**
	 * 회사명
	 */
	private String coName;

	/**
	 * 투자금액
	 */
	private int investAmt;

	/**
	 * 수익금액
	 */
	private int gainAmt;

	/**
	 * 투자금액 대비 수익금액의 최대치 비율 (초기값 5)
	 */
	private int gainRate = 5;


	public String getCoName() {
		return coName;
	}

	public void setCoName(String coName) {
		this.coName = coName;
	}

	public int getInvestAmt() {
		return investAmt;
	}

	public void setInvestAmt(int investAmt) {
		this.investAmt = investAmt;
		setGainAmt( getRandom(this.investAmt, ( this.investAmt * getGainRate() ) ) ) ;
	}

	public int getGainAmt() {
		return gainAmt;
	}

	public void setGainAmt(int gainAmt) {
		this.gainAmt = gainAmt;
	}

	public int getGainRate() {
		return gainRate;
	}

	public void setGainRate(int gainRate) {
		this.gainRate = gainRate;
	}

	/**
	 * 지정 범위내의 정수를 랜덤하게 반환하는 함수
	 * @param  n1 하한값
	 * @param  n2 상한값
	 * @return
	 */
	public static int getRandom(int n1 ,int n2){
		int rtn = (int) (Math.random() * (n2 - n1 + 1)) + n1;
		//System.out.println("getRandom(" + n1 + " ," + n2 + " ) ==> " + rtn);
		return rtn;
	}




}
