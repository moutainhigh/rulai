package com.unicdata.shrio;

import com.unicdata.entity.system.Employee;
import com.unicdata.entity.system.Permissions;
import com.unicdata.entity.system.Role;
import com.unicdata.service.system.EmployeeService;
import com.unicdata.service.system.RoleService;
import com.unicdata.util.EncryptionUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RoleService roleService;

    //认证.登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken utoken = (UsernamePasswordToken) token;//获取用户输入的token
        String username = utoken.getUsername();
        Employee emp = employeeService.selectByLoginName(username);
        //找不到用户返回null
        if (emp == null || (emp != null && emp.getDataStatus() == 0)) {
            return null;
        }
        //如果用户被冻结
        if (Objects.equals(emp.getUserStatus(), 0)) {
            throw new LockedAccountException();
        }
        return new SimpleAuthenticationInfo(emp, EncryptionUtil.base64Decrypt(emp.getPwd()), this.getClass().getName());
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        Employee emp = (Employee) principal.getPrimaryPrincipal();//获取session中的用户
        List<String> permissions = new ArrayList<>();
        System.out.println(employeeService.employeeById(emp.getId()));
        List<Role> roles = employeeService.employeeById(emp.getId()).getRoles();
        if (roles != null) {
            for (Role ro : roles) {
                Role role = roleService.findRolePermissions(ro.getId());
                if (role.getPermissions() != null) {
                    for (Permissions permission : role.getPermissions()) {
                        permissions.add(permission.getUrl());
                    }
                }
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);//将权限放入shiro中.
        return info;
    }

    /**
     * 修改授权后清空缓存中的授权信息(修改权限的service中调用)
     */
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }
}
