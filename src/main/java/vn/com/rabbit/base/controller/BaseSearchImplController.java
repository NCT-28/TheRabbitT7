package vn.com.rabbit.base.controller;

import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.com.rabbit.base.controller.base.BaseController;
import vn.com.rabbit.base.controller.utils.ControllerUtils;
import vn.com.rabbit.base.service.WhereServiceSQL;

/**
 * @param <T>
 * @author ToanNC7
 */
public abstract class BaseSearchImplController<T> implements BaseController<T, UUID> {

	private final WhereServiceSQL<T, UUID> service;

	protected BaseSearchImplController(WhereServiceSQL<T, UUID> service) {
		this.service = service;
	}

	protected WhereServiceSQL<T, UUID> getService() {
		return this.service;
	}

	/**
	 * Tìm kiếm
	 *
	 * @param search     điều kiện tìm kiếm
	 * @param select     chọn các cột cần hiển thị
	 * @param sort       sắp xếp cột đã chọn
	 * @param pageNumber trang số
	 * @param pageSize   số lượng muốn lấy
	 * @param count      yêu cầu đếm tổng số lượng
	 * @return danh sách đã tìm kiếm
	 */
	@Override
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAll(@RequestParam(name = _search_param, required = false) String search,
			@RequestParam(name = _select_param) String select,
			@RequestParam(name = _orderby_param, required = false) String sort,
			@RequestParam(name = _page_param) Integer pageNumber, @RequestParam(name = _size_param) Integer pageSize,
			@RequestParam(name = _count_param, defaultValue = "true") Boolean count) {
		return ControllerUtils.getAll(service, search, select, sort, pageNumber, pageSize, count);
	}
}