package com.chamith.employeems.security.servicers;

import com.chamith.employeems.dao.RefreshTokenDao;
import com.chamith.employeems.dao.UserDao;
import com.chamith.employeems.entity.RefreshToken;
import com.chamith.employeems.exception.TokenRefreshException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {

    @Value("${chamith.app.jwtRefreshExpirationMs}")
    private Long refreshTokenDurationMS;

    @Autowired
    private RefreshTokenDao refreshTokenDao;

    @Autowired
    private UserDao userDao;

    public Optional<RefreshToken> findByToken(String token){
        return refreshTokenDao.findByToken(token);
    }

    public RefreshToken createRefreshToken(Long userId){
        RefreshToken refreshToken = new RefreshToken();

        refreshToken.setUser(userDao.findById(userId).get());
        refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMS));
        refreshToken.setToken(UUID.randomUUID().toString());

        refreshToken = refreshTokenDao.save(refreshToken);
        return refreshToken;
    }

    public RefreshToken verifyExpiration(RefreshToken token){
        if (token.getExpiryDate().compareTo(Instant.now()) < 0){
            refreshTokenDao.delete(token);
            throw new TokenRefreshException(token.getToken(), "Refresh token was expired  please make a signin request");
        }

        return token;
    }

    @Transactional
    public int deleteByUserId(Long userId){
        return refreshTokenDao.deleteByUser(userDao.findById(userId).get());
    }
}
