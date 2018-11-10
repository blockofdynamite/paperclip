import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

/**
 * Created by Dominic on 2/26/2017.
 */
public class Search extends ListenerAdapter {
    public void onMessage(MessageEvent event) throws InterruptedException, Exception {
        String message = event.getMessage();
        String[] words = message.split(" ");
        if (message.startsWith(Global.commandPrefix)) {
            String command = words[0];
            command = command.replace("!", "");
            if (command.equalsIgnoreCase("ark")) {
                String url = "http://ark.intel.com/search?q=";
                if (words.length > 1) {
                    for (int i = 1; i < words.length; i++) {
                        url = url + words[i];
                        if (i < words.length-1) {
                            url = url + "+";
                        }
                    }
                    sendMessage(event, url);
                }
            } else if (command.equalsIgnoreCase("steam")) {
                String url = "http://store.steampowered.com/search/?ref=os&term=";
                if (words.length > 1) {
                    for (int i = 1; i < words.length; i++) {
                        url = url + words[i];
                        if (i < words.length-1) {
                            url = url + "+";
                        }
                    }
                    sendMessage(event, url);
                }
            } else if (command.equalsIgnoreCase("ebay")) {
                String url = "http://www.ebay.com/sch/i.html?_nkw=";
                if (words.length > 1) {
                    for (int i = 1; i < words.length; i++) {
                        url = url + words[i];
                        if (i < words.length-1) {
                            url = url + "+";
                        }
                    }
                    sendMessage(event, url);
                }
            } else if (command.equalsIgnoreCase("amazon")) {
                String url = "https://amazon.com/s?ie=UTF8&field-keywords=";
                if (words.length > 1) {
                    for (int i = 1; i < words.length; i++) {
                        url = url + words[i];
                        if (i < words.length-1) {
                            url = url + "%20";
                        }
                    }
                    sendMessage(event, url);
                }
            }
        } else {

        }
    }

    private void sendMessage(MessageEvent event, String message) {
        event.getBot().sendIRC().message(event.getChannel().getName(), message);
    }
}
