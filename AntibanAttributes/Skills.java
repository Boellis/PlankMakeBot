package Boellis_PlankMake.AntibanAttributes;

import Boellis_PlankMake.Antiban;
import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt4.Game;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Magic.Spell;
import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.Filter;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.*;

public class Skills extends Antiban{
    public int randomizerFive = Random.nextInt(1,5);
    public int randomizerFifteen = Random.nextInt(1,15);
    public int randomizerThirty = Random.nextInt(1,30);

    public Skills(ClientContext ctx){
        super(ctx);
    }

    //Antiban method that checks the prayer tab
    public void checkPraySkill() {
        //----------------------------------Done---------------------------------------//
        //switch statement to determine whether to click the prayer tab or to check the prayer skill. Only one or the other
        int prayRandomizer = Random.nextInt(1,2);
        switch (prayRandomizer){
            default:
                break;
            case 1:
                // Opens Prayer Tab
                widgetBuilder(161,56);
                //Clicks on thick skin
                //4 - 32 works for prayers ..541,1-32
                //Randomly clicks on a prayer in the prayer tab
                widgetBuilder(541,Random.nextInt(1,32),400,700);
        }

        //Checks to see if screen with skill tabs is open, if not:
        if (!ctx.widgets.component(320, 0).inViewport()) {
            //Opens Skills Tab
            widgetBuilder(161,52,1200,1500);
        }

        Condition.sleep(org.powerbot.script.Random.nextInt(500, 7000));
        //Prayer Skill Tab 1-5
        ctx.widgets.component(320, 5).hover();
        ctx.widgets.component(320, 5).click();
        Condition.sleep(org.powerbot.script.Random.nextInt(980, 1205));
        //Prayer Screen 11-prayers, 12-Equipment, 13-Other
        ctx.widgets.component(214,12).click();
        Condition.sleep(org.powerbot.script.Random.nextInt(1000, 1300));
        //Exits Prayer Screen
        ctx.widgets.component(214,25).click();
    }// End of checkPraySkill Function

