package Boellis_PlankMake.tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.Filter;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.*;
import org.powerbot.script.rt4.Component;
import osrs.Task;
import org.powerbot.script.rt4.Npc;
import org.powerbot.script.Random;
import Boellis_PlankMake.Antiban;
import Boellis_PlankMake.tasks.BankPlank;
import z.Con;


//import java.util.Randomm;
import javax.sound.midi.SysexMessage;
import java.awt.*;
import java.util.concurrent.Callable;

import java.io.*;

public class MakePlank extends Boellis_PlankMake.Task {

    //Demon Butler Variable
    final static int BUTLER = 229;

    private int switcher = 0;


    //Widgets Navigating Butler Interaction
    public Component TakeSawmill = ctx.widgets.component(219, 0).component(1);
    public Component ConfirmPrice = ctx.widgets.component(231, 0);
    public Component ConvertPlank = ctx.widgets.component(219, 0).component(0);
    public Component ClickToContinue = ctx.widgets.component(231, 0);
    public Component HouseOption = ctx.widgets.component(261, 76);

    //Antiban object
    Antiban antiban = new Antiban(new ClientContext(ctx));

    public MakePlank(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean active() {
        return homeIsNear();
    }

    @Override
    public void execute() {
        System.out.println("Executing MakePlank Script ");
        callButler();
        Condition.sleep(org.powerbot.script.Random.nextInt(890, 1110));
        selectButler();
        Condition.sleep(org.powerbot.script.Random.nextInt(800, 1020));
        System.out.println("Selected Butler");
        butlerInteraction();
        Condition.sleep(org.powerbot.script.Random.nextInt(950, 1200));
        System.out.println("Interacted with Butler");
        CamelotTeleport();
        System.out.println("Teleported to Camelot");
        antiban.execute(600, 900);

        //Condition that checks make sure that the inventory isn't full. If it isn't full, continue dropping until empty
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.bank.present();
            }
        }, 1100, 3);
    }

    private void butlerInteraction() {

        //If the option "Take to Sawmill: 25 x Logs" is onscreen, press 1 and wait 750 milliseconds before checking again. Check 3 times
        if (TakeSawmill.visible()) {
            ctx.input.send("1");

            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return ConfirmPrice.visible();
                }
            }, 750, 3);
            System.out.println("Clicks Take to sawmill");

            //Checks to make sure confirm price is on screen and presses space to confirm the price
            if (ConfirmPrice.visible()) {
                ctx.input.send("{VK_SPACE}");

                Condition.wait(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return ConvertPlank.visible();
                    }
                }, 750, 3);

                System.out.println("Presses space key to confirm price");

                //Checks to make sure the convert plank validation is onscreen and presses 1 to confirm
                if (ConvertPlank.visible()) {
                    ctx.input.send("1");

                    Condition.wait(new Callable<Boolean>() {
                        @Override
                        public Boolean call() throws Exception {
                            return ClickToContinue.visible();
                        }
                    }, 750, 3);

                    //Checks to make sure that the final confirmation with butler is onscreen and presses space to finish interacting
                    if (ClickToContinue.visible()) {
                        ctx.input.send("{VK_SPACE}");
                    }
                }
            }
        } else {
            //If the option to take logs to the sawmill is not avaiable, try to select the butler again
            selectButler();
        }
    }

    private void CamelotTeleport() {

        //Opens Magic tab
        ctx.game.tab(Game.Tab.MAGIC);

        //Waits 200 milliseconds after selecting magic tab before clicking camelot teleport
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.game.tab(Game.Tab.MAGIC);
            }
        }, 500, 5);

        //Casts Camelot Teleport
        ctx.magic.cast(Magic.Spell.CAMELOT_TELEPORT);
    }

    private void selectButler() {

        final Npc demonButler = ctx.npcs.select().id(BUTLER).select().nearest().poll();
        demonButler.interact("Talk-to");

        //Waits 500 milliseconds before clicking the demon butler if he is in view
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return demonButler.inViewport();
            }
        }, 500, 3);
    }

    public void callButler() {
        //Opens the options game tab
        ctx.game.tab(Game.Tab.OPTIONS);

        if (HouseOption.visible()) {
            Condition.sleep(org.powerbot.script.Random.nextInt(600, 750));
            System.out.println("House Option Visible");
            //Clicks on House Option
            ctx.widgets.component(261, Random.nextInt(77,78)).click();
            Condition.sleep(org.powerbot.script.Random.nextInt(800, 910));
            //Clicks on Call Servant
            ctx.widgets.component(370, 15).click();
            Condition.sleep(org.powerbot.script.Random.nextInt(600, 770));

        } else {
            System.out.println("Call Butler Failed because we are not in the Tab Tab");
            //Click on Settings tab
            ctx.widgets.component(161, 39).click();
        }
    }

    public boolean homeIsNear() {
        if (!ctx.bank.inViewport()) {
            System.out.println("Bank was not in viewport");
            return true;
        } else {
            System.out.println("Bank is still in viewport --- make plank");
            return false;
        }
    }

    //Changes the possibilties for how broad the antiban is
    public void setSwitcher(int s) {
        switcher = s;
    }

    public int getSwitcher() {
        return switcher;
    }

}

