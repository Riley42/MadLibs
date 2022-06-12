import java.io.File;

public class Main {

    public static void main(String[] args) {
        File directory = new File("stories/");
        String[] directoryList = directory.list();
        MadLibsStory[] stories = new MadLibsStory[directoryList.length];
        for (int i = 0; i < stories.length; i++) {
            stories[i] = MadLibsStoryBuilder.makeStoryFromFile("stories/" + directoryList[i]);
        }
        MadLibsGame ml = new MadLibsGame(stories);
        ml.play();
    }
}