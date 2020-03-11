import {Tag} from "../../model/tag";
import {Observable} from "rxjs";
import {ReturnModel} from "../../entity/return-model";
import {TagBlogTypeGroup} from "../../entity/group/TagBlogTypeGroup";

export abstract class TagService {
  /**
   * 添加标签
   *
   * @param tag 标签信息
   */
  abstract addTag(tag: Tag);

  /**
   * 删除标签
   *
   * @param id 标签id
   */
  abstract deleteTag(id: number);

  /**
   * 查找所有的标签
   *
   * @return 标签对象列表
   */
  abstract findAllTag(): Observable<ReturnModel<TagBlogTypeGroup[]>>;

  /**
   * 查找博客分类所对应的标签
   *
   * @param blogTypeId 博客分类id
   * @return 标签对象列表
   */
  abstract findTagByBlogTypeId(blogTypeId: number): Observable<ReturnModel<Tag[]>>;

  /**
   * 更新标签信息
   *
   * @param tag 标签信息
   */
  abstract updateTag(tag: Tag);
}
