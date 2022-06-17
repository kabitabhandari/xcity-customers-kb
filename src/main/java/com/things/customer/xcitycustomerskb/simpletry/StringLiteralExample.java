package com.things.customer.xcitycustomerskb.simpletry;

public class StringLiteralExample {
    public static void main(String... args) {
        String str1 = "apple";
        System.out.println("hash address of str1 \"apple\" : " + System.identityHashCode(str1));

        String str2 = "apple";
        System.out.println("hash address of str2 \"apple\": " + System.identityHashCode(str2));

        String str3 = "apple";
        System.out.println("hash address of str3 \"apple\": " + System.identityHashCode(str3));

        str3.intern();
        System.out.println("hash address str3 \"apple\" after intern(): " + System.identityHashCode(str3));

        String kbi1 = new String("apple");
        System.out.println("hash address of kbi1 \"apple\" created from new keyword: " + System.identityHashCode(kbi1));
        System.out.println("hash address of kbi1 \"apple\" created from new keyword after intern(): " + System.identityHashCode(kbi1.intern()));

        String kbi2 = new String("oranges");
        System.out.println("hash address of kbi2 \"oranges\" created from new keyword: " + System.identityHashCode(kbi2));
        System.out.println("hash address of kbi2 \"oranges\" created from new keyword after intern(): " + System.identityHashCode(kbi2.intern()));

        String k = "cat";
        String q = "cat";
        System.out.println("hash address of k \"cat\" : " + System.identityHashCode(k));
        System.out.println("hash address of q \"rat\" : " + System.identityHashCode(q));

         k = "basket";
        System.out.println("reassigned value of k as  \"basket\" : " + System.identityHashCode(k));
        System.out.println("hash address of q is still same \"cat\" : " + System.identityHashCode(q));


        String s1 = new String("school");
        System.out.println("hash address of s1 \"school\" : " + System.identityHashCode(s1));

         String s2 = new String("school");
        System.out.println("hash address of s2 \"school\" : " + System.identityHashCode(s2));


        s2 = new String("hmmmm....");
        System.out.println("hash address of s2 \"hmmm....\" : " + System.identityHashCode(s2));



        StringBuffer stringBuffer1 = new StringBuffer("deep");
        String s11 = new String(stringBuffer1);
        stringBuffer1 = stringBuffer1.append("deep");
        System.out.println("value of stringbuffer " + stringBuffer1);
        System.out.println("value of string " + s11);


        //concat

        String a = "america";
        String b ="canada";
        a.concat(b);
        System.out.println("a = " + a);
        System.out.println("b = "+b);
        System.out.println(a.concat(b));

        // join
        System.out.println(String.join(" | " , s1,s2,str1,str3, stringBuffer1,str2));


        //value of --> converts any datatype  to string.
        int t = 99;
        //String tt = (String) t; ---------> inconvertible types
        String tt = String.valueOf(t);
        System.out.println(tt);


    }
}
