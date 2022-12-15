package org.example;

import Commands.CommandManager;
import Events.*;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;


public class EmmaBot {

    private final ShardManager shardManager;
    private final @NotNull Dotenv config;

    //Constructor for EmmaBot
    public EmmaBot() throws LoginException {

        config = Dotenv.configure().load();
        String TOKEN = config.get("TOKEN");

        //Bot Builder
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(TOKEN);
                builder.setStatus(OnlineStatus.ONLINE)
                .setActivity(Activity.watching("Suga program me"))
                .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_MEMBERS)
                .addEventListeners(new ReadyEventListener(), new MessageEventListener() /*new InteractionEventListener()*/);
                //.enableCache(CacheFlag.ONLINE_STATUS)
                //.setChunkingFilter(ChunkingFilter.ALL);
                //.setMemberCachePolicy(MemberCachePolicy.ALL);
                shardManager = builder.build();

                //Listeners
                shardManager.addEventListener(new CommandManager());
    }

    //Getter for Config
    @NotNull
    public Dotenv getConfig() {
        return config;
    }
    //Getter for ShardManager

    public ShardManager getShardManager() {
        return shardManager;
    }

    //instantiates EmmaBot as an Object with LoginException catcher
    public static void main(String[] args) {
        try {
            EmmaBot Emma = new EmmaBot();
        }
        catch (LoginException e) {
            System.out.println("Bot Token Invalid");
        }
    }
}