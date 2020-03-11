import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {FormBuilder, FormGroup} from "@angular/forms";
import {BlogTypeService} from "../../../../@core/interface/blog-type.service";
import {BlogType} from "../../../../model/blog-type";
import {TagService} from "../../../../@core/interface/tag-service";
import {MatSelectChange} from "@angular/material/select/typings/select";
import {Tag} from "../../../../model/tag";

@Component({
  selector: 'app-article-info-dialog',
  templateUrl: './article-info-dialog.component.html',
  styleUrls: ['./article-info-dialog.component.scss']
})
export class ArticleInfoDialogComponent implements OnInit {

  /**
   * 弹窗的标题
   */
  dialogTitle: string;

  /**
   * 表单控件
   */
  formGroup: FormGroup;

  /**
   * 博客分类列表
   */
  blogType: BlogType[];

  /**
   * 标签列表
   */
  tagList: Tag[];


  constructor(public dialogRef: MatDialogRef<ArticleInfoDialogComponent>, @Inject(MAT_DIALOG_DATA) private data: any,
              private fb: FormBuilder, private blogTypeService: BlogTypeService, private tagService: TagService) {
  }

  ngOnInit() {
    this.dialogTitle = this.data.dialogTitle;
    this.formGroup = this.fb.group({
      blogTypeId: [null],
      tagId: [null]
    });
    this.findAllBlogType();
  }

  /**
   * 查找所有的博客分类
   */
  findAllBlogType() {
    this.blogTypeService.findAllBlogType().subscribe(data => {
      console.log(data);
      if (data && data.code === 1) {
        this.blogType = data.data;
      }
    })
  }

  /**
   * 博客分类下拉值改变
   * @param selectChange 改变的值
   */
  selectionChange(selectChange: MatSelectChange) {
    console.log(selectChange);
    this.tagService.findTagByBlogTypeId(selectChange.value).subscribe(data => {
      if (data.code === 1) {
        this.tagList = data.data;
      }
    })
  }

  /**
   * 点击确定
   */
  sure() {
    this.dialogRef.close(this.formGroup.value);
  }

}