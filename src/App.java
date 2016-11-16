/**
 * 
 */

/**
 * @author wanpinjia
 *
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws DocumentException, IOException {
		// TODO Auto-generated method stub
		 // step 1
        Document document = new Document(PageSize.A4, 0, 0, 0, 0);
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("pdf.pdf"));
        // step 3
        document.open();
        // step 4
        InputStream input = new URL("http://127.0.0.1:8020/MedicalReport/index.html").openStream();
        // setp 5
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, input);
        //step 6
         document.close();
 
        System.out.println( "PDF Created!" );
	}

}
