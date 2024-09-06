
package compresspdf.helpers;


import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import com.mendix.logging.ILogNode;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PdfImageCompressor {


    public PdfImageCompressor(int compressionLevel) {
    }

    public void compressImagesOnPage(PDPage page, PDDocument pdfDoc, ILogNode LOG, int compression, int MinFileSize) throws IOException {
        PDResources resources = page.getResources();
        if (resources != null) {
            Iterable<COSName> xObjectNames = resources.getXObjectNames();
            for (COSName xObjectName : xObjectNames) {
                PDXObject xObject = resources.getXObject(xObjectName);
                if (xObject instanceof PDImageXObject) {
                    PDImageXObject imageObject = (PDImageXObject) xObject;
                    if (getImageSize(imageObject) >= MinFileSize) {
                        PDImageXObject compressedImage = resizeAndCompress(imageObject, pdfDoc, LOG, compression);
                        resources.put(xObjectName, compressedImage);
                    } else {
                        // skipped image due to smaller than minimum file size
                    }
                }
            }
            
        }
    }

    private int getImageSize(PDImageXObject image) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(image.getImage(), "JPEG", baos);
            return baos.size();
        }
    }
    

    private PDImageXObject resizeAndCompress(PDImageXObject image, PDDocument pdfDoc, ILogNode LOG, int compression) throws IOException {
    	int newWidth = image.getWidth() / compression;
        int newHeight = image.getHeight() / compression;
   
        BufferedImage bImage = image.getImage();
		BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

        Graphics2D g = resizedImage.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, newWidth, newHeight);
        g.drawImage(bImage, 0, 0, newWidth, newHeight, Color.WHITE, null);
        g.dispose();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(resizedImage, "JPEG", baos);



        // Create a new PDImageXObject from the resized image byte array
        PDImageXObject compressedImage = PDImageXObject.createFromByteArray(pdfDoc, baos.toByteArray(), "CompressedImage");
        return compressedImage;
    }


}