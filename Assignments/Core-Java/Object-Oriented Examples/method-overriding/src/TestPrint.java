
public class TestPrint {

	public static void main(String[] args) {

		MessagePrinting mp1 = new MessagePrinting();
		MessagePrinting mp2 = new ConsolePrinting();
		MessagePrinting mp3 = new BrowserPrinting();
		
		mp1.print();
		mp2.print();
		mp3.print();
	}

}
