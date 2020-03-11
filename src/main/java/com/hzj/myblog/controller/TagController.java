package com.hzj.myblog.controller;

import com.hzj.myblog.entity.ReturnResponse;
import com.hzj.myblog.model.Tag;
import com.hzj.myblog.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 博客标签controller层
 *
 * @author hzj
 */
@RestController
@RequestMapping("/tag")
@Api(value = "博客标签接口", tags = "博客标签接口")
public class TagController {

    @Autowired
    private TagService tagService;

    /**
     * 添加标签信息
     *
     * @param tag 标签信息
     * @return 操作结果
     */
    @PostMapping("/addTag")
    @ApiOperation(value = "添加标签", notes = "添加标签")
    public ReturnResponse<Object> addTag(@RequestBody Tag tag) {
        tagService.addTag(tag);
        return new ReturnResponse<>(1, "添加成功");
    }

    /**
     * 删除标签
     *
     * @param id 标签id
     * @return 操作结果
     */
    @DeleteMapping("/deleteTag/{id}")
    @ApiOperation(value = "删除标签", notes = "删除标签")
    @ApiImplicitParam(name = "id", value = "标签id", paramType = "path", required = true, dataType = "Long", example = "1")
    public ReturnResponse<Object> deleteTag(@PathVariable("id") Integer id) {
        tagService.deleteTag(id);
        return new ReturnResponse<>(1, "删除成功");

    }

    /**
     * 查找所有的标签信息
     *
     * @return 操作结果
     */
    @GetMapping("/findAllTag")
    @ApiOperation(value = "查找所有的标签", notes = "查找所有的标签")
    public ReturnResponse<List<Tag>> findAllTag() {
        return new ReturnResponse<>(1, "查找成功", tagService.findAllTag());

    }

    /**
     * 查找博客分类所对应的标签
     *
     * @param blogTypeId 博客分类id
     * @return 操作结果
     */
    @GetMapping("/findTagByBlogTypeId/{blogTypeId}")
    @ApiOperation(value = "查找博客分类所对应的标签", notes = "查找博客分类所对应的标签")
    @ApiImplicitParam(name = "blogTypeId", value = "博客分类的id", required = true, paramType = "path", dataType = "Long", example = "1")
    public ReturnResponse<List<Tag>> findTagByBlogTypeId(@PathVariable("blogTypeId") Integer blogTypeId) {
        return new ReturnResponse<>(1, "查找成功", tagService.findTagByBlogTypeId(blogTypeId));

    }

    /**
     * 更新标签信息
     *
     * @param tag 标签信息
     * @return 操作结果
     */
    @PutMapping("/updateTag")
    @ApiOperation(value = "更新标签信息", notes = "更新标签信息")
    public ReturnResponse<Object> updateTag(@RequestBody Tag tag) {
        tagService.updateTag(tag);
        return new ReturnResponse<>(1, "更新成功");
    }
}
