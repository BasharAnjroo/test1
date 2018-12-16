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
public class ImpossibleNullDereference {
static void MakeDir(String outputdir,String key)
	{
            // key is file name
		File f = new File(outputdir +File.separator+  key);
		
		// File x=f.getParentFile();
		//Coverity
		// warning that f.getParentFile() might return null
		//لايمكن أن يوجد null derefernce بسبب وجود ال فايل سيبيراتور 
		f.getParentFile().mkdirs();
	}
	
	
	static void GetParent(String outputdir)
	{
		File root = new File(outputdir );
		
		while (root.getParent() != null)
			//Coverity
			// warning that getParentFile might return null
			//لايمكن أن يصل إلى حالة null بسبب الشرط المسبق على root.getPaent
			root = root.getParentFile();
	}
	
	public static boolean isBigDecimalDifferent(BigDecimal x, BigDecimal y) {
        return (x != null || y != null)//
        		//null derefernce مكتشف بواسطة findBugs
        		//لكن من المسنحيل أن يحصل بسبب أن المسار الذي يحصل فيه غير قابل للتنفيذ
                && ((x != null && y == null) || (x == null && y != null) || x.compareTo(y) != 0);   
}
}
