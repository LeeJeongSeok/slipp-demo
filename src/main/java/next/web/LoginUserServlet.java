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

@WebServlet("/user/login")
public class LoginUserServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(LoginUserServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = DataBase.findUserById(req.getParameter("userId"));

        if (user == null) {
            log.debug("해당 유저가 존재하지 않습니다.");
        }

        if (user.isPassword(req.getParameter("password"))) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("/index.jsp");
        } else {
            log.debug("비밀번호가 오류입니다.");
        }
    }
}
