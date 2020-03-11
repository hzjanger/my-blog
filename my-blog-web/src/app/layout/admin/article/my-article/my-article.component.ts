import {Component, OnInit} from '@angular/core';
import {BlogService} from "../../../../@core/interface/blog.service";
import {StorageMessage} from "../../../../utils/storage-message";
import {Blog} from "../../../../model/blog";
import {CodeEnum} from "../../../../entity/code-enum";
import {PageResult} from "../../../../entity/page-result";
import {MatDialog} from "@angular/material/dialog";
import {
  ConfirmDialogComponent,
  ConfirmDialogInputModule
} from "../../../../@theme/component/confirm-dialog/confirm-dialog.component";
import {SnackBarService} from "../../../../service/snackBar.service";

@Component({
  selector: 'app-my-article',
  templateUrl: './my-article.component.html',
  styleUrls: ['./my-article.component.scss']
})
export class MyArticleComponent implements OnInit {

  current: number = 1;

  pageSize: number = 20;

  pageResult: PageResult<Blog>;

  constructor(private blogService: BlogService, private dialog: MatDialog, private snackbarService: SnackBarService) {
  }

  ngOnInit() {
    this.getMyBlogList();
  }

  getMyBlogList() {

    this.blogService.findNewestBlog(this.userId, this.current, this.pageSize).subscribe(data => {
      if (data.code === CodeEnum.SUCCESS) {
        this.pageResult = data.data;
      }
    })
  }

  /**
   * 删除博客
   * @param blog 博客内容
   */
  deleteBlog(blog: Blog) {
    const dialogData: ConfirmDialogInputModule = {title: '删除提示', content: '你确定要删除吗?'};
    const dialogRef = this.dialog.open(ConfirmDialogComponent, {
      width: '520px',
      data: dialogData
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.blogService.deleteBlog(blog.id).subscribe(data => {
          if (data.code === CodeEnum.SUCCESS) {
            this.snackbarService.success(data.message);
            this.getMyBlogList();
          }
        })

      }
    })
  }

  get userId() {
    return JSON.parse(StorageMessage.getUserInfo()).userId;
  }

  get nickName() {
    return JSON.parse(StorageMessage.getUserInfo()).nickName;
  }

}
