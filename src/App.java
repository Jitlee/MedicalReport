import java.io.IOException;

import main.java.com.github.jhonnymertz.wkhtmltopdf.wrapper.Pdf;
import main.java.com.github.jhonnymertz.wkhtmltopdf.wrapper.page.PageType;
import main.java.com.github.jhonnymertz.wkhtmltopdf.wrapper.params.Param;

public class App {

	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		Pdf pdf = new Pdf();
		pdf.addParam(new Param("-L", "0m"), new Param("-T", "0m"), new Param("-B", "0m"), new Param("-R", "0m"));
		pdf.addPage("http://127.0.0.1:8020/MedicalReport/index.html", PageType.url);

		pdf.saveAs("output.pdf");
		
		System.out.print("导出成功!");
	}
}
