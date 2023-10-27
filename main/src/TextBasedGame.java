import java.util.Scanner;

public class HauntedHouseGame {
    private static int playerHealth = 100;
    private static String playerName;
    private static boolean hasKey = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Haunted House! What's your name?");
        playerName = scanner.nextLine();

        System.out.println("Hello, " + playerName + "! You find yourself standing in front of a spooky haunted house.");
        System.out.println("You can see two doors: one on the left and one on the right.");
        System.out.println("Which door do you choose? (left/right)");

        String doorChoice = scanner.nextLine();
        if (doorChoice.equals("left")) {
            exploreLeftRoom();
        } else if (doorChoice.equals("right")) {
            exploreRightRoom();
        } else {
            System.out.println("Invalid choice. The game ends.");
        }
    }

    public static void exploreLeftRoom() {
        System.out.println("You enter the left room. It's filled with cobwebs and eerie silence.");
        System.out.println("As you walk further, you see a ghostly figure lurking in the corner!");
        System.out.println("What do you do? (attack/run)");

        Scanner scanner = new Scanner(System.in);
        String actionChoice = scanner.nextLine();
        if (actionChoice.equals("attack")) {
            System.out.println("You try to attack the ghost, but your hands pass through it. You can't fight ghosts!");
            System.out.println("The ghost retaliates and drains your health.");
            playerHealth -= 20;
            System.out.println("Your health: " + playerHealth);
            if (playerHealth <= 0) {
                gameOver();
            } else {
                System.out.println("You quickly leave the room, back to the entrance.");
                main(null); // Go back to the entrance
            }
        } else if (actionChoice.equals("run")) {
            System.out.println("You turn around and sprint out of the room, back to the entrance.");
            main(null); // Go back to the entrance
        } else {
            System.out.println("Invalid choice. The game ends.");
        }
    }

    public static void exploreRightRoom() {
        System.out.println("You enter the right room. It's dimly lit and filled with dusty furniture.");
        System.out.println("You notice a shiny object on a table. It's a key!");
        System.out.println("Do you take the key? (yes/no)");

        Scanner scanner = new Scanner(System.in);
        String keyChoice = scanner.nextLine();
        if (keyChoice.equals("yes")) {
            System.out.println("You take the key. It might be useful later.");
            hasKey = true;
            System.out.println("You leave the room and return to the entrance.");
            main(null); // Go back to the entrance
        } else if (keyChoice.equals("no")) {
            System.out.println("You decide not to take the key and leave the room.");
            System.out.println("Back at the entrance, you see the two doors again.");
            System.out.println("Which door do you choose? (left/right)");
            String doorChoice = scanner.nextLine();
            if (doorChoice.equals("left")) {
                exploreLeftRoom();
            } else if (doorChoice.equals("right")) {
                exploreRightRoom();
            } else {
                System.out.println("Invalid choice. The game ends.");
            }
        } else {
            System.out.println("Invalid choice. The game ends.");
        }
    }

    public static void gameOver() {
        System.out.println("Game over! Your health has reached zero.");
        System.out.println("Better luck next time, " + playerName + "!");
        System.exit(0);
    }
}
