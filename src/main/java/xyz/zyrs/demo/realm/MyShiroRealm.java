package xyz.zyrs.demo.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

public class MyShiroRealm extends AuthorizingRealm {

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("realm 授权");

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        System.out.println(SecurityUtils.getSubject().getPrincipal());
        //添加用户角色 --- 必要时可以从数据库中取出 - 这里时通过此realm登录的拥有admin角色
        if(SecurityUtils.getSubject().getPrincipal().equals("admin")){

            Set<String> roles = new HashSet<>();

            roles.add("admin");

            authorizationInfo.setRoles(roles);
        }

        return authorizationInfo;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("realm 认证");

        //1.authenticationToken 转化为 UsernamePasswordToken
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //2.从UsernamePasswordToken中获取username
        String username = token.getUsername();

        /**
         * 中间可进行验证，这里给出事例是：用户名为admin 密码 admin
         *
         * 如果用户不存在抛出UnknownAccountException(); 由controller接受
         */
        if(!username.equals("admin")){
            throw new UnknownAccountException();
        }

        //然后进行密码比对--从数据库中取出用户名和密码
        Object principal = "admin";
        Object credentials = "43442676c74ae59f219c2d87fd6bad52";//"";//admin 加密两次的值
        String realmName = getName();

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials,realmName);
        return info;
    }
    public static void main(String args[]){
        String algorithmName ="MD5";
        String source = "admin";
        Object salt = null;
        int hashIterations = 2;
        SimpleHash  s= new SimpleHash(algorithmName, source, salt, hashIterations);
        System.out.println(s.toString());
    }
}
