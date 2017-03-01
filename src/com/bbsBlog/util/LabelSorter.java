/**
 * 
 */
package com.bbsBlog.util;

import java.util.Comparator;

import javax.swing.text.AbstractDocument.Content;

import com.bbsBlog.entity.Label;

/**
 * @author Robust
 *
 * @date 2014年11月5日
 *
 */
public class LabelSorter implements Comparator<Label>{
	 public int compare(Label o1, Label o2) {  
		  
	        //将 null 排到最后  
	        if(o1 == null){  
	            return 1;  
	        }  
	        if(o2 == null || !(o2 instanceof Label)){  
	            return -1;  
	        }  
	          
	        double key1 = Double.parseDouble(o1.getLabelDesc());  
	        double key2 = Double.parseDouble(o2.getLabelDesc());     
	        return key1 > key2 ? 1 : key1 < key2 ? -1 : 0;  
	          
	        /* 
	        //如果想要按照 name 字段进行排序, 只需将最后三行代码改为下面这一行即可 
	        return o1.getName().compareTo(o2.getName()); 
	        */  
	          
	    }  
}
