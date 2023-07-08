package com.core.utils;


import java.net.Inet4Address;
import java.net.UnknownHostException;

public class IpUtils {


    /**
     * @param longIp
     * @return
     * @desc long to ipv4
     */
    public static String longToIpV4(long longIp) {
        int octet3 = (int) ((longIp >> 24) % 256);
        int octet2 = (int) ((longIp >> 16) % 256);
        int octet1 = (int) ((longIp >> 8) % 256);
        int octet0 = (int) ((longIp) % 256);
        return octet3 + "." + octet2 + "." + octet1 + "." + octet0;
    }

    /**
     * @param ip
     * @return
     * @desc ipv4 to long
     */
    public static long ipV4ToLong(String ip) {
        String[] octets = ip.split("\\.");
        return (Long.parseLong(octets[0]) << 24) + (Integer.parseInt(octets[1]) << 16)
                + (Integer.parseInt(octets[2]) << 8) + Integer.parseInt(octets[3]);
    }


    /**
     * @return
     * @desc 返回string host ip
     */
    public static String getHostIp() throws UnknownHostException {
        try {
            return Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw e;
        }
    }
}
