package Boellis_PlankMake;


import Boellis_PlankMake.tasks.BankPlank;
import Boellis_PlankMake.tasks.MakePlank;
import org.powerbot.script.PaintListener;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.Constants;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Script.Manifest(name="Boellis_LetsMakePlanks", description="Using the Home/Camelot Teleport & Demon Butler to Make Oak Planks",properties="client=4; author=Brandon; topic=999;")

public class LetsMakePlanks extends PollingScript<ClientContext> implements PaintListener{

    //Array list to hold tasks for plank maker i.e Banking Planks, Making Planks, etc.
    List<Task> taskList = new ArrayList<Task>();

    //***Rendering, Color , Stroke, & Font Variables from Easel***//

    //Rendering
    private final RenderingHints antialiasing = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

    //Color
    private final Color color1 = new Color(153, 153, 153);
    private final Color color2 = new Color(0, 51, 51);
    private final Color color3 = new Color(48, 169, 169);
    private final Color color4 = new Color(51, 0, 51);
    private final Color color5 = new Color(255, 255, 255);
    private final Color color6 = new Color(204, 204, 204);

    //Stroke
    private final BasicStroke stroke1 = new BasicStroke(1);

    //Font
    private final Font font1 = new Font("Juice ITC", 1, 25);
    private final Font font2 = new Font("Juice ITC", 1, 20);


    @Override
    public void start(){

        //Adds the BankPlank class to our task list
        taskList.add(new BankPlank(ctx));

        //Adds the MakePlank class to our task list
        taskList.add(new MakePlank(ctx));
    }

    @Override
    public void poll() {
        //For every task in the task list
        for(Task task : taskList){

            //Stop looping if the program is stopped
            if(ctx.controller.isStopping()){
                break;
            }
            //If the task in the task list is active in the loop, that program will be executed
            if(task.active()){
                task.execute();
                break;
            }
        }
    }

    @Override
    public void repaint(Graphics graphics) {
        long milliseconds = this.getTotalRuntime();
        long seconds = (milliseconds / 1000) % 60;
        long minutes = (milliseconds / (1000 * 60) % 60);
        long hours = (milliseconds / (1000 * 60 * 60)) % 24;

        Graphics2D g = (Graphics2D)graphics;

        //Draws and fills rectangle
        g.setColor(color1);
        g.fillRect(5, 6, 216, 138);
        g.setColor(color2);
        g.setStroke(stroke1);
        g.drawRect(5, 6, 216, 138);
        g.setColor(color3);
        g.fillRect(2, 3, 216, 138);
        g.setColor(color4);
        g.drawRect(2, 3, 216, 138);
        g.setFont(font1);
        g.setColor(color5);
        //Draws text onto drawn and filled rectangle
        g.drawString("BoellisPlankMake", 11, 40);
        g.setFont(font2);
        g.drawString("Running: " + String.format("%02d:%02d:%02d", hours, minutes, seconds), 30, 74);
        g.drawString("Profit/Hr:", 28, 108);
    }
}
