package PDF;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDF3 {

	public static void main(String[] args) throws IOException {
		
		
		File f=new File("C:\\Users\\Sai\\Downloads\\prejith pet.pdf");
		PDDocument doc=PDDocument.load(f);
		PDFTextStripper text=new PDFTextStripper();
		String b=text.getText(doc);
		System.out.println(b);

	}

}
