import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {EditorConfig} from "../../../config/EditorConfig";
import {EditorMdDirective} from "../../../directive/editor-md.directive";

@Component({
  selector: 'app-eidtor-md',
  templateUrl: './editor-md.component.html',
  styleUrls: ['./editor-md.component.scss']
})
export class EditorMdComponent implements OnInit {

  /**
   * markdown文章内容表单控件
   */
  @Input()
  markdownForm: FormGroup;

  @Input()
  key: string;

  /**
   * markdown编辑器的属性配置
   */
  @Input()
  conf: EditorConfig;


  @ViewChild(EditorMdDirective, {static: false})
  private editorMdDirective: EditorMdDirective;

  constructor() {
  }

  ngOnInit() {
  }

  get markdown(): FormControl {
    return this.markdownForm.get(this.key) as FormControl;
  }

  /**
   * 同步属性内容
   * @param str 输入的markdown文档
   */
  syncModel(str): void {
    this.markdown.patchValue(str);
  }
}
