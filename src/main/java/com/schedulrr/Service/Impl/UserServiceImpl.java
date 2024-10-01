package com.schedulrr.Service.Impl;

import com.schedulrr.DTO.LoginRequest;
import com.schedulrr.DTO.Response;
import com.schedulrr.DTO.UserDTO;
import com.schedulrr.Entity.User;
import com.schedulrr.Exception.CustomException;
import com.schedulrr.Repository.IUserRepository;
import com.schedulrr.Service.IService.IUserService;
import com.schedulrr.Utils.JWTUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Response register(User user) {
        Response response = new Response();
        try{
            if(user.getRole()==null || user.getRole().isBlank()){
                user.setRole("USER");
            }
            if(userRepo.existsByEmail(user.getEmail())){
                throw new CustomException(user.getEmail() + " Already Exist !! Try Another One");
            }
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setUserName(generateRandomUsername(user.getName()));
            User savedUser = userRepo.save(user);
            UserDTO userDTO = this.modelMapper.map(savedUser, UserDTO.class);

            response.setStatusCode(200);
            response.setUserDTO(userDTO);
        } catch (CustomException ce) {
            response.setStatusCode(400);
            response.setMessage(ce.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error occurred during registration");
        }

        return response;
    }

    @Override
    public Response login(LoginRequest loginRequest) {
        Response response = new Response();
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
            var user =  userRepo.findByEmail(loginRequest.getEmail()).orElseThrow(()-> new CustomException("User not found with email : " + loginRequest.getEmail()));

            var jwtToken = jwtUtils.generateToken((UserDetails) user);
            response.setStatusCode(200);
            response.setToken(jwtToken);
            response.setExpirationTime("7 Days");
            response.setMessage("Login Successfull");

        } catch (CustomException ce) {
            response.setStatusCode(400);
            response.setMessage(ce.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            e.printStackTrace();
            response.setMessage("Error occurred during login");
        }
        return response;
    }

    @Override
    public Response getAllUsers() {
        return null;
    }

    @Override
    public Response getUserBookings(Long userId) {
        return null;
    }

    @Override
    public Response deleteUser(Long userId) {
        return null;
    }

    @Override
    public Response getUserById(Long userId) {
        return null;
    }

    @Override
    public Response getUserInfo(String email) {
        return null;
    }

    public String generateRandomUsername(String baseName){
        Random random = new Random();
        int randomNumber = random.nextInt(9000) + 1000;
        return baseName.toLowerCase().replaceAll("\\s+", "") + randomNumber;
    }
}
