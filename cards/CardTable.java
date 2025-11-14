package cards;

import java.util.Scanner;

public class CardTable {

    Deck deck;

    public CardTable()
    {
        deck = new Deck();
    }

    public void startPlaying()
    {
        deck.shuffle();

        Scanner keyboard = new Scanner(System.in);

        Game game = new Game(deck);

        game.printRules();
        game.next();

        String input = " ";
        Boolean play = true;
        while (play)
        {
            System.out.println("Enter a command: (q to quit)");
            input = keyboard.nextLine();
            if (input.length() > 0)
            {
                String command = input.substring(0, 1);
                if (command.equals("q"))
                {
                    play = false;
                    continue;
                }
                else if (command.equals("r")) {
                    game = new Game(deck);
                }
                else {
                    boolean result = game.takeTurn(command);
                    if (result == false)
                    {
                        System.out.println("\n");
                        game.next();
                    }
                }
            }
        }
        keyboard.close();
   }
}
