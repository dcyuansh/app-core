package com.core.utils;

import org.dom4j.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.*;


/**
 * @author dechun.yuan
 * @version 1.0
 */
public class XmlParserUtil {


    /***
     * 将object对象转为xml
     * @param obj
     * @return
     */
    public static String objectToXml(Object obj) {
        //创建输出流
        StringWriter writer = new StringWriter();
        try {
            // 利用jdk中自带的转换类实现
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            // 格式化xml输出的格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            // 将对象转换成输出流形式的xml
            marshaller.marshal(obj, writer);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }


    /****
     * 将object对象转换为xml，保存到path路径
     * @param obj
     * @param path
     */
    public static void objectToXml(Object obj, String path) {
        try {
            // 利用jdk中自带的转换类实现
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            // 格式化xml输出的格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            // 将对象转换成输出流形式的xml
            // 创建输出流
            FileWriter fw = null;
            try {
                fw = new FileWriter(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            marshaller.marshal(obj, fw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    /***
     * 将string类型的xml转换为object对象
     * @param xmlStr
     * @param obj
     * @return
     */
    public static Object xmlToObject(String xmlStr, Class<?> obj) {
        Object xmlObject = null;
        try {
            JAXBContext context = JAXBContext.newInstance(obj);
            // 进行将Xml转成对象的核心接口
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader sr = new StringReader(xmlStr);
            xmlObject = unmarshaller.unmarshal(sr);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xmlObject;
    }


    /***
     * 将xml文件转换为object对象
     * @param xmlPath
     * @param obj
     * @return
     */
    public static Object xmlFileToObject(String xmlPath, Class<?> obj) {
        Object xmlObject = null;
        try {
            JAXBContext context = JAXBContext.newInstance(obj);
            // 进行将Xml转成对象的核心接口
            Unmarshaller unmarshaller = context.createUnmarshaller();
            xmlObject = unmarshaller.unmarshal(new File(xmlPath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xmlObject;
    }


    /***
     * xml解析为map，相同的节点会被覆盖，只保留最后一次解析的值
     * @param xml
     * @return
     */
    public static Map<String, Object> xmlToMap(String xml) {
        if (StringUtils.isBlank(xml)) return null;
        Document doc = null;
        try {
            doc = DocumentHelper.parseText(xml);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Map<String, Object> map = new HashMap<>();
        if (null == doc) {
            return map;
        }
        // 获取根元素
        Element rootElement = doc.getRootElement();
        elementToMap(map, rootElement);
        return map;
    }


    /***
     * 相同节点会被覆盖，只保存最后一个节点的值。
     * elementToMap核心方法，递归调用
     * @param element 节点元素
     * @param outmap  用于存储xml数据的map
     */
    private static void elementToMap(Map<String, Object> outmap, Element element) {
        // 得到根元素下的子元素列表
        List<Element> list = element.elements();
        int size = list.size();
        if (size == 0) {
            // 如果没有子元素,则将其存储进map中
            outmap.put(element.getName(), element.getTextTrim());
        } else {
            // innermap用于存储子元素的属性名和属性值
            Map<String, Object> innermap = new HashMap<>();
            // 遍历子元素
            list.forEach(childElement -> elementToMap(innermap, childElement));
            outmap.put(element.getName(), innermap);
        }
    }


    /***
     * xml格式字符串转换为map,相同节点同样被解析出来
     * @param xml xml字符串
     * @return 第一个为Root节点，Root节点之后为Root的元素，如果为多层，可以通过key获取下一层Map
     */
    public static Map<String, Object> dom4jXmlToMap(String xml) {
        if (StringUtils.isBlank(xml)) return null;
        Document doc = null;
        try {
            doc = DocumentHelper.parseText(xml);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Map<String, Object> map = new HashMap<>();
        if (null == doc) {
            return map;
        }
        // 获取根元素
        Element rootElement = doc.getRootElement();
        dom4jElementToMap(map, rootElement);
        return map;
    }


    /***
     * 相同节点会全部解析出来。
     * 使用递归调用将多层级xml转为map
     * @param map
     * @param rootElement
     */
    private static void dom4jElementToMap(Map<String, Object> map, Element rootElement) {
        //获得当前节点的子节点
        List<Element> elements = rootElement.elements();
        if (elements.size() == 0) {
            //没有子节点说明当前节点是叶子节点，直接取值
            map.put(rootElement.getName(), rootElement.getText());
        } else if (elements.size() == 1) {
            //只有一个子节点说明不用考虑list的情况，继续递归
            Map<String, Object> tempMap = new HashMap();
            dom4jElementToMap(tempMap, elements.get(0));
            map.put(rootElement.getName(), tempMap);
        } else {
            //多个子节点的话就要考虑list的情况了，特别是当多个子节点有名称相同的字段时
            Map<String, Object> tempMap = new HashMap();
            for (Element element : elements) {
                tempMap.put(element.getName(), null);
            }
            Set<String> keySet = tempMap.keySet();
            for (String string : keySet) {
                Namespace namespace = elements.get(0).getNamespace();
                List<Element> sameElements = rootElement.elements(new QName(string, namespace));
                //如果同名的数目大于1则表示要构建list
                if (sameElements.size() > 1) {
                    List<Map> list = new ArrayList();
                    for (Element element : sameElements) {
                        Map<String, Object> sameTempMap = new HashMap();
                        dom4jElementToMap(sameTempMap, element);
                        list.add(sameTempMap);
                    }
                    map.put(string, list);
                } else {
                    //同名的数量不大于1直接递归
                    Map<String, Object> sameTempMap = new HashMap();
                    dom4jElementToMap(sameTempMap, sameElements.get(0));
                    map.put(string, sameTempMap);
                }
            }
        }
    }
}
