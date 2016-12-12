package service.impl;

import org.springframework.stereotype.Component;
import service.IPerformance;

@Component
public class PerformanceImpl implements IPerformance {

    public String show(String name) {
        return name + "==show";
    }
}
