import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

// Class supplied to students. Shouldn't be modified.
public class MadLibsStoryBuilder {

    /**
     * Precondition: The format of the file
     * @param fileName
     * @return
     */
    public static MadLibsStory makeStoryFromFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        String[] storyList;
        ArrayList<MadLibsPlaceholder> placeholderList =  new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            while(line != null) {
                sb.append(line).append('\n');
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String storyStr = new String(sb);
        storyList = storyStr.split("\\[.*?\\]");

        while(storyStr.contains("[")) {

            int i = storyStr.indexOf("[");
            int j = storyStr.indexOf("]");
            String placeholderType = storyStr.substring(i + 1, j);
            MadLibsPlaceholder placeholder = new MadLibsPlaceholder(placeholderType);
            placeholderList.add(placeholder);
            storyStr = storyStr.substring(j + 1);
        }

        String title = fileName.substring(fileName.indexOf("/") + 1, fileName.indexOf(".txt"));
        MadLibsPlaceholder[] placeholderArray = new MadLibsPlaceholder[placeholderList.size()];
        placeholderArray = placeholderList.toArray(placeholderArray);

        return new MadLibsStory(title, storyList, placeholderArray);
    }
}