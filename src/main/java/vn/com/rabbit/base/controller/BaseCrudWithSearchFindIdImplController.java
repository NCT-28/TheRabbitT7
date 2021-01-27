package vn.com.rabbit.base.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.com.rabbit.base.controller.base.BaseController;
import vn.com.rabbit.base.controller.base.BaseFindByIdController;
import vn.com.rabbit.base.controller.utils.ControllerUtils;
import vn.com.rabbit.base.entity.BaseEntity;
import vn.com.rabbit.base.service.WhereServiceSQL;

import java.util.UUID;

public abstract class BaseCrudWithSearchFindIdImplController <T extends BaseEntity> extends BaseSearchCrudImplController<T> implements BaseFindByIdController<T, UUID> {
    protected BaseCrudWithSearchFindIdImplController(WhereServiceSQL<T, UUID> service) {
        super(service);
    }

    /**
     * Tìm kiếm theo id
     *
     * @param uuid   id cần tìm
     * @param select chọn các cột cần hiển thị
     * @return Dữ liệu đã tìm kiếm
     */
    @Override
    @GetMapping(value = _find, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> get(
          @RequestParam(name = BaseController._id_param) UUID uuid,
          @RequestParam(name = BaseController._select_param) String select) throws Exception {
        return ControllerUtils.getOne(getService(), uuid, select);
    }
}
