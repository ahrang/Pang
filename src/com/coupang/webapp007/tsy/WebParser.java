/**
 *
 */
package com.coupang.webapp007.tsy;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;
import net.htmlparser.jericho.Source;

/**
 * @author TaeSung
 *
 */
public class WebParser extends BaseModel {

	/**
	 * 웹페이지 Parsing & 리스트 생성.
	 *
	 */
	public List<ResultMap> getList() throws MalformedURLException, IOException{

		//함수실행횟수 증가.
		setRunCnt();

        //해당 URL 페이지를 가져온다.
        Source source = new Source(new URL( getSiteUrl() + getKeyWord() ));
        source.fullSequentialParse();

        List<ResultMap> subList = new ArrayList<ResultMap>();

        try{
        	Element productList = source.getElementById( getDivId() );

            if( !productList.isEmpty() ){

            	List<?>     liList = productList.getAllElements(HTMLElementName.LI);
            	Iterator<?> liIter = liList.iterator();

            	String  lsTitle ,lsPrice ,lsCnt= "";

            	while(liIter.hasNext()){
            		Element li = (Element) liIter.next();
            		ResultMap searchList = new ResultMap();

            		try{
            			lsTitle = (li.getAllElementsByClass( getTitleClass() ).get(0)).getContent().getTextExtractor().toString();
            			lsPrice = (li.getAllElementsByClass( getPriceClass() ).get(0)).getContent().getTextExtractor().toString();
            			lsCnt   = (li.getAllElementsByClass( getSaleClass()  ).get(0)).getContent().getTextExtractor().toString();

            			if(lsCnt == null || lsCnt.length() == 0 ){
            				lsCnt = "0";
            			}
            			searchList.setSite (getSiteName());
            			searchList.setTitle(lsTitle);
            			searchList.setPrice(lsPrice);
            			searchList.setCnt  (lsCnt);
            			subList.add(searchList);

            		}catch( Exception  e){
            		}
            	}
            	setGetCnt(subList.size());
            }
        }catch( Exception  e){
		}

        return subList;
	}


}
