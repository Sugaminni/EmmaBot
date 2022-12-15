package Commands;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CommandManager extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        super.onSlashCommandInteraction(event);
        super.onSlashCommandInteraction(event);
        System.out.println("Interaction Works");
        System.out.println(event.getName());

        //Switch case for commands after prefix
        switch (event.getName()) {
            case "test":
                event.reply("Testing Successful").setEphemeral(false).queue();
                System.out.println(event.getUser() + " used: " + event.getName());
                break;
        }
    }


    //Command List and command adding
    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event)  {
        List<CommandData> commandData = new ArrayList<>();

        commandData.add(Commands.slash("test", "Testing Successful"));
        commandData.add(Commands.slash("say", "Makes the bot say something").addOptions());

        event.getGuild().updateCommands().addCommands(commandData).queue();
    }

}
