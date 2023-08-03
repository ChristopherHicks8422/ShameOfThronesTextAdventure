package GameWithWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Game {

    JFrame window;
    Container container;
    JPanel titleNamePanel, titleTextPanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, powerLabel, powerLabelNumber, itemLabel, itemLabelName;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 120);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 48);
    Font headerTextFont = new Font("Times New Roman", Font.PLAIN, 38);
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea, titleTextArea;
    int power, patronHP, characterHP, damageDealt, damageReceived;
    String equipedItem, position;
    Random randomNumber = new Random();


    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    public static void main(String[] args) {

        new Game();
    }

    public Game() {

        window = new JFrame();
        window.setSize(1200, 1000);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        container = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 1000, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("Shame of Thrones");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);
        container.add(titleNamePanel);

        titleTextPanel = new JPanel();
        titleTextPanel.setBounds(100, 500, 1000, 250);
        titleTextPanel.setBackground(Color.black);
        container.add(titleTextPanel);

        titleTextArea = new JTextArea("\tA Game By\n\tChristopher Hicks");
        titleTextArea.setBounds(100, 500, 1000, 250);
        titleTextArea.setBackground(Color.black);
        titleTextArea.setForeground(Color.white);
        titleTextArea.setFont(normalFont);
        titleTextArea.setLineWrap(true);
        titleTextPanel.add(titleTextArea);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(400, 800, 400, 200);
        startButtonPanel.setBackground(Color.black);
        container.add(startButtonPanel);


        startButton = new JButton("Start");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButtonPanel.add(startButton);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);
    }

    public void createGameScreen() {

        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        titleTextPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 1000, 350);
        mainTextPanel.setBackground(Color.black);
        container.add(mainTextPanel);

        mainTextArea = new JTextArea();
        mainTextArea.setBounds(100, 100, 1000, 350);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(100, 500, 1000, 450);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        container.add(choiceButtonPanel);

        choice1 = new JButton();
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choiceButtonPanel.add(choice1);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");

        choice2 = new JButton();
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choiceButtonPanel.add(choice2);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");

        choice3 = new JButton();
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choiceButtonPanel.add(choice3);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");

        choice4 = new JButton();
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choiceButtonPanel.add(choice4);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 1000, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 4));
        container.add(playerPanel);

        powerLabel = new JLabel("Power: ");
        powerLabel.setFont(normalFont);
        powerLabel.setForeground(Color.white);
        playerPanel.add(powerLabel);

        powerLabelNumber = new JLabel();
        powerLabelNumber.setFont(normalFont);
        powerLabelNumber.setForeground(Color.white);
        playerPanel.add(powerLabelNumber);

        itemLabel = new JLabel("Equipped Item: ");
        itemLabel.setFont(headerTextFont);
        itemLabel.setForeground(Color.white);
        playerPanel.add(itemLabel);

        itemLabelName = new JLabel();
        itemLabelName.setFont(headerTextFont);
        itemLabelName.setForeground(Color.white);
        playerPanel.add(itemLabelName);

        playerSetup();
    }

    public void playerSetup() {
        power = 15;
        characterHP = 15;
        patronHP = 20;
        equipedItem = "Signet Ring";
        itemLabelName.setText(equipedItem);
        powerLabelNumber.setText("" + power);

        welcomeRoom();
    }

    public void welcomeRoom() {
        position = "WelcomeRoom";

        mainTextArea.setText("King Roderick is dying, his entire family\n" +
                "is missing. After days of scrambling to find\n" +
                "next in line for the throne it has been \n" +
                "determined that you, the King's bastard child\n" +
                "will rule the country of Endland in his stead.\n" +
                "What's the worst that could happen...");

        choice1.setText("Go to Throne Room");
        choice2.setText("Go to Bed Chamber");
        choice3.setText("Go to Servants Quarters");
        choice4.setText("Go to Tavern");
    }

    public void toThroneRoom() {
        position = "ThroneRoom";

        mainTextArea.setText("Welcome to the Throne Room your Highness\n" +
                "What would you like to do today?");

        choice1.setText("Seek Council from Advisors");
        choice2.setText("Receive Foreign Dignitaries");
        choice3.setText("Hear Petitions of the Peasantry");
        choice4.setText("Leave");
    }

    public void toBedChamber() {
        position = "BedChamber";

        mainTextArea.setText("This is your Private Bed Chamber.\n" +
                "Anything you want to do or keep secret...\n" +
                "Do it here!\n\n" +
                "What would you like to do?");

        choice1.setText("View Journal");
        choice2.setText("View Hidden Inventory");
        choice3.setText("View Messages");
        choice4.setText("Leave");
    }

    public void toServantsQuarters() {
        position = "ServantsQuarters";

        mainTextArea.setText("These are the Servants Quarters\n" +
                "Don't mess with the people who make your food!\n" +
                "...or do. Screw them you're in chanrge!\n\n" +
                "What would you like to do?");

        choice1.setText("Be cool");
        choice2.setText("Be a dick");
        choice3.setText("Talk to someone");
        choice4.setText("Leave");
    }

    public void toTavern() {
        position = "Tavern";

        mainTextArea.setText("Welcome to 'The King's Hearth'\n" +
                "This Tavern is owned by King Roderick\n" +
                "It was founded as a way to make additional\n" +
                "income for the Crown while offering respite\n" +
                "to its loyal followers\n\n" +
                "What would you like to do?");

        choice1.setText("Adjust Prices");
        choice2.setText("Speak to Bartender");
        choice3.setText("Speak to Patron");
        choice4.setText("Leave");
    }

    public void seekCouncil() {
        position = "AdvisorsCouncil";

        mainTextArea.setText("The King has advisors who can offer council in:\n" +
                "Leadership\n" +
                "Finance\n" +
                "Secrets\n" +
                "Law Enforcement\n\n" +
                "Who would you like to speak to?");

        choice1.setText("The Hand of the King");
        choice2.setText("Master of Coin");
        choice3.setText("Master of Whispers");
        choice4.setText("Captain of the Guard");
    }

    public void receiveDignitaries() {
        position = "ReceiveDignitaries";

        mainTextArea.setText("Foreign people with things to say");

        choice1.setText("Thing 1");
        choice2.setText("Thing 2");
        choice3.setText("Thing 3");
        choice4.setText("Thing 4");
    }

    public void hearPeasantry() {
        position = "PeasantryPetition";

        mainTextArea.setText("Poor people have problems");

        choice1.setText("Thing 1");
        choice2.setText("Thing 2");
        choice3.setText("Thing 3");
        choice4.setText("Thing 4");
    }

    public void viewJournal() {
        position = "Journal";

        mainTextArea.setText("It's hard to remember everything luckily\n" +
                "You are one of the few in this age who can read\n" +
                "and write... sort of");

        choice1.setText("Thing 1");
        choice2.setText("Thing 2");
        choice3.setText("Thing 3");
        choice4.setText("Thing 4");
    }

    public void viewHiddenInventory() {
        position = "HiddenInventory";

        mainTextArea.setText("I mean it's called Hidden Inventory\n" +
                "Hide your shit here.");

        choice1.setText("Thing 1");
        choice2.setText("Thing 2");
        choice3.setText("Thing 3");
        choice4.setText("Thing 4");
    }

    public void viewMessages() {
        position = "Messages";

        mainTextArea.setText("You can't always say what you want to say\n" +
                "so write it down. I'm sure it will be fine");

        choice1.setText("Thing 1");
        choice2.setText("Thing 2");
        choice3.setText("Thing 3");
        choice4.setText("Thing 4");
    }

    public void beCool() {
        position = "BeCool";

        mainTextArea.setText("It's good to keep the people who work\n" +
                "for you happy and healthy.\n\n" +
                "What would you like to do?");

        choice1.setText("Thing 1");
        choice2.setText("Thing 2");
        choice3.setText("Thing 3");
        choice4.setText("Thing 4");
    }

    public void beADick() {
        position = "BeADick";

        mainTextArea.setText("The people who work for you need to know\n" +
                "their role and shut their hole!\n\n" +
                "What would you like to do?");

        choice1.setText("Thing 1");
        choice2.setText("Thing 2");
        choice3.setText("Thing 3");
        choice4.setText("Thing 4");
    }

    public void talkToServant() {
        position = "TalkToServant";

        mainTextArea.setText("Someone might know something.\n" +
                "You sure don't seem to yet.");

        choice1.setText("Talk to a Servant");
        choice2.setText("Nothing");
    }

    public void adjustPrices() {
        position = "AdjustTavernPrices";

        mainTextArea.setText("Lower prices increase patron happiness, but\n" +
                "higher prices increase your happiness\n\n" +
                "What would you like to adjust?");

        choice1.setText("Ale");
        choice2.setText("Meade");
        choice3.setText("Daily Special");
        choice4.setText("Nothing");
    }

    public void talkToBartender() {
        position = "TalkToBartender";

        mainTextArea.setText("Bartenders can be a font of knowledge\n" +
                "or booze.\n\n" +
                "What would you like to say?");

        choice1.setText("Give me a drink");
        choice2.setText("Heard any rumors lately?");
        choice3.setText("Seen anything suspicious?");
        choice4.setText("Nothing");
    }

    public void talkToPatron() {
        position = "TalkToPatron";

        mainTextArea.setText("These are the King's loyal subjects.\n" +
                "They are hardworking, humble, and possibly hammered.\n\n" +
                "What would you like to say?");

        choice1.setText("Praise");
        choice2.setText("Insult");
        choice3.setText("Let me buy you a drink.");
        choice4.setText("Nothing");
    }

    public void insultPatron() {
        position = "InsultPatron";

        mainTextArea.setText("Uh oh the drunken patron didn't take your\n" +
                "insult very well. He takes off his shirt and\n" +
                "gets ready to fight!");

        choice1.setText("Fight");
        choice2.setText("Run");
        choice3.setText("");
        choice4.setText("");
    }

    public void fightPatron() {
        position = "FightPatron";

        choice1.setVisible(true);
        choice2.setVisible(true);
        choice4.setVisible(true);

        mainTextArea.setText("Drunken Patron HP: " + patronHP + "\nYour HP: " +
                characterHP + "\nWhat would you like to do?");

        choice1.setText("Punch");
        choice2.setText("Kick");
        choice3.setText("Bite");
        choice4.setText("Run Away");
    }

    public void punch() {
        position = "Punch";

        damageDealt = randomNumber.nextInt(5);
        damageReceived = randomNumber.nextInt(5);
        mainTextArea.setText("You punch the patron for " + damageDealt + " points of damage.");
        patronHP -= damageDealt;
        if(patronHP <= 0) {
            winFight();
        }

        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setText("Continue");
        choice4.setVisible(false);
    }

    public void kick() {
        position = "Kick";

        damageDealt = randomNumber.nextInt(10);
        mainTextArea.setText("You kick the patron in the balls for " + damageDealt + " points of\n" +
                " damage. I think the patron is starting to cry.\n" +
                "He won't fight back this round.");
        patronHP -= damageDealt;
        if(patronHP <= 0) {
            winFight();
        }

        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setText("Continue");
        choice4.setVisible(false);
    }

    public void bite() {
        position = "Bite";

        damageDealt = randomNumber.nextInt(8);
        damageReceived = randomNumber.nextInt(4);
        mainTextArea.setText("You bite the patron for " + damageDealt + " damage.");
        patronHP -= damageDealt;
        if(patronHP <= 0) {
            winFight();
        }

        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setText("Continue");
        choice4.setVisible(false);
    }
    public void patronHaymaker() {
        position = "PatronHaymaker";

        damageReceived = randomNumber.nextInt(8);
        mainTextArea.setText("The patron throws a wild looping haymaker.\n" +
                "You take " + damageReceived + " points of damage");
        characterHP -= damageReceived;
        if(characterHP <= 0) {
            loseFight();
        }else fightPatron();
    }
    public void winFight() {

    }
    public void loseFight() {
        position = "LoseFight";

        mainTextArea.setText("Wow. You were supposed to save the country\n" +
                "and you died in a bar fight with a drunken\n" +
                "peasant.\n\n" +
                "\tGAME OVER\n" +
                "\tTry Again");
    }


    public class TitleScreenHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            createGameScreen();
        }
    }

    public class ChoiceHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String yourChoice = event.getActionCommand();

            switch (position) {
                case "WelcomeRoom":
                    switch (yourChoice) {
                        case "c1":
                            toThroneRoom();
                            break;
                        case "c2":
                            toBedChamber();
                            break;
                        case "c3":
                            toServantsQuarters();
                            break;
                        case "c4":
                            toTavern();
                            break;
                    }
                    break;
                case "ThroneRoom":
                    switch (yourChoice) {
                        case "c1":
                            seekCouncil();
                            break;
                        case "c2":
                            receiveDignitaries();
                            break;
                        case "c3":
                            hearPeasantry();
                            break;
                        case "c4":
                            welcomeRoom();
                            break;
                    }
                    break;
                case "BedChamber":
                    switch (yourChoice) {
                        case "c1":
                            viewJournal();
                            break;
                        case "c2":
                            viewHiddenInventory();
                            break;
                        case "c3":
                            viewMessages();
                            break;
                        case "c4":
                            welcomeRoom();
                            break;
                    }
                    break;
                case "ServantsQuarters":
                    switch (yourChoice) {
                        case "c1":
                            beCool();
                            break;
                        case "c2":
                            beADick();
                            break;
                        case "c3":
                            talkToServant();
                            break;
                        case "c4":
                            welcomeRoom();
                            break;
                    }
                    break;
                case "Tavern":
                    switch (yourChoice) {
                        case "c1":
                            adjustPrices();
                            break;
                        case "c2":
                            talkToBartender();
                            break;
                        case "c3":
                            talkToPatron();
                            break;
                        case "c4":
                            welcomeRoom();
                            break;
                    }
                    break;
                case "AdvisorsCouncil":
                    switch (yourChoice) {
                        case "c1":
                            break;
                        case "c2":
                            break;
                        case "c3":
                            break;
                        case "c4":
                            toThroneRoom();
                            break;
                    }
                    break;
                case "ReceiveDignitaries":
                    switch (yourChoice) {
                        case "c1":
                            break;
                        case "c2":
                            break;
                        case "c3":
                            break;
                        case "c4":
                            toThroneRoom();
                            break;
                    }
                    break;
                case "PeasantryPetition":
                    switch (yourChoice) {
                        case "c1":
                            break;
                        case "c2":
                            break;
                        case "c3":
                            break;
                        case "c4":
                            toThroneRoom();
                            break;
                    }
                    break;
                case "Journal":
                    switch (yourChoice) {
                        case "c1":
                            break;
                        case "c2":
                            break;
                        case "c3":
                            break;
                        case "c4":
                            toBedChamber();
                            break;
                    }
                    break;
                case "HiddenInventory":
                    switch (yourChoice) {
                        case "c1":
                            break;
                        case "c2":
                            break;
                        case "c3":
                            break;
                        case "c4":
                            toBedChamber();
                            break;
                    }
                    break;
                case "Messages":
                    switch (yourChoice) {
                        case "c1":
                            break;
                        case "c2":
                            break;
                        case "c3":
                            break;
                        case "c4":
                            toBedChamber();
                            break;
                    }
                    break;
                case "BeCool":
                    switch (yourChoice) {
                        case "c1":
                            break;
                        case "c2":
                            break;
                        case "c3":
                            break;
                        case "c4":
                            toServantsQuarters();
                            break;
                    }
                    break;
                case "BeADick":
                    switch (yourChoice) {
                        case "c1":
                            break;
                        case "c2":
                            break;
                        case "c3":
                            break;
                        case "c4":
                            toServantsQuarters();
                            break;
                    }
                    break;
                case "TalkToServant":
                    switch (yourChoice) {
                        case "c1":
                            break;
                        case "c2":
                            break;
                        case "c3":
                            break;
                        case "c4":
                            toServantsQuarters();
                            break;
                    }
                    break;
                case "AdjustTavernPrices":
                    switch (yourChoice) {
                        case "c1":
                            break;
                        case "c2":
                            break;
                        case "c3":
                            break;
                        case "c4":
                            toTavern();
                            break;
                    }
                    break;
                case "TalkToBartender":
                    switch (yourChoice) {
                        case "c1":
                            break;
                        case "c2":
                            break;
                        case "c3":
                            break;
                        case "c4":
                            toTavern();
                            break;
                    }
                    break;
                case "TalkToPatron":
                    switch (yourChoice) {
                        case "c1":
                            break;
                        case "c2":
                            insultPatron();
                            break;
                        case "c3":
                            break;
                        case "c4":
                            toTavern();
                            break;
                    }
                    break;
                case "InsultPatron":
                    switch (yourChoice) {
                        case "c1":
                            fightPatron();
                            break;
                        case "c2":
                            welcomeRoom();
                            break;
                        case "c3":
                            break;
                        case "c4":
                            break;
                    }
                    break;
                case "FightPatron":
                    switch (yourChoice) {
                        case "c1":
                            punch();
                            break;
                        case "c2":
                            kick();
                            break;
                        case "c3":
                            bite();
                            break;
                        case "c4":
                            welcomeRoom();
                            break;
                    }
                case "Punch":
                    switch (yourChoice) {
                        case "c3":
                            patronHaymaker();
                            break;
                    }
                    break;
                case "Kick":
                    switch (yourChoice) {
                        case "c3": fightPatron(); break;
                    }
                    break;
                case "Bite":
                    switch (yourChoice) {
                        case "c3": patronHaymaker(); break;
                    }
                    break;
                case "PatronHaymaker":
                    switch (yourChoice) {
                        case "c3": fightPatron(); break;
                    }

            }
        }
    }


}


