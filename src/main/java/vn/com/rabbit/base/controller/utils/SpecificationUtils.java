package vn.com.rabbit.base.controller.utils;
import lombok.experimental.UtilityClass;
import vn.com.rabbit.base.controller.search.FindOperation;

@UtilityClass
public class SpecificationUtils {

    public <T> UrlSpecification<T> specification(FindOperation filterQuery) {
        if (filterQuery == null) {
            return null;
        }
        return new UrlSpecification<>(filterQuery);
    }
}