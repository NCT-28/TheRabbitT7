package vn.com.rabbit.base.controller.search;
import lombok.Data;
import vn.com.rabbit.base.enums.Ope;

@Data
public class FindOperation {

    private String key;
    private Ope operation;
    private String value;
    private String sql;

    public FindOperation(String key, Ope operation, String value) {
        this.key = key;
        this.operation = operation;
        this.value = value;
        this.sql = null;
    }
}
