import java.io.IOException;
import java.security.KeyStore.Entry.Attribute;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

public class Rss {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Rss rss=new Rss();
		rss.HaberListesi();
	}
	
	public void HaberListesi() throws IOException{
	    Document document = Jsoup.connect("http://www.milliyet.com.tr/rss/rssNew/SonDakikaRss.xml").get();
	    Document doc1=Jsoup.parse(document.html(),"",Parser.xmlParser());
	    for (Element e : document.select("item")) {
	    	
	    	System.out.println(e.tagName("link").text());
	    }
	}
}
