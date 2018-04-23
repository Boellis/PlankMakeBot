package Boellis_PlankMake.AntibanAttributes;

import Boellis_PlankMake.Antiban;
import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt4.Game;
import org.powerbot.script.rt4.ClientContext;


public class Misc extends Antiban{
    public Misc(ClientContext ctx){
        super(ctx);
    }
    public int randomizerFive = Random.nextInt(1,5);
    public int randomizerFifteen = Random.nextInt(1,15);
    public int randomizerThirty = Random.nextInt(1,30);

    //public static void speak(){}
    public void speak(){
        //--------------Done--------------
        switch(randomizerThirty) {
            //ctx theClientContext = Antiban.getCtx();
            default:
                Condition.sleep(org.powerbot.script.Random.nextInt(500, 900));
                break;
            case 1:
                ctx.chat.sendInput("Hey");
                break;
            case 2:
                ctx.chat.sendInput("Kill me");
                break;
            case 3:
                ctx.chat.sendInput("This is tiring");
                break;
            case 4:
                ctx.chat.sendInput("Cheese Potato");
                break;
            case 5:
                ctx.chat.sendInput("Rotel Dip");
                break;
            case 6:
                ctx.chat.sendInput("Poop Stain");
                break;
            case 7:
                ctx.chat.sendInput("Bropotato");
                break;
        }//End of switch statement
    }//End of speak function

    public void run(){
        widgetBuilder(160,Random.nextInt(21,27));
    }

    public void checkFriendsList(){
        //----------------------Done--------------
        //Determines how to open the smiley tab
        switch(randomizerFive){
            default:
                //Method for opening friends tab
                ctx.game.tab(Game.Tab.FRIENDS_LIST);
                break;
            case 1:
                //Widget for friends Tab
                widgetBuilder(161,36,400,700);
                break;
            case 2:
                //Widget for friends Tab 2
                widgetBuilder(161,43,400,700);
        }
        Condition.sleep(org.powerbot.script.Random.nextInt(1200,1800));

        switch(randomizerThirty) {
            default:
                Condition.sleep(org.powerbot.script.Random.nextInt(950,1500));
                break;
            case 1:
                //Widget for add friend
                widgetBuilder(429,Random.nextInt(11,12));
                break;
            case 2:
                //Widget for delete friend
                widgetBuilder(429,Random.nextInt(13,14));
                break;
        }
        //Click on add friend
        //Add a random name
        //Created function to randomly generate numbers, convert them to strings and concatenate
        //name it name generator -- only generates numbers with numbers
        //Clicks on remove friend
        //Removes random name
        //Attempts to remove random name even if it doesnt exist on friends list
    }

    public void checkIgnoreList() {
        //Determines how to open the frowny tab
        switch(randomizerFive){
            default:
                //Method for opening friends tab
                ctx.game.tab(Game.Tab.IGNORED_LIST);
                break;
            case 1:
                //Widget for Ignore Tab
                widgetBuilder(161,37,400,700);
                break;
            case 2:
                //Widget for Ignore Tab 2
                widgetBuilder(161,44,400,700);
        }
        switch(randomizerThirty) {
            default:
                Condition.sleep(org.powerbot.script.Random.nextInt(950,1500));
                break;
            case 1:
                //Add Name
                widgetBuilder(432,Random.nextInt(10,11));
                break;
            case 2:
                //Remove Name
                widgetBuilder(432,Random.nextInt(12,13));
                break;

        }
    }

