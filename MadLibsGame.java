import java.util.Scanner;
public class MadLibsGame {

    private final MadLibsStory[] stories;
    public MadLibsGame() {
        this.stories = new MadLibsStory[0];
    }

    public MadLibsGame(MadLibsStory[] stories) {
        this.stories = stories;
    }

    public MadLibsStory getRandomStory() {

        // Generate a random index between 0 and the story's length. stories.length is exclusive. Then return it
        int index = (int) (Math.random() * stories.length);
        return stories[index];
    }

    // Generate the listing string, with index being 1 over i (so it starts at 1 not 0.)
    public void listStories() {

        for (int i = 0; i < stories.length; i++)
            System.out.printf(("%d. %s%n"), (i+1), stories[i].getTitle());
    }

    public void play() {

        String selection;

        System.out.println("Welcome to Mad Libs, the most popular phrasal word template game.\n");
        Scanner scan = new Scanner(System.in);

        do {
            int index = -1;

            // Print menu and take user input
            printMenu();
            selection = scan.nextLine();

            // Allow user to exit
            if (selection.equalsIgnoreCase("e")) {
                break;
            }

            // Handle input
            try {
                index = Integer.parseInt(selection);

            } catch (NumberFormatException fe) {

                System.out.println("Not a valid input, a number was expected. Please try again");
            } finally {

                if (boundsCheck(index)) {

                    // Print random story or user defined story
                    MadLibsStory story = (index == 0) ? getRandomStory() : getStoryAtIndex(index-1) ;
                    assert story != null;
                    fillStory(story, scan);
                    System.out.println(story);

                } else {

                    System.out.println("Please choose a number 1-" + stories.length);
                }
            }

        } while (true);
    }

    // Helper functionss
    private void printMenu(){

        System.out.println("******************************\n");
        System.out.println("SELECT A STORY (to pick a random story enter '0', to exit enter 'E')\n");

        listStories();

        System.out.print("\nSelection: ");
    }
    private boolean boundsCheck(int i){
        return i >= 0 && i <= stories.length;
    }
    private MadLibsStory getStoryAtIndex(int index) {

        // If index is less than 0 or greater/equal to stories.length, return null
        if (index < 0 || index >= stories.length) return null;

        return stories[index];
    }
    private void fillStory(MadLibsStory story, Scanner scan){

        MadLibsPlaceholder placeholder = story.getNextPlaceholder();

        // While there is a next placeholder, keep replacing them.
        while (placeholder != null) {

            System.out.println("Give me a " + placeholder.getType());

            String newWord = scan.nextLine();
            placeholder.setWord(newWord);
            placeholder = story.getNextPlaceholder();
        }
    }
}
