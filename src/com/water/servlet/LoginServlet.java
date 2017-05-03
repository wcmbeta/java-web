package com.water.servlet;

import com.water.entity.User;
import com.water.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Water on 17/4/14.
 * Email:water471871679@gmail.com
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        int count = 0;
        this.getServletContext().setAttribute("count", count);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置乱码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        //验证码校验
        //获得页面输入的验证
        String checkCode_client = request.getParameter("checkCode");
        //获得生成图片的文字的验证码
        String checkCode_session = (String) request.getSession().getAttribute("checkcode_session");
        System.out.println("checkCode = [" + checkCode_client + "], checkcode_session = [" + checkCode_session + "]");
        //比对页面的和生成图片的文字的验证码是否一致
        if (checkCode_session == null || checkCode_session.length() == 0) {
            return;
        }
        if (checkCode_client != null && checkCode_client.length() > 0 && !checkCode_session.equals(checkCode_client)) {
            request.setAttribute("loginInfo", "您的验证码不正确");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }


        //1.获取数据
        String username = "";username = request.getParameter("username");
        String password = "";password = request.getParameter("password");
        if (username == null || username.length() == 0
                ) {
            request.setAttribute("loginInfo", "账号为空");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        if (password == null || password.length() == 0
                ) {
            request.setAttribute("loginInfo", "密码为空");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        System.out.println("username = [" + username + "], password = [" + password + "]");
//		//2.数据库校验
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where username=?  and password = ?";
        User user = null;
        try {
            user = runner.query(sql, new BeanHandler<User>(User.class), username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user != null) {
            //
//			ServletContext context = this.getServletContext();
//			Integer count = (Integer) context.getAttribute("count");
//			count++;
//			//用户登录成功
//			response.getWriter().write(user.toString() + "--you are success login person:" + count);
//			context.setAttribute("count", count);
            request.setAttribute("loginInfo", "登录成功");
            request.getRequestDispatcher("/").forward(request, response);

        } else {
            //登录失败
            request.setAttribute("loginInfo", "账号密码不正确");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
