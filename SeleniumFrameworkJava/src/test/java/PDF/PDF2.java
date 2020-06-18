package PDF;

import java.io.File;
import java.io.FileInputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDF2 {

	public static void main(String[] args) {
		try {
		
		FileInputStream file=new FileInputStream("C:\\Users\\Sai\\Downloads\\prejith pet.pdf");
		
		PDDocument document=PDDocument.load(file);
		
		PDFTextStripper stripper=new PDFTextStripper();
		String doicument=stripper.getText(document);
		System.out.println(doicument);
		
		document.close();
		
		
		}catch(Exception e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.toString());
		}
		
		
		

	}

}
