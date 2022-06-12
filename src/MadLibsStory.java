// Change this file


public class MadLibsStory {

    private String title;
    private String[] story;
    private MadLibsPlaceholder[] placeholders;
    private int placeholderIndex;

    public MadLibsStory() {
        title = "";
        story = new String[0];
        placeholders = new MadLibsPlaceholder[0];
    }
    public MadLibsStory(String title, String[] story, MadLibsPlaceholder[] placeholders) {
        this.title = title;
        this.story = story;
        this.placeholders = placeholders;
    }

    public String getTitle() {
        return title;
    }

    public MadLibsPlaceholder getNextPlaceholder()
    {
        // The current index is held in a variable, and is incremented every time
        if (placeholderIndex >= placeholders.length) {
            placeholderIndex = 0;
            return null;
        }
        return placeholders[placeholderIndex++];
    }

    public String toString()
    {

        StringBuilder finishedStory = new StringBuilder(title + "\n\n");

        // Since the story does not end with a placeholder, do not do last item in the loop
        for (int i = 0; i < story.length - 1; i++) {

            finishedStory.append(story[i]);
            finishedStory.append(placeholders[i].getWord());
        }

        // Append the last part of the story
        finishedStory.append(story[story.length - 1]);

        return finishedStory.toString();
    }
}
