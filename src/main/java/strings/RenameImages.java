package strings;

import java.io.File;
import java.io.IOException;

public class RenameImages {

    public static void main(String[] args) throws IOException {

        // /Users/mohammedrahman/Docs/CSC767NN/HomeworkFall23/Homework2/cassavaleafdata/cbb/
        // Get the directory containing the image files.
        File directory = new File("/Users/mohammedrahman/Docs/CSC767NN/HomeworkFall23/Homework2/cassavaleafdata/cmd/");

        // Get a list of all the files in the directory.
        File[] files = directory.listFiles();

        // Iterate over the files and rename each file.
        assert files != null;
        int n = files.length;
        int i = 0;
        for (File file : files) {

            // Check if the file is an image file.
            if (file.getName().endsWith(".jpg") || file.getName().endsWith(".png")) {

                // Rename the file by adding "-renamed" to the name.
                file.renameTo(new File(directory  + "-" + i + ".jpg"));
                i++;
            }
        }
    }
}
