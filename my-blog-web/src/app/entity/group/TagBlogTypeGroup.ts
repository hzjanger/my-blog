import {BlogType} from "../../model/blog-type";

export class TagBlogTypeGroup extends BlogType {
  /**
   * 标签所对应的博客分类
   */
  blogType: BlogType;
}
