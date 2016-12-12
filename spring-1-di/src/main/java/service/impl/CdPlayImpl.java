package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import service.ICompactDisc;

import javax.inject.Named;

@Named("cdPlayImpl")
public class CdPlayImpl {

    private ICompactDisc compactDisc;

/*    @Autowired(required = false)
    public CdPlayImpl(ICompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }*/

    @Autowired
    //@Qualifier注解是使用限定符的主要方式
    @Qualifier("compactDisc")
    public void setCompactDisc(ICompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }


    public void play() {
        compactDisc.play();
    }
}
