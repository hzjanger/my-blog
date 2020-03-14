import {Component, OnInit} from '@angular/core';
import {BlogService} from "../../../@core/interface/blog.service";
import {StorageMessage} from "../../../utils/storage-message";
import {PageResult} from "../../../entity/page-result";
import {Blog} from "../../../model/blog";
import {CodeEnum} from "../../../entity/code-enum";
import {BlogTypeAccountService} from "../../../@core/interface/blog-type-account.service";
import {BlogTypeAccount} from "../../../model/blog-type-account";
import {PageEvent} from "@angular/material/paginator";
import {ActivatedRoute, Params, Router} from "@angular/router";

@Component({
  selector: 'app-index-content',
  templateUrl: './index-content.component.html',
  styleUrls: ['./index-content.component.scss']
})
export class IndexContentComponent implements OnInit {

  pageResult: PageResult<Blog>;

  /**
   * 用户博客分类数量
   */
  blogTypeAccount: BlogTypeAccount[];

  /**
   * 用户的昵称
   */
  nickName: string;

  /**
   * 用户id
   */
  userId: number;

  /**
   * 页条数
   */
  pageSize: number = 10;

  /**
   * 页数
   */
  pageIndex: number = 1;

  constructor(private blogService: BlogService, private blogTypeAccountService: BlogTypeAccountService,
              private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.nickName = StorageMessage.getUserInfo() && JSON.parse(StorageMessage.getUserInfo()).nickName;
    // this.userId = StorageMessage.getUserInfo() && JSON.parse(StorageMessage.getUserInfo()).userId;
    this.userId = +this.route.snapshot.paramMap.get('id');
    this.route.queryParamMap.subscribe((params: Params) => {
      this.pageIndex = +params.get('pageIndex') || 1;
      this.pageSize = +params.get('pageSize') || 10;
      this.findNewestBlog();
    });
    this.findUserBlogTypeAccount();
  }

  /**
   * 查找用户最新的博客
   */
  findNewestBlog() {
    this.blogService.findNewestBlog(this.userId, this.pageIndex, this.pageSize).subscribe(data => {
      if (data.code === CodeEnum.SUCCESS) {
        this.pageResult = data.data;
      }
    })
  }

  /**
   * 查找用户博客分类数量
   */
  findUserBlogTypeAccount() {
    this.blogTypeAccountService.findUserBlogTypeAccount(this.userId).subscribe(data => {
      if (data.code === CodeEnum.SUCCESS) {
        this.blogTypeAccount = data.data;
      }
    })
  }

  /**
   * 分页页数改变事件
   * @param pageEvent 分页事件
   */
  page(pageEvent: PageEvent) {
    this.router.navigate(['./'], {
      queryParams: {
        pageIndex: pageEvent.pageIndex + 1,
        pageSize: pageEvent.pageSize
      },
      relativeTo: this.route
    })
  }


}
