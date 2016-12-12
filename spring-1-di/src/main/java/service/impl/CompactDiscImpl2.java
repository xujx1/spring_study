package service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import service.ICompactDisc;

import javax.inject.Named;

/*@Component("compactDiscImpl")*/

/**
 * 使用Named Inject Singleton Qualifier Scope Provider标签
 * 需要引入javax.inject包
 * Inject，一个新的注入依赖规范，既能支持Google Gucie，还能支持Spring
 */
@Named(/*"compactDiscImpl2"*/)
/*@Primary*/
@Qualifier("compactDisc")
public class CompactDiscImpl2 implements ICompactDisc {

    public void play() {
        System.out.println("I can play 2");
    }
}
