package chapter07;

interface Parseable {
	// 구문 분석작업을 수행
	public abstract void parse(String fileName);
}

class ParserManager {
	public static Parseable getParser (String type) {
		if (type.equals("XML")) {
			return new XMLParser();
		} else {
			Parseable p = new HTMLParser();
			return p;
			// return new HTMLParser
		}
	}
}

class XMLParser implements Parseable {
	@Override
	public void parse(String fileName) {
		System.out.println(fileName + " - XML Parsing Completed.");
	}
}

class HTMLParser implements Parseable {
	@Override
	public void parse(String fileName) {
		// 구문 분석작업을 수행하는 코드를 적는다.
		System.out.println(fileName + " - HTML Parsing Completed.");
	}
}

public class ParserTest {
	public static void main(String[] args) {
		Parseable parser = ParserManager.getParser("XML"); //Parseable parser = new XMLParser("XML");
		parser.parse("document.xml"); // document.xml - XML Parsing Completed. 
		parser = ParserManager.getParser("HTML");
		parser.parse("document2.html"); //document.html - HTML Parsing Competed.
	}
}
