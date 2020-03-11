package com.hzj.myblog.controller;

import com.hzj.myblog.entity.ReturnResponse;
import com.hzj.myblog.model.BlogType;
import com.hzj.myblog.service.BlogTypeService;
import com.hzj.myblog.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogType")
@Api(value = "博客分类接口", tags = "博客分类接口")
public class BlogTypeController {

    @Autowired
    private BlogTypeService blogTypeService;

    @Autowired
    private TagService tagService;

    @PostMapping("/addBlogType")
    @ApiOperation(value = "添加博客分类", notes = "添加博客分类")
    public ReturnResponse<Object> addBlogType(@RequestBody BlogType blogType) {
        blogTypeService.addBlogType(blogType);
        return new ReturnResponse<>(1, "添加成功");
    }

    @DeleteMapping("/deleteBlogType/{id}")
    @ApiOperation(value = "删除博客分类", notes = "通过id删除博客分类")
    @ApiImplicitParam(name = "id", value = "博客分类id", required = true, dataType = "Long", paramType = "path", example = "4")
    public ReturnResponse<Object> deleteBlogType(@PathVariable("id") Integer id) {
        if (tagService.findTagByBlogTypeId(id) != null) {
            return new ReturnResponse<>(0, "该分类下有其他标签,无法删除");
        }
        blogTypeService.deleteBlogType(id);
        return new ReturnResponse<>(1, "删除成功");
    }

    @GetMapping("/findAllBlogType")
    @ApiOperation(value = "查找所有的博客分类", notes = "查找所有的博客分类")
    public ReturnResponse<List<BlogType>> findAllBlogType() {
        return new ReturnResponse<>(1, "查找成功", blogTypeService.findAllBlogType());
    }

    @PutMapping("/updateBlogType")
    @ApiOperation(value = "更新博客分类的信息", notes = "是根据id来进行更新的")
    public ReturnResponse<BlogType> updateBlogType(@RequestBody BlogType blogType) {
        blogTypeService.updateBlogType(blogType);
        return new ReturnResponse<>(1, "更新成功");
    }
}
