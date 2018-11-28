package xyz.zyrs.demo.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyShiroRealmTwo extends AuthorizingRealm {

    /**
     * 授权  此次不适用
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("realm two 授权");
        return null;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("realm two 认证");
        //1.authenticationToken 转化为 UsernamePasswordToken
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //2.从UsernamePasswordToken中获取username
        String username = token.getUsername();

        /**
         * 中间可进行验证，这里给出事例是：用户名为admin 密码 admin
         *
         * 如果用户不存在抛出UnknownAccountException(); 由controller接受
         */
        if(!username.equals("admin-two")){
            throw new UnknownAccountException();
        }
        //然后进行密码比对--从数据库中取出用户名和密码
        Object principal = "admin-two";
        Object credentials = "eaf5c9e1bf980f523381eda28d37186d";//admin-two 加密两次的值
        String realmName = getName();

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials,realmName);
        return info;
    }
}
