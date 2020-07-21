package com.itext.demo;

import java.io.FileOutputStream;
import java.net.URL;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ImageDemo {

	public static void main(String[] args) {

		Document document = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream("src/main/java/com/itext/data/AddImageExample.pdf"));
			document.open();
			document.add(new Paragraph("Image Example"));

			// Add Image
			Image image1 = Image.getInstance("src/main/java/com/itext/data/World_Cup_2296277a.jpg");
			// Fixed Positioning
			image1.setAbsolutePosition(100f, 550f);
			// Scale to new height and new width of image
			image1.scaleAbsolute(200, 200);
			// Add to document
			document.add(image1);

			String imageUrl = "http://www.eclipse.org/xtend/images/java8_logo.png";
			Image image2 = Image.getInstance(new URL(imageUrl));
			document.add(image2);

			document.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
