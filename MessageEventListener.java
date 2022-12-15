package Events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class MessageEventListener extends ListenerAdapter {

    //Displays user messages
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        super.onMessageReceived(event);

        System.out.println(event.getAuthor() + " in server " + event.getGuild() + " in " + event.getChannel() + " said: " + event.getMessage().getContentDisplay());

    }
}
