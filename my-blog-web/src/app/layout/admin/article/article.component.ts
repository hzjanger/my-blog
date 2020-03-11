import {Component, OnInit} from '@angular/core';
import {EditorConfig} from "../../../config/EditorConfig";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {MatDialog} from "@angular/material/dialog";
import {ArticleInfoDialogComponent} from "./article-info-dialog/article-info-dialog.component";
import {BlogService} from "../../../@core/interface/blog.service";
import {Blog} from "../../../model/blog";
import {StorageMessage} from "../../../utils/storage-message";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {SnackBarService} from "../../../service/snackBar.service";
import {CodeEnum} from "../../../entity/code-enum";

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.scss']
})
export class ArticleComponent implements OnInit {

  /**
   * editor的配置参数信息
   */
  config: EditorConfig;

  /**
   * 博客id
   */
  blogId: number;

  /**
   * markdown的内容
   */
  markdown: string;

  formGroup: FormGroup;

  constructor(private fb: FormBuilder, private dialog: MatDialog, private blogService: BlogService,
              private snackBarService: SnackBarService, private router: Router, private route: ActivatedRoute) {
    this.config = new EditorConfig({height: '500px'});
    this.markdown = '';
  }

  ngOnInit() {
    this.formGroup = this.fb.group({
      title: [null, Validators.required],
      markdown: [null, [Validators.required]]
    });
    this.route.paramMap.subscribe((params: Params) => {
      this.blogId = +params.get('blogId');
      if (this.blogId) {
        this.findBlogById();
      } else {
        console.log('新增');
      }
    })
  }

  /**
   * 通过博客的id查找博客的信息
   */
  findBlogById() {
    this.blogService.findBlogById(this.blogId, false).subscribe(data => {
      if (data.code === CodeEnum.SUCCESS) {
        this.formGroup.patchValue(data.data);
      }
    })
  }

  /**
   * 表单提交
   */
  submit() {
    if (this.formGroup.invalid) {
      return;
    }

    const userId = JSON.parse(StorageMessage.getUserInfo()).userId;
    this.blogService.findBlogByUserIdAndTitle(userId, this.title.value).subscribe(data => {
      if (data.code === 1) {
        if (!this.blogId) {
          this.snackBarService.failure('博客标题名称存在');
        } else if (data.data.id !== this.blogId && data.data.title === this.title.value) {
          this.snackBarService.failure('博客的标题和你的其他博客的标题冲突');
        } else {
          this.saveBlog();
        }
      } else if (data.code === 0) {
        this.saveBlog();
      }
    })
  }

  /**
   * 点击保存博客
   */
  saveBlog() {
    const dialogRef = this.dialog.open(ArticleInfoDialogComponent, {
      autoFocus: false,
      width: '520px',
      data: {
        dialogTitle: '添加博客'
      }
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        const userId = JSON.parse(StorageMessage.getUserInfo()).userId;
        const blog: Blog = {...result, ...this.formGroup.value, userId};
        this.blogService.addBlog(blog).subscribe(data => {
          console.log(data);
          if (data.code === CodeEnum.SUCCESS) {
            this.snackBarService.success(data.message);
            const nickName = JSON.parse(StorageMessage.getUserInfo()).nickName;
            this.router.navigate([`/index/article/details`, nickName, data.data.id]);
          }
        });
      }
    })
  }

  get title(): FormControl {
    return this.formGroup.get('title') as FormControl;
  }

  /**
   * 得到标题的错误信息
   */
  getTitleErrorMessage() {
    return this.title.hasError('required') ? '输入不能为空' : '';
  }

}
