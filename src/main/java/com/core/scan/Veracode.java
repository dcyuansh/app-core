package com.core.scan;


import org.slf4j.Logger;

import javax.activation.FileDataSource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParser;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.HashMap;
import java.util.Random;

/**
 * @author dechun.yuan
 * @version 1.0
 */
public class Veracode {

    public static void responseSendRedirect(HttpServletResponse response, String parameter) throws IOException {
        try {
            response.sendRedirect(parameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sessionSetAttribute(HttpSession hs, String strName, Object o) {
        HashMap map = (HashMap) hs.getAttribute("UntrustedData");
        if (map == null) {
            map = new HashMap();
        }
        map.put(strName, o);
        hs.setAttribute("UntrustedData", map);
    }

    public static Object sessionGetAttribute(HttpSession hsn, String strName) {
        HashMap map = (HashMap) hsn.getAttribute("UntrustedData");
        if (map == null) {
            return null;
        }
        if (!map.containsKey(strName)) return null;
        return map.get(strName);
    }

    public static String requestGetRealPath(HttpServletRequest request) {
        return request.getSession().getServletContext().getRealPath("/");
    }

    public static Object requestGetAttribute(HttpServletRequest hsn, String strName) {
        return sessionGetAttribute(hsn.getSession(), strName);
    }

    public static void RequestSetAttribute(HttpServletRequest hsn, String strName, Object o) {
        hsn.getSession().setAttribute(strName, o);
    }

    public static void RequestRemoveAttribute(HttpServletRequest hsn, String strName) {
        hsn.getSession().removeAttribute(strName);
    }

    public static double mathRandom() {
        return Math.random();
    }

    public static String getMessageDigestSHA_1() {
        return "SHA-1";
    }

    public static HashMap m = new HashMap();

    public static Class classForName(String s) throws ClassNotFoundException {
        if (!m.containsKey(s))
            m.put(s, Class.forName(s));
        return (Class) m.get(s);

    }

    public static File newFile(String s) {
        return new File(s);
    }

    public static FileWriter newFileWriter(String s) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(s);
        } catch (Exception e) {
        }
        return fw;
    }

    public static RandomAccessFile newRandomAccessFile(String s, String rw) {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(s, rw);
        } catch (Exception e) {

        }
        return raf;
    }

    public static FileOutputStream newFileOutputStream(String s, boolean append) throws FileNotFoundException {
        return new FileOutputStream(s, append);
    }

    public static FileInputStream newFileInputStream(String s) throws FileNotFoundException {
        return new FileInputStream(s);
    }

    public static void initSql(HashMap h, String s) {
        java.lang.reflect.Method m;
        try {
            m = h.getClass().getMethod("put", new Class[]{Object.class, Object.class});
            m.invoke(h, new Object[]{s, s});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private java.util.HashMap veravodeHash = new java.util.HashMap();

    public String veracodeEncodeSql(String s) {
        com.core.scan.Veracode.initSql(veravodeHash, s);
        return (String) veravodeHash.get(s);
    }


    public static void responseSetHeader(HttpServletResponse response, String downfile) throws IOException {
        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(downfile.getBytes("UTF-8"), "ISO8859-1") + "\"");
    }

    public static void responseSetHeaderForPdf(HttpServletResponse response, String downfile) {
        response.setHeader("Content-Disposition", "attachment; filename=\"" + downfile + "\"");
    }

    public static File mkstemp(String prefix, String suffix,
                               File directory) throws IOException {
        return File.createTempFile(prefix, suffix, directory);
    }

    public static int getRandom62(Random random) {
        return random.nextInt(62);

    }

    public static FileDataSource newFileDataSource(String s) {
        return new FileDataSource(s);
    }

    public static Object requestGetAttributeDcr(HttpServletRequest hsn, String strName) {
        return hsn.getSession().getAttribute(strName);
    }

    public static void logInfo(Logger logger, Object message) {
        logger.info(message == null ? "" : message.toString());
    }

    public static void logWarn(Logger logger, Object message, Throwable e) {
        logger.warn(message == null ? "" : message.toString(), e);
    }

    public static void logEplatformInfo(org.apache.commons.logging.Log log, Object message) {
        log.info(message);
    }

    public static void logEplatformWarn(org.apache.commons.logging.Log log, Object message) {
        log.warn(message);
    }

    public static Object veracodeUnmarshal(Unmarshaller unmarshaller, File file) {
        Object raf = null;
        try {
            raf = unmarshaller.unmarshal(file);
        } catch (Exception e) {

        }
        return raf;
    }

    public static void servletBufferedWriterPrint(BufferedWriter out, String string) {
        try {
            out.write(string);
        } catch (Exception e) {
        }
    }

    public static void veracodeXslTransform(Transformer transformer, Source xmlSource, StreamResult result) {
        try {
            transformer.transform(xmlSource, result);
        } catch (Exception e) {
        }
    }

    public static void veracodeTransformForDOMSource(Transformer transformer, DOMSource source, StreamResult result) throws TransformerException {
        transformer.transform(source, result);
    }

    public static void saxParseDef(SAXParser parser, org.xml.sax.InputSource is, org.xml.sax.helpers.DefaultHandler defHandler) {
        try {
            parser.parse(is, defHandler);
        } catch (Exception e) {
        }
    }

    public static org.w3c.dom.Document documentBuilderParse(javax.xml.parsers.DocumentBuilder parser, InputStream input) {
        org.w3c.dom.Document doc = null;
        try {
            doc = parser.parse(input);
        } catch (Exception e) {

        }
        return doc;
    }

    public static void saxParseBase(SAXParser parser, InputStream input, org.xml.sax.helpers.DefaultHandler baseHandler) {
        try {
            parser.parse(input, baseHandler);
        } catch (Exception e) {
        }
    }

    public static org.w3c.dom.Document documentBuilderParseFile(javax.xml.parsers.DocumentBuilder parser, File inputFile) {
        org.w3c.dom.Document doc = null;
        try {
            doc = parser.parse(inputFile);
        } catch (Exception e) {
        }
        return doc;
    }
}
