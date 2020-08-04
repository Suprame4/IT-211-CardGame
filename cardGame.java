import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import javax.imageio.ImageIO;

public class cardGame {
    // File representing the folder that you select using a FileChooser
    static final File dir = new File("cards");

    // array of supported extensions (use a List if you prefer)
    static final String[] EXTENSIONS = new String[]{"gif"};

    // filter to identify images based on their extensions
    static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

        @Override
        public boolean accept(final File dir, final String name) {
            for (final String ext : EXTENSIONS) {
                if (name.endsWith("." + ext)) {
                    return (true);
                }
            }
            return (false);
        }
    };

    public static void main(String[] args) throws IOException {
        card aceOfSpades = new card("Ace","Spades", 1,ImageIO.read(new File ("cards/as.gif")));
        card twoOfSpades = new card ("Two", "Spades", 2, ImageIO.read(new File ("cards/2s.gif")));

        System.out.println(aceOfSpades.toString());
    }
}

