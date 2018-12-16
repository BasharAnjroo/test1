/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maintest;

import java.io.File;

/**
 *
 * @author MATRI
 */
public class InVisibleNullDerefernce {
 public static void deleteDir(File dir) {
		//يحصل null dereference هنا في حال كان المجلد لايملك صلاحيات القراءة
		File[] files = dir.listFiles();
		//Possible null pointer dereference in
		//due to return value of called method
		//توقع حصول nullDerefernce في حال كان المجلد فارغ لكن لم يحصل
		for (int i = 0; i < files.length; i++) {
		files[i].delete();
		}
		dir.delete();
		}
}
