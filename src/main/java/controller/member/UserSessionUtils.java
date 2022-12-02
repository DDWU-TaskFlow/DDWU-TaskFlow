package controller.member;

import javax.servlet.http.HttpSession;

public class UserSessionUtils {
    public static final String USER_SESSION_KEY = "user_name";

    /* 현재 로그인한 사용자의 ID를 구함 */
    public static String getLoginUserName(HttpSession session) {
        String userName = (String)session.getAttribute(USER_SESSION_KEY);
        return userName;
    }

    /* 로그인한 상태인지를 검사 */
    public static boolean hasLogined(HttpSession session) {
        if (getLoginUserName(session) != null) {
            return true;
        }
        return false;
    }

    /* 현재 로그인한 사용자의 ID가 userId인지 검사 */
    public static boolean isLoginUser(String userName, HttpSession session) {
        String loginUser = getLoginUserName(session);
        if (loginUser == null) {
            return false;
        }
        return loginUser.equals(userName);
    }
}
