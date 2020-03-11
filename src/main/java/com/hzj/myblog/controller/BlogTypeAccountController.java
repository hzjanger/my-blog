package com.hzj.myblog.controller;

import com.hzj.myblog.entity.ReturnResponse;
import com.hzj.myblog.model.BlogTypeAccount;
import com.hzj.myblog.service.BlogTypeAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blogTypeAccount")
@Api(value = "用户博客分类数量统计", tags = "用户博客分类数量统计")
public class BlogTypeAccountController {

    @Autowired
    private BlogTypeAccountService blogTypeAccountService;

    /**
     * 查找博客分类数量
     *
     * @return 博客数量列表
     */
    @GetMapping("/findBlogTypeAccount/{userId}")
    @ApiOperation(value = "查询用户博客分类数量", notes = "查询用户博客分类数量")
    @ApiImplicitParam(name = "userId", value = "用户id", required = true, paramType = "path", dataType = "Long", example = "6")
    public ReturnResponse<List<BlogTypeAccount>> findBlogTypeAccount(@PathVariable("userId") Integer userId) {
        List<BlogTypeAccount> blogTypeAccount = blogTypeAccountService.findUserBlogTypeAccount(userId);
        return new ReturnResponse<>(1, "查询成功", blogTypeAccount);
    }


}
