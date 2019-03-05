package com.unicdata.util;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by shenyong on 2016/9/22.
 */
public class IPUtil {

    /**
     * 从head中获取客户IP地址
     * @param request
     * @return
     */
    public static String getRequestIp(HttpServletRequest request) {
        String forwardedIp = request.getHeader("X-Forwarded-For");
        if(StringUtils.isNotBlank (forwardedIp) && forwardedIp.split(",").length>0){
            return forwardedIp.split(",")[0].trim();
        }else{
            forwardedIp = request.getHeader("Cdn-Src-Ip");
            if(StringUtils.isNotBlank(forwardedIp)){
                return forwardedIp;
            }
        }
        return request.getRemoteAddr();
    }

    /**
     * 获取本地IP列表（针对多网卡情况）
     * @return
     */
    public static List<String> getLocalIPList() {
        List<String> ipList = new ArrayList<String>();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            NetworkInterface networkInterface;
            Enumeration<InetAddress> inetAddresses;
            InetAddress inetAddress;
            String ip;
            while (networkInterfaces.hasMoreElements()) {
                networkInterface = networkInterfaces.nextElement();
                inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    inetAddress = inetAddresses.nextElement();
                    if (inetAddress != null && inetAddress instanceof Inet4Address) { // IPV4
                        ip = inetAddress.getHostAddress();
                        ipList.add(ip);
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return ipList;
    }

    /**
     * 判断传入ip是否是本机ip
     * @param ip
     * @return
     */
    public static boolean isLocalIp(String ip){
        List<String> localIPList = getLocalIPList();
        for(String s : localIPList){
            if(s.equals(ip))
                return true;
        }
        return false;
    }
}
