package xyz.zyrs.demo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {


    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }
    @RequestMapping(value = "/403")
    public String login403() {
        //必须登出，不然无法更换账号重新登录
        SecurityUtils.getSubject().logout();
        return "403";
    }

    //处理异常
    //如果是双reaml验证则，仅会抛出org.apache.shiro.authc.AuthenticationException这个异常
    //，，所以不能判断账号和密码哪里出了问题>>>待优化
    @ResponseBody
    @ExceptionHandler({AuthenticationException.class})
    public void authenticationException(Exception ex, HttpServletResponse response) throws IOException {
        System.out.println("异常:"+ex.getMessage());
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        if(ex.getMessage().equals(IncorrectCredentialsException.class.getName())){
            response.getWriter().print("密码错误！");
            response.getWriter().close();
            return;
        }else if(ex.getMessage().equals(UnknownAccountException.class.getName())){
            response.getWriter().print("用户名不存在！");
            response.getWriter().close();
            return;
        }

        response.getWriter().print("登录失败，请检查用户名或密码是否正确!");
        response.getWriter().close();
    }

    @ResponseBody
    @RequestMapping("/userLogin")
    public int userLogin(@RequestParam("username")String username, @RequestParam("password")String password, @RequestParam(value="rememberMe",defaultValue="")String rememberMe){
        System.out.println("userLogin...."+"账号:"+username+"  密码:"+password);
        Subject currentUser = SecurityUtils.getSubject();
        if(!currentUser.isAuthenticated()){
            //把用户名和密码封装为usernamePasswordToken
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);

            if(rememberMe.equals("on")){
                token.setRememberMe(true);
            }
            //记住我-token.setRememberMe(true)
            //执行登录
            try{
                currentUser.login(token);
                // System.out.println(">>>认证："+currentUser.isAuthenticated()+"-记住我："+currentUser.isRemembered());
            }catch(AuthenticationException ae){
                throw new AuthenticationException(ae.getClass().getName());
            }
        }

        return 1;
    }


}
