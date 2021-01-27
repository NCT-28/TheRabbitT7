package vn.com.rabbit.base.sql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.rabbit.base.enums.Ope;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParamsSQL {
    private String key;
    private Ope operation;
    private String type;
    private Object value;
    private String sql;

    public ParamsSQL(String k, Object v) {
        this.key = k;
        this.value = v;
        this.operation = null;
        this.type = null;
        this.sql = null;
    }

    public ParamsSQL(String k, Ope o, String t, Object v) {
        this.key = k;
        this.operation = o;
        this.type = t;
        this.value = v;
        this.sql = null;
    }
}