    public void checkEquipment(){
        //-----------------Completed, Needs to close screens-----------------
        //Opens equipment tab
        ctx.game.tab(Game.Tab.EQUIPMENT);
        Condition.sleep(org.powerbot.script.Random.nextInt(950,1500));

        //Selects and clicks equipment tab
        //widgetBuilder(161,55);

        switch(randomizerFifteen) {
            default:
                Condition.sleep(org.powerbot.script.Random.nextInt(1834,2103));
                break;
            case 1:
                //Selects and clicks price checker
                widgetBuilder(387,20);
                Condition.sleep(org.powerbot.script.Random.nextInt(1650,1900));
                //Adds all to Price checker for price check
                widgetBuilder(464,10);
                Condition.sleep(org.powerbot.script.Random.nextInt(1500,1900));
                //Closes out of screen
                widgetBuilder(464,1,11,300,500);
                break;
            case 2:
                //Checks items kept on death
                widgetBuilder(387,21);
                //Closes out of screen
                widgetBuilder(4,13,400,700);
                break;
            case 3:
                //Checks current armor worn
                widgetBuilder(387,Random.nextInt(17,18));
                //Closes out of screen
                widgetBuilder(84,4,400,700);
                break;
            case 4:
                //Clicks call follower
                widgetBuilder(387,Random.nextInt(23,24));
                break;
        }
    }

    public void xpAlter() {
        //------------------------Done------------------
        //Hovers and clicks on xp counter
        widgetBuilder(160,1);
        Condition.sleep(org.powerbot.script.Random.nextInt(810, 1510));
    }

    public void checkClanChat(){
        //Selects clan chat tab
        ctx.game.tab(Game.Tab.CLAN_CHAT);

//        //Widget for clanchat
//        widgetBuilder(161,35);

        //Selects option to either leave or join a clan
        switch (randomizerThirty){
            default:
                Condition.sleep(org.powerbot.script.Random.nextInt(1000,2500));
                break;
            case 1:
                //Widget that clicks on join/leave chat in cc
                widgetBuilder(7,17);
                break;
            case 2:
                //Widget for clan setup
                widgetBuilder(7,Random.nextInt(18,19));
                break;
        }
    }

    public void checkCombatStyle() {
        //-----------------------------Done--------------
        //Selects an attack style from the combat style menu
        switch(randomizerFive){
            default:
                //Clicks Accuate
                widgetBuilder(593,Random.nextInt(3,6));
                break;
            case 1:
                //Click rapid
                widgetBuilder(593,Random.nextInt(7,9));
                break;
            case 2:
                //Click longrange
                widgetBuilder(593,Random.nextInt(11,18));
                break;
            case 3:
                //Click Autoretaliate
                widgetBuilder(593,Random.nextInt(27,28));
                break;
            case 4:
                Condition.sleep(org.powerbot.script.Random.nextInt(1670,1982));
                break;
        }
    }

    public void checkMusic(){
        //-------------------Completed, Not Done----------------
        //click on tab
        ctx.game.tab(Game.Tab.MUSIC);

//        //widget for music
//        widgetBuilder(161,41);

        //change the song

        //Clicks the down arrow to scroll in music tab
        widgetBuilder(239,4,5,2100,2500);

        //Clicks the up arrow to scroll in music tab
        widgetBuilder(239,4,5,2100,2500);
//
//        //Clicks the manual button on music tab
//        widgetBuilder(239,10,200,400);
//
//        //Clicks the auto button on music tab
//        widgetBuilder(239,8,200,400);
//
//        //Clicks different part of the loop button on music tab
//        widgetBuilder(239,Random.nextInt(11,12),200,400);
    }

    public void checkChatOptions() {
        //----------------------------------Done----------------------------------
        switch(randomizerFifteen) {
            default:
                Condition.sleep(org.powerbot.script.Random.nextInt(1143,1910));
                break;
            case 1:
                //All
                widgetBuilder(162,Random.nextInt(3,5),200,400);
                break;
            case 2:
                //Game
                widgetBuilder(162,Random.nextInt(6,9),200,400);
                break;
            case 3:
                //Public
                widgetBuilder(162,Random.nextInt(10,13),200,400);
                break;
            case 4:
                //Private
                widgetBuilder(162,Random.nextInt(14,17),200,400);
                break;
            case 5:
                //Clan
                widgetBuilder(162,Random.nextInt(18,21),200,400);
                break;
            case 6:
                //Trade
                widgetBuilder(162,Random.nextInt(22,25),200,400);
                break;
        }
        Condition.sleep(org.powerbot.script.Random.nextInt(950,1150));
        //Report
        //widgetBuilder(162,Random.nextInt(26,28),200,400);

    }

