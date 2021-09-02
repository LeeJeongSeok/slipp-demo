package core.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ForwardController implements Controller{

    private String forwardUrl;

    public ForwardController(String forwardUrl) {
        this.forwardUrl = forwardUrl;
        if (forwardUrl == null) {
            throw new NullPointerException("forwardUrl is null. 이동할 URL를 입력하세요");
        }
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return forwardUrl;
    }
}
