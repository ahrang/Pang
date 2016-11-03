/**
 *
 */
package com.coupang.webps001.tsy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TaeSung
 *
 */
public class GainList {


	private List<BaseModel> bm = new ArrayList<BaseModel>();

	public List<BaseModel> getBm() {
		return bm;
	}

	public void setBm(List<BaseModel> bm) {
		this.bm = bm;
	}

	/**
	 * 투자금액별 수익금액 리스트 생성
	 * @param amt (투자금액)
	 */
	public GainList(int amt ,String coName ){
		for(int i = 1; i <= amt; i++){
			BaseModel data = new BaseModel();
			data.setInvestAmt( i );
			data.setCoName(coName);
			bm.add(data);
		}
	}


}
