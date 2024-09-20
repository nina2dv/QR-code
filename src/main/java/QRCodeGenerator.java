import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {
    public static void main(String[] args) {
        String data = "wow";
        String path = "QRCode.png";
        int width = 300;
        int height = 300;

        try {
            BitMatrix matrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, width, height);
            Path filePath = FileSystems.getDefault().getPath(path);
            MatrixToImageWriter.writeToPath(matrix, "PNG", filePath);
            System.out.println("QR Code generated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}