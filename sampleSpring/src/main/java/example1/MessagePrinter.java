package example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by pkumar on 26/9/17.
 */

@Component
public class MessagePrinter {

    @Autowired
    private MessageService messageService;


    public void printMessage() {
        System.out.println(this.messageService.getMessage());
    }

}
