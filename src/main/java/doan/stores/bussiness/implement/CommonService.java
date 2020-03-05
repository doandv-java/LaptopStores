package doan.stores.bussiness.implement;

import doan.stores.bussiness.BaseService;
import doan.stores.domain.User;
import doan.stores.dto.response.ErrorResponse;
import doan.stores.persistenct.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommonService implements BaseService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getPrincipal() {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findUserByUserNameIs(principal.getUsername());
    }

    @Override
    public List<ErrorResponse> bindingResult(BindingResult result) {
        List<ErrorResponse> errors = new ArrayList<>();
        if (result.hasErrors()) {
            result.getFieldErrors().forEach(fieldError -> errors.add(new ErrorResponse(fieldError.getField(), fieldError.getDefaultMessage())));
        }
        return errors;
    }
}
