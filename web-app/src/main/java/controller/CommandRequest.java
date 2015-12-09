package controller;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

public class CommandRequest  {
        private static CommandRequest instance = null;
        private HashMap<String, IComm> controllers = new HashMap();

        private CommandRequest() {
            controllers.put("user_controller", new UserController());
        }

        public static CommandRequest getInstance() {
            if(instance == null) {
                instance = new CommandRequest();
            }
            return instance;
        }

        public IComm getCommand(HttpServletRequest request) {
            IComm command = (IComm)this.controllers.get(request.getParameter("controller_type"));
            return command;
        }

    }


