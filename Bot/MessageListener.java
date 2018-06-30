package SoundBoard;

import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventDispatcher;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.util.RequestBuffer;
import sx.blah.discord.util.DiscordException;

public class MessageListener {
	final String BOTPREFIX = "!";
    
	public static IDiscordClient createClient(String token, boolean login) {
        ClientBuilder clientBuilder = new ClientBuilder();
        clientBuilder.withToken(token); 
        try {
            if (login) {
                return clientBuilder.login();
            } else {
                return clientBuilder.build();
            }
        } catch (DiscordException e) { 
            e.printStackTrace();
            return null;
        }
    }
	
    @EventSubscriber
    public void onReadyEvent(MessageEvent event) {
    	respond(event);
    }
    
    public void respond(MessageEvent event) {
        if(event.getMessage().getContent().startsWith(BOTPREFIX + "test"))
            sendMessage(event.getChannel(), "I am sending a message from an EventSubscriber listener");
        if(event.getMessage().getContent().contains("Rule 8")) {
         	System.exit(0);
        }
    }
    
    static void sendMessage(IChannel channel, String message){
        RequestBuffer.request(() -> {
            try{
                channel.sendMessage(message);
            } catch (DiscordException e){
                System.err.println("Message could not be sent with error: ");
                e.printStackTrace();
            }
        });
        };

	public static void main(String[] args){
       /* if(args.length != 1){
            System.out.println("Please enter the bots token as the first argument e.g java -jar thisjar.jar tokenhere");
            return;
        }*/
        IDiscordClient client = createClient("NDU4NDUwMTA1MzM1NDE0Nzg0.Dgn1Pg.pSb5jbRyLa4BvYoY1TADXblFBaf", true); 
        EventDispatcher dispatcher = client.getDispatcher();
        dispatcher.registerListener(new MessageListener());
        client.login();
	}

}
