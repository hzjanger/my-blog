import {Blog} from "../../model/blog";
import {Observable} from "rxjs";
import {PageResult} from "../../entity/page-result";
import {ReturnModel} from "../../entity/return-model";

export abstract class BlogService {
  /**
   * 添加博客
   * @param blog 博客
   */
  abstract addBlog(blog: Blog): Observable<ReturnModel<Blog>>;

  /**
   * 删除博客
   * @param id 博客id
   */
  abstract deleteBlog(id: number): Observable<ReturnModel<any>>;

  /**
   * 分页查询用户最新的文章
   * @param userId 用户id
   * @param current 页数
   * @param pageSize 页条数
   */
  abstract findNewestBlog(userId: number, current?: number, pageSize?: number): Observable<ReturnModel<PageResult<Blog>>>;

  /**
   * 通过用户的id和博客的标题查询博客
   * @param userId 用户的id
   * @param title 博客标题
   */
  abstract findBlogByUserIdAndTitle(userId: number, title: string): Observable<ReturnModel<Blog>>;

  /**
   * 通过博客的id查找博客的信息
   * @param id 博客id
   * @param isEncode 是否转义
   */
  abstract findBlogById(id: number, isEncode?: boolean): Observable<ReturnModel<Blog>>;
}
