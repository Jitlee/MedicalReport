

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.github.jhonnymertz.wkhtmltopdf.wrapper.Pdf;
import main.java.com.github.jhonnymertz.wkhtmltopdf.wrapper.page.PageType;
import main.java.com.github.jhonnymertz.wkhtmltopdf.wrapper.params.Param;

/**
 * Servlet implementation class Download
 */
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int BUFSIZE = 4096;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Download() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String filePath = UUID.randomUUID().toString() + ".pdf";
		
		Pdf pdf = new Pdf();
		pdf.addParam(new Param("-L", "0m"), new Param("-T", "0m"), new Param("-B", "0m"), new Param("-R", "0m"));
		pdf.addPage("http://127.0.0.1:8020/MedicalReport/index.html", PageType.url);

		try {
			pdf.saveAs(filePath);

			File file = new File(filePath);
		    int length   = 0;
		    ServletOutputStream outStream = response.getOutputStream();
		    ServletContext context  = getServletConfig().getServletContext();
		    String mimetype = context.getMimeType(filePath);

		    // sets response content type
		    if (mimetype == null) {
		        mimetype = "application/octet-stream";
		    }
		    response.setContentType(mimetype);
		    response.setContentLength((int)file.length());
		    String fileName = (new File(filePath)).getName();

		    // sets HTTP header
		    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

		    byte[] byteBuffer = new byte[BUFSIZE];
		    DataInputStream in = new DataInputStream(new FileInputStream(file));

		    // reads the file's bytes and writes them to the response stream
		    while ((in != null) && ((length = in.read(byteBuffer)) != -1))
		    {
		        outStream.write(byteBuffer,0,length);
		    }

		    in.close();
		    outStream.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
