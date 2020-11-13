package com.mildw.minsu.service;

import com.mildw.minsu.controller.jwtAuth.rqrs.JwtAuthRq;
import com.mildw.minsu.dao.UserRepository;
import com.mildw.minsu.model.User;
import com.mildw.minsu.util.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public Boolean validateToken(String token){

        String userEmail = jwtTokenProvider.decodeJWT(token).getSubject();
        Optional<User> user = userRepository.findByEmail(userEmail);
        return user.isPresent();

    }

    public String createToken(JwtAuthRq jwtAuthRq) {
        User user = userRepository.findByEmail(jwtAuthRq.getUserEmail())  // email로 등록된 회원을 찾는다.
                .orElseThrow(NullPointerException::new); // 아이디 또는 비밀번호가 일치하지 않습니다 라고 문구띄어야하는데?

        if (!checkPassword(user.getEmail(), jwtAuthRq.getUserPassWord())) {  // 유저가 보유한 패스워드와 입력받은 패스워드가 일치하는 지 확인한다.
            throw new NullPointerException(); // 여기도 문구 넣어줘야하지않나
        }

        return jwtTokenProvider.createJwtToken(jwtAuthRq.getUserEmail()); // email 정보만 가지고 token을 만든다.
    }

    private Boolean checkPassword(String userEmail, String userPasswd){
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(NullPointerException::new);

        return userPasswd.equals(user.getPassword());

    }
}
