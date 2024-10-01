package com.schedulrr.Service.IService;

import com.schedulrr.DTO.LoginRequest;
import com.schedulrr.DTO.Response;
import com.schedulrr.Entity.User;

public interface IUserService {

    Response register(User user);
    Response login(LoginRequest loginRequest);
    Response getAllUsers();
    Response getUserBookings(Long userId);
    Response deleteUser(Long userId);
    Response getUserById(Long userId);
    Response getUserInfo(String email);

}
