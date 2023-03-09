package org.goafabric.spring.boot.examplebatch.toy;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

public class Writer implements ItemWriter<String> {

    @Override
    public void write(Chunk<? extends String> chunk) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("inside write");
        System.out.println("writing data" + chunk);
    }

}
