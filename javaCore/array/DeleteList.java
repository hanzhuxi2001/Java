package javaCore.array;
import java.util.ArrayList;  
import java.util.Iterator;  
import java.util.List;  
  
public class DeleteList {  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
  
        List<Integer> list = new ArrayList<Integer>();  
        for (int i = 0; i < 10; i++) {  
            list.add(i);  
        }  
        System.out.println("size =" + list.size());  
        System.out.println(list.toString());  
        delete5(list);  
          
//      list.clear();  
//      list.removeAll(list);  
        System.out.println("after delete, size is " + list.size());  
        System.out.println(list.toString());  
    }  
      
    /** 
     * 正序遍历删除 
     * 结果：只删除了一半 
     * 原因：每删除一个，size变小，要删除的下一个前移以为，下次只能是隔一个再删除 
     * @param list 
     */  
    public static void delete1(List<Integer> list){  
        for (int i=0; i<list.size(); i++){  
            System.out.println(list.toString());  
            System.out.println("要删除第" + i + "个");  
            list.remove(i);  
            System.out.println("now size = " +list.size());  
        }  
          
    }  
      
    /** 
     * 倒序遍历删除 
     * 结果：全部删除 
     * 原因：每次都删最后一个 
     * @param list 
     */  
    public static void delete2(List<Integer> list){  
        for (int i=list.size()-1; i>=0; i--){  
            System.out.println(list.toString());  
            System.out.println("要删除第" + i + "个");  
            list.remove(i);  
            System.out.println("now size = " +list.size());  
        }  
    }  
      
    /** 
     * java.util.ConcurrentModificationException 
     * iterator遍历时不能进行删除，但是可以修改 
     * @param list 
     */  
    public static void delete3(List<Integer> list){  
        for (Integer obj : list) {  
            list.remove(obj);  
        }  
    }  
      
    /** 
     * java.util.ConcurrentModificationException 
     * iterator遍历时不能进行删除，但是可以修改 
     * @param list 
     */  
    public static void delete4(List<Integer> list){  
        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {  
            Integer obj = (Integer) iterator.next();  
            list.remove(obj);  
        }  
    }  
      
    /** 
     * 使用iterator自带的遍历和删除方式，正常 
     * @param list 
     */  
    public static void delete5(List<Integer> list){  
        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {  
            iterator.next();  
            iterator.remove();  
        }  
    }  
}  