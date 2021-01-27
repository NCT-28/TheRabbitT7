package vn.com.rabbit.base.controller.base;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;


public interface BaseCrudController<T, ID> {

    String _add = "add";
    String _update = "update";
    String _delete = "delete";

    String postAdd(HttpServletRequest request, Principal principal) throws Exception;

    String putUpdate(HttpServletRequest request, Principal principal) throws Exception;

    String delete(HttpServletRequest request) throws Exception;

	
}