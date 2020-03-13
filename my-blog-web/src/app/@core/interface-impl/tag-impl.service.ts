import {Injectable} from "@angular/core";
import {TagService} from "../interface/tag-service";
import {Tag} from "../../model/tag";
import {Observable} from "rxjs";
import {ReturnModel} from "../../entity/return-model";
import {HttpClient} from "@angular/common/http";
import {ProxyPrefix} from "../../entity/proxyPrefix";
import {TagBlogTypeGroup} from "../../entity/group/TagBlogTypeGroup";

@Injectable({
  providedIn: "root"
})
export class TagImplService extends TagService {

  private url: string = `${ProxyPrefix.api}/tag`;

  constructor(private http: HttpClient) {
    super();
  }

  addTag(tag: Tag) {
  }

  deleteTag(id: number) {
  }

  /**
   * 查找所有的标签
   *
   * @return 标签对象列表
   */
  findAllTag(): Observable<ReturnModel<TagBlogTypeGroup[]>> {
    return this.http.get<ReturnModel<TagBlogTypeGroup[]>>(`${this.url}/findAllTag`);
  }

  /**
   * 查找博客分类所对应的标签
   *
   * @param blogTypeId 博客分类id
   * @return 标签对象列表
   */
  findTagByBlogTypeId(blogTypeId: number): Observable<ReturnModel<Tag[]>> {
    return this.http.get<ReturnModel<Tag[]>>(`${this.url}/findTagByBlogTypeId/${blogTypeId}`);
  }

  /**
   * 更新标签的内容
   * @param tag 标签信息
   */
  updateTag(tag: Tag): Observable<ReturnModel<Tag>> {
    return this.http.put<ReturnModel<Tag>>(`${this.url}/updateTag`, tag);
  }

}

