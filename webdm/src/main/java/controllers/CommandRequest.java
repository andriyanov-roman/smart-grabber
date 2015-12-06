package controllers;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by alisa on 05/12/15.
 */
public class CommandRequest {
    private static CommandRequest instance = null;
          private HashMap<String, ICommand> controllers = new HashMap();
                 private CommandRequest() {
                controllers.put("user_controller", new UserController());
             }

    public static CommandRequest getInstance() {
        if(instance == null) {
            instance = new CommandRequest();
        }
        return instance;
        }

    public ICommand getCommand(HttpServletRequest request) {
        String action = request.getParameter("controller_type");
        ICommand command = (ICommand)this.controllers.get(action);
        return command;
            }
}
