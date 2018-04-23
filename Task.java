package Boellis_PlankMake;

import org.powerbot.script.rt4.ClientAccessor;
import org.powerbot.script.rt4.ClientContext;
import java.util.Random;

public abstract class Task extends ClientAccessor {

    public Task(ClientContext ctx) {
        super(ctx);
    }


    public abstract boolean active();
    public abstract void execute();

}