    public void checkQuest() {
        //-----------------Completed, not Done-----------
        //Opens Quest tab
        ctx.game.tab(Game.Tab.QUESTS);

        //Randomly selects one of the 116 quests to click on
        widgetBuilder(399,8,Random.nextInt(0,115));

        //Closes quest screen
        widgetBuilder(275,134,500,1000);
    }

    public void checkQuickPray() {
        //-------------------Done------------
        //Clicks on the quick prayer button
        widgetBuilder(160,Random.nextInt(14,19),700,1000);
    }

    public void checkInventory() {
        //-----------------Done---------------------------
        //Determines how to open the Inventory tab
        switch(randomizerFive){
            default:
                //Method for opening Inventory Tab
                ctx.game.tab(Game.Tab.INVENTORY);
                break;
            case 1:
                //Widget for Inventory Tab2
                widgetBuilder(161,54,400,700);
                break;
            case 2:
                //Widget for Inventory Tab 3
                widgetBuilder(161,61,400,700);
        }
        Condition.sleep(org.powerbot.script.Random.nextInt(1750,2750));
    }

    public void checkLogout() {
        //-----------------Complete, not Done----------------------
        //Opens Logout tab
        ctx.game.tab(Game.Tab.LOGOUT);
        Condition.sleep(org.powerbot.script.Random.nextInt(1100,1834));

        //Switch Worlds

        //Logout

        //Widget for logout tab
        //widgetBuilder(161,38);
    }

    public void checkWorldMap() {
        //---------------Complete, not Done-------------------------00
        //Opens the world map
        widgetBuilder(28,29);
        Condition.sleep(org.powerbot.script.Random.nextInt(1450,1980));
        //Closes the world map
        widgetBuilder(595,34);

        /*
        //Shows Clue Scroll Overview
        widgetBuilder(595,25);

        //Zooms in on the map
        widgetBuilder(595,24);

        //Zooms out of the map
        widgetBuilder(595,23);

        //Chooses which view on Runescape to display on the map
        widgetBuilder(595,22,Random.nextInt(0,4),200,200);
        */
    }

    public void checkSettings() {
        //---------------------Done-------------------------
        //Opens Options Tab
        ctx.game.tab(Game.Tab.OPTIONS);

        //Chooses what to select once at the options tab
        switch(randomizerThirty){
            default:
                Condition.sleep(org.powerbot.script.Random.nextInt(2000,3300));
                break;
            case 1:
                //Fixed Mode
                widgetBuilder(261,19);
                break;
            case 2:
                //Run Energy
                widgetBuilder(261,Random.nextInt(74,76));
                break;
            case 3:
                //House Options
                widgetBuilder(261,Random.nextInt(77,78));
                break;
            case 4:
                //Old School Bonds
                widgetBuilder(261,Random.nextInt(79,80));
                break;
            case 5:
                //0,1-Display --- 2,3-Audio --- 3,4-Chat --- 5,6-Controls
                widgetBuilder(261,1,Random.nextInt(0,7),600,800);
                break;
            case 6:
                //Accept Aid
                widgetBuilder(261,Random.nextInt(72,73));
                break;
            case 7:
                //Advanced Options
                widgetBuilder(261,21);
                break;
            case 99:
                //Expand game
                widgetBuilder(261,20);
                break;
        }
    }

    public void checkSpells() {
        //---------------------------Done--------------
        //Opens the magic game tab
        ctx.game.tab(Game.Tab.MAGIC);
        Condition.sleep(org.powerbot.script.Random.nextInt(1600,2500));
    }

}
