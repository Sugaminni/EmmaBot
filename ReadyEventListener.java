package Events;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import org.jetbrains.annotations.NotNull;

public class ReadyEventListener implements net.dv8tion.jda.api.hooks.EventListener {

    //Sees if bot is online
    @Override
    public void onEvent(@NotNull GenericEvent event) {
        if(event instanceof ReadyEvent)
            System.out.println("Bot Online");

    }

}
