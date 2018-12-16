/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maintest;

/**
 *
 * @author MATRI
 */
public class NullDereferenceException {
 	private String field1 = null;
    private String field2 = null;   
    public int [] arry;
    public String getField1() {
          return field1;
    }

    public void setField1(String field1) {
          this.field1 = field1;
    }

    public String getField2() {
          return field2;
    }

    public void setField2(String field2) {
          this.field2 = field2;
    }
    public String Concat()
    {
    	String res=field1+field2;
    	return res;
    }
}