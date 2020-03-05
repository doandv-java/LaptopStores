package doan.stores.bussiness;

import doan.stores.domain.User;
import doan.stores.dto.response.ErrorResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface BaseService {

    User getPrincipal();

    List<ErrorResponse> bindingResult(BindingResult result);
}
