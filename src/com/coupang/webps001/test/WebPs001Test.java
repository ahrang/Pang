/**
 *
 */
package com.coupang.webps001.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.coupang.webps001.tsy.GainList;
import com.coupang.webps001.tsy.PrintWork;
import com.coupang.webps001.tsy.WebPs001;

/**
 * @author TaeSung
 *
 */
public class WebPs001Test {

	/**
	 * TEST용 투자금액 10만원
	 */
	private static final int TEST_AMT = 10;

	/**
	 * 투자금액으로 회사의 수익리스트 생성 갯수 확인
	 */
	@Test
	public void makeCoDataTest(){
		PrintWork.debugYn = true;
		System.out.println("");
		System.out.println("makeCoDataTest() Console 출력 ");

		// 각 회사별 초기 데이타 생성
		GainList a = new GainList( TEST_AMT ,"A Co" );
		GainList b = new GainList( TEST_AMT ,"B Co" );
		GainList c = new GainList( TEST_AMT ,"C Co" );

		// 기존 리스트 초기화
		WebPs001.resetListA();
		WebPs001.resetListB();
		WebPs001.resetListC();

		// 리스트 셋팅
		WebPs001.setBmla( a.getBm() );
		WebPs001.setBmlb( b.getBm() );
		WebPs001.setBmlc( c.getBm() );

		PrintWork.showCoDataTemp( WebPs001.getBmla() );
		PrintWork.showCoDataTemp( WebPs001.getBmlb() );
		PrintWork.showCoDataTemp( WebPs001.getBmlc() );

		assertEquals( TEST_AMT ,WebPs001.getBmla().size());
		assertEquals( TEST_AMT ,WebPs001.getBmlb().size());
		assertEquals( TEST_AMT ,WebPs001.getBmlc().size());
	}

	/**
	 * 회사의 수익리스트 출력 확인
	 */
	@Test
	public void printCoDataTest(){
		PrintWork.debugYn = true;
		System.out.println("");
		System.out.println("printCoDataTest() Console 출력 ");

		WebPs001.makeCoData(TEST_AMT);

		WebPs001.printCoData();

		assertEquals( TEST_AMT ,WebPs001.getAllcolist().size() );

	}

	/**
	 * 회사의 최대 수익 출력 확인
	 */
	@Test
	public void printMaxData(){
		PrintWork.debugYn = true;
		System.out.println("");
		System.out.println("printMaxData() Console 출력 ");

		WebPs001.makeCoData(TEST_AMT);
		WebPs001.printCoData();
		WebPs001.printMaxData(TEST_AMT);

	}

}
