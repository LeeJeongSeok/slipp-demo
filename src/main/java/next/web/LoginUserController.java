package next.web;

import core.db.DataBase;
import core.mvc.Controller;
import next.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginUserController implements Controller {

    private static final Logger log = LoggerFactory.getLogger(LoginUserController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User user = DataBase.findUserById(request.getParameter("userId"));

        if (user == null) {
            log.debug("해당 유저가 존재하지 않습니다.");
        }

        if (user.isPassword(request.getParameter("password"))) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return "redirect:/";
        } else {
            log.debug("비밀번호가 오류입니다.");
        }
        return "/user/login.jsp";
    }
}
