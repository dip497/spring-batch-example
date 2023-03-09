package org.goafabric.spring.boot.examplebatch.toy;


import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;

public class Processor implements ItemProcessor<String, String> {

    @Override
    public String process(String item) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("inside processeor");
        return "Proccessed"+item.toUpperCase();
    }

}

