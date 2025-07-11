package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.util.ToStringUtil;

import java.io.IOException;
import java.util.Enumeration;

/**
 * 1. 파라미터 전송 기능
 *      http://localhost:8080/request-param?username=hello&age=20
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RequestParamServlet.service");

        System.out.println("[전체 파라미터 조회] start");

        request.getParameterNames().asIterator()
                        .forEachRemaining(paraName -> System.out.println(paraName + " = " + request.getParameter(paraName)));

        System.out.println("[전체 파라미터 조회] end");
        System.out.println();


        System.out.println("[단일 파라미터 조회] start");

        String username = request.getParameter("username");
        String age = request.getParameter("age");
        String undefinedPara = request.getParameter("undefinedPara");

        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println("undefinedPara = " + undefinedPara);

        System.out.println("[단일 파라미터 조회] end");
        System.out.println();


        System.out.println("[이름이 같은 복수 파라미터 조회] start");

        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("name = " + name);
        }

        System.out.println("[이름이 같은 복수 파라미터 조회] end");
        System.out.println();

        response.getWriter().write("ok");

    }
}