    public void checkMagic() {
        //----------------------------------Done---------------------------------------//
        //Opens Skills Tab
        ctx.game.tab(Game.Tab.STATS);
        //widgetBuilder(161,52,1200,1500);

        //Hovers and Clicks on Magic Skill
        widgetBuilder(320,6,1100,1800);
        Condition.sleep(org.powerbot.script.Random.nextInt(800,1000));

        //Clicks between 11-Normal Spells, 12-Ancient Magicks, 13-Lunar Spells, 14-Arceus Spells, 15-Armour, 16-Weapons, 17-Equipment, 18-Salamanders
        widgetBuilder(214,Random.nextInt(11,19),800,1400);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkHerb() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks on the herb skill
        widgetBuilder(320,6,1200,2000); //Does not have the correct widget
        Condition.sleep(org.powerbot.script.Random.nextInt(800,1000));

        //Clicks between 11-Potions, 12-Herbs, 13-Barbarian Potions, 14-Raids, 15-Other
        widgetBuilder(214,Random.nextInt(11,15),750,1500);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkFish() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks over the skill
        widgetBuilder(320,19,1000,1500);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Catches, 12-Barbarian, 13- Equipment, 14-Raids, 15-Other
        widgetBuilder(214,Random.nextInt(11,15),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkSlayer() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks on the slayer skill
        widgetBuilder(320,15,1150,1890);
        Condition.sleep(org.powerbot.script.Random.nextInt(1300,1600));

        //Clicks between 11-Monsters, 12-Equipment, 13- Slayer Masters
        widgetBuilder(214,Random.nextInt(11,13),550,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkSmithing() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks on the smithing skill
        widgetBuilder(320,18,1230,1670);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1640));

        //Clicks between 11-Burning, 12-Barbarian, 13-Equipment
        widgetBuilder(214,Random.nextInt(11,13),600,1100);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }
    public void checkFiremaking() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks on firemaking skill
        widgetBuilder(320,21,1345,1832);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Smelting, 12-Bronze, 13-Blurite, 14-Iron, 15-Steel, 16-Mithril, 17-Adamant, 18-Rune, 19-Lovakite, 20-Other
        widgetBuilder(214,Random.nextInt(11,20),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkHitpoints() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks on  hitpoints skill
        widgetBuilder(320,9,1425,1912);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Hitpoints, 12-Healing, 13-Equipment
        widgetBuilder(214,Random.nextInt(11,13),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkRange() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Cliciks on range skill
        widgetBuilder(320,4,1201,1502);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Bows, 12-Thrown, 13-Crossbows, 14-Armour, 15-Miscellaneous, 16-Shortcuts, 17-Salamanders
        widgetBuilder(214,Random.nextInt(11,27),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();


    }

    public void checkMining() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers over the skill
        widgetBuilder(320,17,1123,1560);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Rocks, 12-Equipment
        widgetBuilder(214,Random.nextInt(11,12),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkRunecrafting() {
        //-------------------------Done---------------------
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers over the Runecrafting skill 7.1-4
        //Clicks on a specific location within Runecrafting skill tab
        //widgetBuilder(320,7,1,300,800);
        widgetBuilder(320,7,300,800);
        Condition.sleep(org.powerbot.script.Random.nextInt(600,800));

        //Runecrafting Screen 11-Runes, 12-Multiple Runes, 13-Rune Pouches, 14- Infusing
        widgetBuilder(214,Random.nextInt(11,14),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();

        //Click the skill and scrolls to the bottom
        //Clicks on option(Switch)
    }

    public void checkAttack(){
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks on attack skill
        widgetBuilder(320,1,1204,1553);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Weapons, 12-Armour, 13-Salamanders
        widgetBuilder(214,Random.nextInt(11,13),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkStrength() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks on strength skill
        widgetBuilder(320,2,1049,1494);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Weapons, 12-Armour, 13-Shortcuts, 14-Areas, 15-Barbarian
        widgetBuilder(214,Random.nextInt(11,15),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkDefence() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks defence skill
        widgetBuilder(320,3, 1190,1489);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Armour, 12-Penance, 13-Prayers, 14-Shields
        widgetBuilder(214,Random.nextInt(11,14),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkAgility() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks agility skill
        widgetBuilder(320,10,1049,1645);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Courses, 12-Areas, 13-Shortcuts, 14-Barbarian
        widgetBuilder(214,Random.nextInt(11,14),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkWoodCutting() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks woodcutting skill
        widgetBuilder(320,22,931,1323);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Trees, 12-Axes, 13-Other
        widgetBuilder(214,Random.nextInt(11,13),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkThieving() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks on thieving skill
        widgetBuilder(320,12,849,1920);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Picketpocket, 12-Stalls, 13-Chests, 14-Other
        widgetBuilder(214,Random.nextInt(11,14),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkCrafting() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks on crafting skill
        widgetBuilder(320,13,938,1230);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Weaving, 12-Armour, 13-Spinning, 14-Pottery, 15-Glass, 16-Jewellery, 17-Weaponry, 18-Other
        widgetBuilder(214,Random.nextInt(11,18),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkFletching() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks on fletching skill
        widgetBuilder(320,14,1202,1402);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Picketpocket, 12-Stalls, 13-Chests, 14-Other
        widgetBuilder(214,Random.nextInt(11,14),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkHunter() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks on hunter skill
        widgetBuilder(320,16,879,1903);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Tracking, 12-Birds, 13-Butterflies, 14-Implings, 15-Deadfall, 16-Box Trap, 17-Net Trap, 18-Pitfalls, 19-Falconry, 20-Traps, 21-Clothing, 22-Raids, 23-Birdhouses, 24-Other
        widgetBuilder(214,Random.nextInt(11,24),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkCooking() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks on cooking skill
        widgetBuilder(320,20,1230,1780);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Meats, 12-Bread, 13-Pies, 14-Stews, 15-Pizzas, 16-Cakes, 17-Wine, 18-Hot Drinks, 19-Brewing, 20-Vegetable, 21-Dairy, 22-Gnome, 23-Raids
        widgetBuilder(214,Random.nextInt(11,23),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkFarming() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks on farming skill
        widgetBuilder(320,23,948,1934);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Allotments, 12-Hops, 13-Trees, 14-Fruit Trees, 15-Bushes, 16-Flowers, 17-Herbs, 18-Special, 19-Scarecrows, 20-Multiple Roots, 21-Tithe Farm, 22-Raids
        widgetBuilder(214,Random.nextInt(11,22),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkConstruction() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks on construction skill
        widgetBuilder(320,8,1300,1714);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Rooms, 12-Skills, 13-Surfaces, 14-Storage, 15-Decorative, 16-Trophies, 17-Games, 18-Garden, 19-Dungeon, 20-Chapel, 21-Raids, 22-Other, 23-Servants, 24-House Size
        widgetBuilder(214,Random.nextInt(11,22),900,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkTotal() {
        //--------------------------Done--------------------
        ctx.widgets.component(320,Random.nextInt(24,27)).hover();
        Condition.sleep(org.powerbot.script.Random.nextInt(800,1100));
    }

//    //Widget builder that creates, hovers, and clicks widgets
//    public void widgetBuilder(int x, int y) {
//        ctx.widgets.component(x,y).hover();
//        ctx.widgets.component(x,y).click();
//    }
//
//    //Widget builder than handles subcomponents within widgets; creates, hovers, and clicks widegets
//    public void widgetBuilder(int x, int y, int z) {
//        ctx.widgets.component(x,y).component(z).hover();
//        ctx.widgets.component(x,y).component(z).click();
//    }
//
//    //Widget builder that creates, hovers, and clicks widgets, but pauses between hovering and clicking
//    public void widgetBuilder(int x, int y, int min, int max) {
//        ctx.widgets.component(x,y).hover();
//        Condition.sleep(org.powerbot.script.Random.nextInt(min,max));
//        ctx.widgets.component(x,y).click();
//    }
//    //Widget builder with subcomponents that creates, hovers, and clicks widgets, but pauses between hovering and clicking
//    public void widgetBuilder(int x, int y, int z, int min, int max) {
//        ctx.widgets.component(x,y).component(z).hover();
//        Condition.sleep(org.powerbot.script.Random.nextInt(min,max));
//        ctx.widgets.component(x,y).component(z).click();
//    }
}
