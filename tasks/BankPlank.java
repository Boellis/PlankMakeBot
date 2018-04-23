package Boellis_PlankMake.tasks;

import org.powerbot.script.rt4.Magic.Spell;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.*;
import Boellis_PlankMake.Antiban;
import osrs.Task;
import org.powerbot.script.rt4.Npc;
import org.powerbot.script.rt4.Game.Tab;
import org.powerbot.script.PollingScript;
import Boellis_PlankMake.tasks.MakePlank;



import java.util.concurrent.Callable;
import java.awt.*;


public class BankPlank extends Boellis_PlankMake.Task {

    //PvP Camelot Bank Chest ID
    final static int camelotBankChest = 4483;
    //final static int camelotBankChest = 7414;

    public Boolean bankStatus = false;

    //Log Variables
    final static int TEAKLOG = 6333;
    final static int OAKLOG = 1521;
    final static int MAHOGANYLOG = 6332;

    private int switcher = 0;

    //Antiban object
    Antiban antiban = new Antiban(new ClientContext(ctx));

    public BankPlank(ClientContext ctx)  {
        super(ctx);
    }

    @Override
    public boolean active() {

        //Activates the task if the bank is in viewport, remains nonactive when not at the bank.
       if(ctx.bank.present()){
           System.out.println("Activated BankPlank");
           bankStatus = true;
       } else {
           System.out.println("BankPlank is not running");
           bankStatus = false;
       }
       System.out.println("The Current BankPlank status is: " + bankStatus);
       return  bankStatus;

    }

    @Override
    public void execute() {
        //Runs the getPlanks method once the script is active
        getPlanks();
    }

    private void HouseTeleport() {
        final GameObject homePortal = ctx.objects.select().id(11242).nearest().poll();

        //Opens Magic tab
        ctx.game.tab(Game.Tab.MAGIC);

        //Casts Camelot Teleport
        ctx.magic.cast(Spell.TELEPORT_TO_HOUSE);

        //Waits 300 milliseconds after attempting to teleport home before trying again
        //Stops trying after 5 times or if the home portal is in the viewport
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                //Returns a true value when the player has the home portal in the viewport and throws the exception
                return homePortal.inViewport();
            }
        }, 300, 5);
        antiban.antiban(250,350);
    }

    public void getPlanks(){
        //Camelot Bankchest on PVP Worlds
        GameObject bankChest = ctx.objects.select().id(camelotBankChest).nearest().poll();

        System.out.println("There is a bank present");
        //Selects the bank
        bankChest.interact("Use");
        System.out.println("Selected Use option on bank chest at Camelot");
        antiban.antiban(1100,1300);

        if(ctx.inventory.select().count() > 5){
            //Deposits the entire inventory
            ctx.bank.depositInventory();
            System.out.println("Deposited the inventory");
            antiban.antiban(1000,1250);
        }
        //Withdraws all logs
        ctx.bank.withdraw(OAKLOG, Bank.Amount.ALL);
        System.out.println("Withdraw All Log");
        antiban.antiban(900,1180);
        //If the inventory is full of logs, closes the bank and teleports home
        //If the inventory is not full, it will attempt to withdraw all of the logs again before teleporting home
        if(ctx.inventory.select().id(OAKLOG).count() > 24){
            ctx.bank.close();
            System.out.println("Close bank");
            antiban.antiban(770,880);
            HouseTeleport();
            //Condition.sleep(4000);
        } else {
            ctx.bank.withdraw(OAKLOG, Bank.Amount.ALL);
            System.out.println("Withdraw All Log because inventory was not full");
            ctx.bank.close();
            antiban.antiban(800,900);
            HouseTeleport();
            Condition.sleep(500);
        }
    }
    //Changes the possibilties for how broad the antiban is
    public void setSwitcher(int s) {
        switcher = s;
    }

    public int getSwitcher() {
        return switcher;
    }
} // End of BankPlank Class
