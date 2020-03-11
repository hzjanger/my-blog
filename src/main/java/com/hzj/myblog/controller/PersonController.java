package com.hzj.myblog.controller;

import com.hzj.myblog.entity.AccessToken;
import com.hzj.myblog.entity.Audience;
import com.hzj.myblog.entity.ReturnResponse;
import com.hzj.myblog.service.PersonalService;
import com.hzj.myblog.utils.Md5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hzj
 */
@RestController
@RequestMapping("/person")
public class PersonController {
    private final static Logger logger = LoggerFactory.getLogger(PersonController.class);

    // 博客分类id

    @Autowired
    private PersonalService personalService;

    @Autowired
    private Audience audience;

    /**
     * @param userName 用户名
     * @param passWord 密码
     * @return 返回结果
     */
    @RequestMapping(value = "/exsit", method = RequestMethod.POST)
    public ReturnResponse exsit(@RequestParam(value = "userName") String userName, @RequestParam(value = "passWord") String passWord) {
        String md5PassWord = Md5Utils.getMD5(passWord);
        Map<String, Object> map = new HashMap<>();
//        String accessToken = CreateTokenUtils.createJwt("12345");
        AccessToken accessTokenEntity = new AccessToken();
//        accessTokenEntity.setAccessToken(accessToken);
        accessTokenEntity.setExpiresIn(audience.getExpiresSecond());
        accessTokenEntity.setTokenType("bearer");
        map.put("accessToken", accessTokenEntity);
        return new ReturnResponse(0, map);
    }

    /**
     * @return 返回实体
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ReturnResponse list() {
        return new ReturnResponse(0, null);
    }
}
