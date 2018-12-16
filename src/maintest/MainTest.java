/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maintest;
import java.io.File;
import java.math.BigDecimal;

/**
 *
 * @author MATRI
 */
public class MainTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      // انشاء كائن جديد
			NullDereferenceException objectInstance1 =
                         new NullDereferenceException();   
            // تهيئة الحقل الأول
            objectInstance1.setField1("field1Value");
           
            // اعادة قيمة نسخة الكائن إلى القيمة null
            objectInstance1 = null;
            
            // وصول إلى الحقل الثاني بقيمة
            //NullDerefernce
            //NullPointerException
            //كل الأدوات باستثناء pmd
            objectInstance1.setField2("field1Value2");
            
            
            // استدعاء تابع 
            //NullDerefernce
			//NullPointerException
            //كل الأدوات باستثناء pmd
            String concat=objectInstance1.Concat();
            System.out.println(concat);	
            
            
            
            
            //وصول إلى طول مصفوفة null
            //NullDerefernce
            //NullPointerException
            //كل الأدوات باستثناء pmd
            int length=objectInstance1.arry.length;
            System.out.println(length);	
           
		
		
		
		
            String temp = null;
            //Non-virtual method call in 
            // passes null for non-null parameter of isProperName(String)
            //كل الأدوات باستثناء pmd
            System.out.println(isProperName(temp));
    
            

		InVisibleNullDerefernce objectInstance2=
				new InVisibleNullDerefernce();
		File f1 =new File("D:","bashar1");
		File f2=new File("D:","amir");
		objectInstance2.deleteDir(f1);
		//NullDereference
		//سيحصل خطأ بسبب عدم وجود صلاحيات قراءة على المجلد 
		objectInstance2.deleteDir(f2);
         
		File f = new File("D:/c");
		boolean bool = f.mkdirs();
        
        // تم كشفهم باستخدام Coverity فقط
		System.out.print("Directory created? "+bool);
		ImpossibleNullDereference.MakeDir("D", "c");
		ImpossibleNullDereference.GetParent("D:\\d\\e\\f");
		
		
		//تم كشفهم بواسطة findbugs & Coverity
		BigDecimal a=new BigDecimal(65.5);
		BigDecimal b=new BigDecimal(659.5);
		
		boolean x=ImpossibleNullDereference.isBigDecimalDifferent(a,b);
}

	
	
	
	
	
	 static boolean isProperName(String s) {
   	  String names[] = s.split(" ");
   	  if (names.length != 2) {
   	    return false;
   	  }
   	  return true;
   	}
}


//Coverity 7 + 3 impossible + 1 Invisible
//FindBugs 5 + 1 impossible + 1 Invisible
//CodeSonar 4 + 0 impossible + 1 Invisible
//PMD 0 0 0 No Null Derefernce Found