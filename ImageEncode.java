
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class ImageEncode {

    public static void main(String[] args) {
        String imagePath = "C:\\Users\\lenovo\\Downloads\\download.jpg";

        String encodedImage = encoder(imagePath);
        System.out.println(encodedImage);
        
        decoder(encodedImage, "C:\\Users\\lenovo\\Downloads\\decoderimage.jpg");
    }

    public static String encoder(String imagePath) {
        String base64Image = "";
        File file = new File(imagePath);
        System.out.println(file);
        try {
            FileInputStream imageInFile = new FileInputStream(file);
            byte imageData[] = new byte[(int) file.length()];
            int x = (int) file.length();
            imageInFile.read(imageData);
            base64Image = Base64.getEncoder().encodeToString(imageData);
        } catch (FileNotFoundException e) {
            System.out.println("Image Not Found: " + e);
        } catch (IOException e) {
            System.out.println("Exception while reading the Image " + e);
        }
        return base64Image;
    }

    public static void decoder(String base64Image, String pathFile) {
        try (FileOutputStream imageOutFile = new FileOutputStream(pathFile)) {
            byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
            imageOutFile.write(imageByteArray);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
