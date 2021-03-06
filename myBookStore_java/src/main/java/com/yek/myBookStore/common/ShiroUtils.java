package com.yek.myBookStore.common;

import com.yek.myBookStore.entity.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * Shiro工具类vo版
 * 
 */
public class ShiroUtils {

	public static Session getSession() {
		return SecurityUtils.getSubject().getSession();
	}

	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}

	public static UserInfo getLoginUser() {
		return (UserInfo) SecurityUtils.getSubject().getPrincipal();
	}

	/**
	 * 从 Session 里 取 当前登录用户Id
	 * @return
	 */
	public static Long getLoginUserId() {
		return getLoginUser().getUid();
	}

	/**
	 * 从 Session 里 取 当前登录用户名
	 * @return
	 */
	public static String getLoginUserName() {
		return getLoginUser().getUsername();
	}

	/**
	 * 从 Session 里 取 当前登录用户组织机构Id
	 * @return
	 */
//	public static String getLoginUserDeptId() {
//		return getLoginUser().getDeptId();
//	}

	/**
	 * 保存对象到 Session 里
	 * @param key
	 * @param value
	 */
	public static void setSessionAttribute(Object key, Object value) {
		getSession().setAttribute(key, value);
	}

	/**
	 * 从Session中获取对象
	 * @param key
	 * @return
	 */
	public static Object getSessionAttribute(Object key) {
		return getSession().getAttribute(key);
	}

	/**
	 * 从回话中删除对象
	 * @param key
	 * @return
	 */
	public static Object removeSessionAttribute(Object key) {
		return getSession().removeAttribute(key);
	}

	public static boolean isLogin() {
		return SecurityUtils.getSubject().getPrincipal() != null;
	}

	public static void logout() {
		SecurityUtils.getSubject().logout();
	}

}
