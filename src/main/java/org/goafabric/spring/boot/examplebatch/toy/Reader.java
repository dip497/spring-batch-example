package org.goafabric.spring.boot.examplebatch.toy;


import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class Reader implements ItemReader<String> {
    private String[] arr = {"dipendra sharma","rohan sharma","sushil sharma"};
    private int count;
    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        // TODO Auto-generated method stub
        System.out.println("inside reader");
        if(count<arr.length) {
            return arr[count++];
        }else {
            count=0;
        }
        return null;
    }

}
