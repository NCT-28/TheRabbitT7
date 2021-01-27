package vn.com.rabbit.base.controller.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RequestUtils {

    public String[] parseSelect(String s) {
        if (s == null) {
            return null;
        }
        return s.trim().split(",");
    }

    public Sort parseSort(String o) {
        if (o == null) {
            return Sort.unsorted();
        }
        List<Sort.Order> orders = new ArrayList<>();
        for(String s: o.split(",")) {
            if (s.toLowerCase().endsWith(" desc")) {
                orders.add(Sort.Order.desc(s.replaceAll("(?i)desc", "").trim()));
            } else  {
                orders.add(Sort.Order.asc(s.replaceAll("(?i)asc", "").trim()));
            }
        }
        return Sort.by(orders);
    }
}
