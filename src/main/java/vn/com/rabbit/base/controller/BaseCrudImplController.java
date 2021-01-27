package vn.com.rabbit.base.controller;

import java.security.Principal;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import vn.com.rabbit.base.controller.base.BaseCrudController;
import vn.com.rabbit.base.entity.BaseEntity;
import vn.com.rabbit.base.jpa.JpaService;
import vn.com.rabbit.base.utils.RandomStringUtils;

public abstract class BaseCrudImplController<T extends BaseEntity> implements BaseCrudController<T, UUID> {

    private final JpaService<T, UUID> service;

    protected BaseCrudImplController(JpaService<T, UUID> service) {
        this.service = service;
    }

    protected JpaService<T, UUID> getService() {
        return this.service;
    }

    protected String getCode() {
        String code = RandomStringUtils.randomAlphaNumeric(16);
        T val = getService().getByName("code",code);
        if(val != null){
            code = getCode();
        }
        return code;
    }

    protected ResponseEntity<T> addDefault(T model) {
        model.setUuid(null);
        return ResponseEntity.ok(getService().add(model));
    }

    protected ResponseEntity<T> updateDefault(T model) throws Exception {
        if (model.getUuid() == null) {
            throw new Exception("Id không thể rỗng !");
        }
        return ResponseEntity.ok(getService().update(model));
    }

    @Override
    @DeleteMapping(value = _delete)
    public String delete(HttpServletRequest request) {
    	UUID uuid = UUID.fromString(request.getParameter("id"));
		getService().delete(uuid);
    	return "redirect:" +  request.getHeader("Referer");
    }

    @Override
    @PostMapping(value = _add)
    public abstract String postAdd(HttpServletRequest request, Principal principal) throws Exception;

    @Override
    @PutMapping(value = _update)
    public abstract String putUpdate(HttpServletRequest request, Principal principal) throws Exception;
}