package com.hzj.myblog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzj.myblog.entity.PageResult;
import com.hzj.myblog.entity.ReturnResponse;
import com.hzj.myblog.entity.chart.TagWordCloud;
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
    public ReturnResponse<PageResult<Tag>> findAllTag(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        PageInfo<Tag> pageInfo = new PageInfo<>(tagService.findAllTag());
        PageResult<Tag> pageResult = new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
        return new ReturnResponse<>(1, "查找成功", pageResult);

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
     * 统计用户每个标签的数量
     *
     * @param userId 用户id
     * @return 标签数量
     */
    @GetMapping("/tagOfBlogAccount/{userId}")
    @ApiOperation("统计用户每种标签的博客数量")
    @ApiImplicitParam(name = "userId", value = "用户id", required = true, paramType = "path", dataType = "Long", example = "1")
    public ReturnResponse<List<TagWordCloud>> tagOfBlogAccount(@PathVariable("userId") Integer userId) {
        List<TagWordCloud> tagWordClouds = tagService.tagOfBlogAccount(userId);
        return new ReturnResponse<>(1, "查询成功", tagWordClouds);
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
