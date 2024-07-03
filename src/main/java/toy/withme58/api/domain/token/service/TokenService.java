package toy.withme58.api.domain.token.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import toy.withMe58.api.common.error.ErrorCode;
import toy.withMe58.api.common.exception.ApiException;
import toy.withMe58.api.domain.token.ifs.TokenHelperIfs;
import toy.withMe58.api.domain.token.model.TokenDto;

import java.util.HashMap;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class TokenService {

    private final TokenHelperIfs tokenHelperIfs;

    public TokenDto issueAccessToken(Long userId) {
        var data = new HashMap<String,Object>();

        data.put("userId",userId);

        return tokenHelperIfs.issueAccessToken(data);
    }

    public TokenDto issueRefreshToken(Long userId) {
        var data = new HashMap<String, Object>();

        data.put("userId",userId);

        return tokenHelperIfs.issueRefreshToken(data);
    }


    public Long validationToken(String accessToken) {
        var map = tokenHelperIfs.validationTokenWithThrow(accessToken);

        var userId = map.get("userId");

        Objects.requireNonNull(userId,()->{throw new ApiException(ErrorCode.NULL_POINT);});

        return Long.parseLong(userId.toString());
    }
}
