/**
 *
 */
package com.coupang.webps001.tsy;

import java.util.Comparator;

/**
 * @author TaeSung
 *
 */
public class BaseCoMaxModel extends BaseCoModel {


	/**
	 * 최대 투자금액 A
	 */
	private int amtMaxA;

	/**
	 * 최대 투자금액 B
	 */
	private int amtMaxB;

	/**
	 * 최대 투자금액 C
	 */
	private int amtMaxC;

	/**
	 * 최대 투자금액 합
	 */
	private int amtMaxSum;


	public int getAmtMaxA() {
		return amtMaxA;
	}

	public void setAmtMaxA(int amtMaxA) {
		this.amtMaxA = amtMaxA;
	}

	public int getAmtMaxB() {
		return amtMaxB;
	}

	public void setAmtMaxB(int amtMaxB) {
		this.amtMaxB = amtMaxB;
	}

	public int getAmtMaxC() {
		return amtMaxC;
	}

	public void setAmtMaxC(int amtMaxC) {
		this.amtMaxC = amtMaxC;
	}

	public int getAmtMaxSum() {
		return amtMaxSum;
	}

	public void setAmtMaxSum(int amtMaxSum) {
		this.amtMaxSum = amtMaxSum;
	}

}


class CompareMaxAsc implements Comparator<BaseCoMaxModel> {

	  /**
	   * 오름차순(ASC) 정렬
	   */
	  @Override
	  public int compare(BaseCoMaxModel o1, BaseCoMaxModel o2) {
		  int v1 = o1.getAmtMaxSum();
		  int v2 = o2.getAmtMaxSum();
		  return v1 < v2 ? -1 : (v1 > v2 ? 1 : 0);
	  }
}

class CompareMaxDesc implements Comparator<BaseCoMaxModel> {

	  /**
	   * 내림차순(DESC) 정렬
	   */
	  @Override
	  public int compare(BaseCoMaxModel o1, BaseCoMaxModel o2) {
		  int v1 = o1.getAmtMaxSum();
		  int v2 = o2.getAmtMaxSum();
		  return v1 < v2 ? 1 : (v1 > v2 ? -1 : 0);
	  }
}


