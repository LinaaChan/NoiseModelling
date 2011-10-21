package org.noisemap.core;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.TestCase;

public class TestRowsUnionClassification extends TestCase  {

    public void testRowMerge() {
        long deb=System.nanoTime();
        RowsUnionClassification mergeTool=new RowsUnionClassification(50);

        for(int i=51;i<200;i++) {
            mergeTool.addRow(i);
        }

        for(int i=300;i<400;i++) {
            mergeTool.addRow(i);
        }
        for(int i=450;i<1500;i++) {
            mergeTool.addRow(i);
        }
        for(int i=2000;i<20000;i++) {
            mergeTool.addRow(i);
        }
        for(int i=401;i<450;i++) {
            mergeTool.addRow(i);
        }
        mergeTool.addRow(400);
        double timeadd=((System.nanoTime()-deb)/1e6);
        //Test if results is correct
        Iterator<Integer> it=mergeTool.getRowRanges();
        System.out.println("Ranges :");
        List<Integer> correctRanges=new ArrayList<Integer>();
        correctRanges.add(50);
        correctRanges.add(199);
        correctRanges.add(300);
        correctRanges.add(1499);
        correctRanges.add(2000);
        correctRanges.add(19999);

        while(it.hasNext()) {
            int begin=it.next();
            int end=it.next();
            System.out.print("["+begin+"-"+end+"]");
            assertTrue(correctRanges.contains(begin));
            assertTrue(correctRanges.contains(end));
            assertTrue(!(300<begin && begin<1499));
            assertTrue(!(300<end && end<1499));
        }
        System.out.println("");
        System.out.println("Merging of rows took :"+timeadd+" ms");

    }
}
