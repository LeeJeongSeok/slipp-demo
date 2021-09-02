package core.mvc;

import next.web.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class RequestMapping {

    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    private static Map<String, Controller> controllers = new HashMap<String, Controller>();

    void initMapping() {
        controllers.put("/", new HomeController());
        controllers.put("/user/form", new ForwardController("/user/form.jsp"));
        controllers.put("/user/loginForm", new ForwardController("/user/login.jsp"));
        controllers.put("/user/create", new CreateUserController());
        controllers.put("/user/login", new LoginUserController());
        controllers.put("/user/logout", new LogoutController());
        controllers.put("/user/list", new ListUserController());
        controllers.put("/user/profile", new ProfileController());
        controllers.put("/user/update", new UpdateUserFormController());
        controllers.put("/update/user", new UpdateUserController());
    }

    public static Controller getController(String requestUrl) {
        return controllers.get(requestUrl);
    }

    void put(String url, Controller controller) {
        controllers.put(url, controller);
    }
}
