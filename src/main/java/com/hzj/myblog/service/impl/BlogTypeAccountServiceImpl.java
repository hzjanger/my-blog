package com.hzj.myblog.service.impl;

import com.hzj.myblog.mapper.BlogTypeAccountMapper;
import com.hzj.myblog.model.BlogTypeAccount;
import com.hzj.myblog.service.BlogTypeAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogTypeAccountServiceImpl implements BlogTypeAccountService {

    @Autowired
    private BlogTypeAccountMapper blogTypeAccountMapper;

    @Override
    public List<BlogTypeAccount> findUserBlogTypeAccount(Integer userId) {
        return blogTypeAccountMapper.findUserBlogTypeAccount(userId);
    }
}
