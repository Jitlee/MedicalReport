import java.util.UUID;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String tmpFileName = UUID.randomUUID().toString();
		String htmlUrl = "http://36kr.com/";
		String pdfFilePath = tmpFileName + ".pdf";
		try {            
			pdfTest(htmlUrl, pdfFilePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
