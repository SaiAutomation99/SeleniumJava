package PDF;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDF {

	public static void main(String[] args) throws InvalidPasswordException, IOException {
		
		
		
		File in=new File("C:\\Users\\Sai\\Downloads\\prejith pet.pdf");
	      PDDocument document = PDDocument.load(in);

		
		PDFTextStripper stripper=new PDFTextStripper();
		String m=stripper.getText(document);
		System.out.println(m);	
		document.close();
	}

}
