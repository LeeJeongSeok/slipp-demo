package next.web;

import core.db.DataBase;
import next.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/update/user")
public class UpdateUserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(CreateUserServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(req.getParameter("userId"), req.getParameter("password"), req.getParameter("name"),
                req.getParameter("email"));
        log.debug("user : {}", user.toString());

        HttpSession session = req.getSession();
        Object value = session.getAttribute("user");

        if (value != null) {
            User sessionedUser = (User) value;

            if (sessionedUser.getUserId().equals(user.getUserId())) {
                DataBase.updateUser(user);
                resp.sendRedirect("/user/list");
            } else {
                log.debug("자신의 정보만 수정할 수 있습니다.");
            }
        }
    }
}
