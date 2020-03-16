package com.hzj.myblog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzj.myblog.entity.PageResult;
import com.hzj.myblog.entity.ReturnResponse;
import com.hzj.myblog.entity.group.BlogAndTypeAndTagGroup;
import com.hzj.myblog.model.Blog;
import com.hzj.myblog.service.BlogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 博客controller层
 *
 * @author hzj
 */
@RestController
@RequestMapping("/blog")
@Api(value = "博客接口", tags = "博客接口")
public class BlogController {

    private Logger logger = LoggerFactory.getLogger(BlogController.class);

    @Autowired
    private BlogService blogService;

    /**
     * 添加博客
     *
     * @param blog 博客信息
     */
    @PostMapping("/addBlog")
    @ApiOperation(value = "添加博客", notes = "添加博客")
    public ReturnResponse<Object> addBlog(@RequestBody Blog blog) {
        blogService.addBlog(blog);
        return new ReturnResponse<>(1, "保存成功", blog);
    }

    @DeleteMapping("/deleteBlog/{blogId}")
    @ApiOperation(value = "删除博客", notes = "删除博客")
    @ApiImplicitParam(name = "blogId", value = "博客id", required = true, paramType = "path", dataType = "Long", example = "22")
    public ReturnResponse<Object> deleteBlog(@PathVariable("blogId") Integer blogId) {
        blogService.deleteBlog(blogId);
        return new ReturnResponse<>(1, "删除成功");
    }

    @GetMapping("/findBlogByUserIdAndTitle/{userId}/{title}")
    @ApiOperation(value = "通过用户的id和博客的标题查找博客", notes = "通过用户的id和博客的标题查找博客")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, paramType = "path", dataType = "Long", example = "6"),
            @ApiImplicitParam(name = "title", value = "博客标题", required = true, paramType = "path", dataType = "String")
    })
    public ReturnResponse<Blog> findBlogByUserIdAndTitle(@PathVariable("userId") Integer userId, @PathVariable("title") String title) {
        Blog blog = blogService.findBlogByUserIdAndTitle(userId, title);
        if (blog == null) {
            return new ReturnResponse<>(0, "没有找到", null);
        }
        return new ReturnResponse<>(1, "查询成功", blog);
    }


    @GetMapping("/searchUserBlog/{userId}")
    @ApiOperation(value = "搜索用户的博客", notes = "current和pageSize默认为1和10,blogType默认为'',searchValue默认为''")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, paramType = "path", dataType = "Long", example = "6"),
            @ApiImplicitParam(name = "pageIndex", value = "页数", paramType = "query", dataType = "Long", example = "1"),
            @ApiImplicitParam(name = "pageSize", value = "页条数", paramType = "query", dataType = "Long", example = "10"),
            @ApiImplicitParam(name = "blogType", value = "博客分类", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "searchValue", value = "博客搜索内容", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "tagName", value = "博客标签", paramType = "query", dataType = "String")
    })
    public ReturnResponse<PageResult<BlogAndTypeAndTagGroup>> searchUserBlog(@PathVariable("userId") Integer userId,
                                                                             @RequestParam(value = "pageIndex", defaultValue = "1") Integer current,
                                                                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                             @RequestParam(value = "blogType", required = false) String blogType,
                                                                             @RequestParam(value = "searchValue", required = false) String searchValue,
                                                                             @RequestParam(value = "tagName", required = false) String tagName) {
        PageHelper.startPage(current, pageSize);
        PageInfo<BlogAndTypeAndTagGroup> pageInfo = new PageInfo<>(blogService.searchUserBlog(userId, blogType, searchValue, tagName));
        PageResult<BlogAndTypeAndTagGroup> pageResult = new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
        return new ReturnResponse<>(1, "查询成功", pageResult);
    }

    @GetMapping("/findBlogById/{id}")
    @ApiOperation("通过博客的id查找博客的信息")
    @ApiImplicitParam(name = "id", value = "博客的id", required = true, paramType = "path", dataType = "Long", example = "1")
    public ReturnResponse<Blog> findBlogById(@PathVariable("id") Integer id) {
        return new ReturnResponse<>(1, "查找成功", blogService.findBlogById(id));
    }

    @PutMapping("/updateBlog")
    @ApiOperation(value = "更新博客的信息")
    public ReturnResponse<Blog> updateBlog(@RequestBody Blog blog) {
        blogService.updateBlog(blog);
        return new ReturnResponse<>(1, "更新成功");
    }
}
