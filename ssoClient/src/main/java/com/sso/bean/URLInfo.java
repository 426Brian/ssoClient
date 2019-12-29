package com.sso.bean;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Brian in 0:46 2018/12/12
 */
public class URLInfo {
    private static Properties properties = new Properties();

    private static  String SSO_CENTER_URL;

    private static  String CLIENT_HOST_URL;

    static {
        try {
            properties.load(URLInfo.class.getClassLoader().getResourceAsStream("conf/sso/sso.properties"));
            SSO_CENTER_URL = properties.getProperty("sso_center_url");
            CLIENT_HOST_URL=  properties.getProperty("client_host_url");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getSsoCenterUrl() {
        return SSO_CENTER_URL;
    }

    public static void setSsoCenterUrl(String ssoCenterUrl) {
        SSO_CENTER_URL = ssoCenterUrl;
    }

    public static String getClientHostUrl() {
        return CLIENT_HOST_URL;
    }

    public static void setClientHostUrl(String clientHostUrl) {
        CLIENT_HOST_URL = clientHostUrl;
    }
}
