package com.tk.common.utils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.alibaba.druid.util.StringUtils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ExportExcel {
    List<?> list;                               //封装实体查询结果集
    List<String> nameList = new ArrayList<>();  //实体的字段名
    String className;                           //实体类路径

    /**
     * 构造方法，传入封装实体查询结果集
     * 实体类路径
     * @param list
     * @param className
     */
    public ExportExcel(List<?> list, String className) {
        this.list = list;
        this.className = className;
    }

    /**
     * 输出excel表的方法
     */
    public void toExcel() {
        try {
            // 获取类对象
            Class   clazz  = Class.forName(className);
            // 获取类对象内所有声明的字段
            Field[] fields = clazz.getDeclaredFields();
            // 输出excel表路径
            String       path   = "D://excel.xls";

            // 创建HSSFWorkbook对象
            HSSFWorkbook sheets = new HSSFWorkbook();
            // 在一个excel文件里插入一个工作表sheet
            HSSFSheet    sheet  = sheets.createSheet("My Sheet");
            // 在sheet内的第一行中插入字段名称
            HSSFRow      row    = sheet.createRow(0);
            HSSFCell     cell;

            // 将获取的字段名遍历存入List
            for (Field field : fields) {
                nameList.add(field.getName());
            }

            // 循环遍历将字段名插入到第一行各个列
            int i = 0;
            for (String fieldName : nameList) {
            	if(fieldName.equals("serialVersionUID"))continue;
                cell = row.createCell(i);
                cell.setCellValue(fieldName);
                i++;
            }

            // 循环遍历实体类和其字段名
            // 每个对象占一行，每列为字段的数据
            int j = 1;
            for (Object o : list) {
                    row = sheet.createRow(j);

                    int k=0;
                for (Field field : fields) {
                    // 获取除了序列号ID外的数据
                    // 底层实现是将字段名和get拼接，调用字段相应的get方法获取数据
                	if(field.getName().equals("serialVersionUID"))continue;
                    PropertyDescriptor pd     = new PropertyDescriptor(field.getName(), clazz);
                    Method             method = pd.getReadMethod();

                    cell = row.createCell(k);
                    
                    if(method.invoke(o)!=null) {
                    	cell.setCellValue(method.invoke(o).toString());
                    }
                    k++;
                }
                j++;
            }

            // 将文件输出到指定路径
            FileOutputStream outputStream =new FileOutputStream(path);
            // 使用HSSFWorkbook对象将excel输出
            sheets.write(outputStream);
            // 关闭流
            outputStream.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

