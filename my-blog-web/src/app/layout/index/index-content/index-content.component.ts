import {Component, OnInit} from '@angular/core';
import {BlogService} from "../../../@core/interface/blog.service";
import {StorageMessage} from "../../../utils/storage-message";
import {PageResult} from "../../../entity/page-result";
import {Blog} from "../../../model/blog";
import {CodeEnum} from "../../../entity/code-enum";
import {BlogTypeAccountService} from "../../../@core/interface/blog-type-account.service";
import {BlogTypeAccount} from "../../../model/blog-type-account";

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

  constructor(private blogService: BlogService, private blogTypeAccountService: BlogTypeAccountService) {
  }

  ngOnInit() {
    this.nickName = StorageMessage.getUserInfo() && JSON.parse(StorageMessage.getUserInfo()).nickName;
    this.userId = StorageMessage.getUserInfo() && JSON.parse(StorageMessage.getUserInfo()).userId;
    this.findNewestBlog();
    this.findUserBlogTypeAccount();
  }

  /**
   * 查找用户最新的博客
   */
  findNewestBlog() {
    this.blogService.findNewestBlog(this.userId).subscribe(data => {
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


}
