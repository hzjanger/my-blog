import {Component, OnInit} from '@angular/core';
import {CodeEnum} from "../../../entity/code-enum";
import {TagService} from "../../../@core/interface/tag-service";
import {TagBlogTypeGroup} from "../../../entity/group/TagBlogTypeGroup";

@Component({
  selector: 'app-blog-label',
  templateUrl: './blog-label.component.html',
  styleUrls: ['./blog-label.component.scss']
})
export class BlogLabelComponent implements OnInit {

  displayedColumns: string[] = ['id', 'tagName', 'blogType', 'operation'];

  description: any = {
    id: '编号',
    tagName: '标签',
    operation: '操作'
  };

  blogTag: TagBlogTypeGroup[];

  constructor(private tagService: TagService) {
  }

  ngOnInit() {
    this.getType();
  }

  getType() {
    this.tagService.findAllTag().subscribe(data => {
      if (data.code === CodeEnum.SUCCESS) {
        this.blogTag = data.data;
      }
    })
  }

}
