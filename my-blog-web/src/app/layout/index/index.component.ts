import {Component, OnInit} from '@angular/core';
import {AuthorService} from "../../@core/interface/author.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.scss']
})
export class IndexComponent implements OnInit {

  nickName: string;

  constructor(private authorService: AuthorService, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.nickName = this.route.snapshot.paramMap.get('nickName');
  }

  /**
   * 是否为登录状态
   */
  get isLogin() {
    return this.authorService.isLogin();

  }

  /**
   * 退出登录
   */
  quit() {
    this.authorService.quit();
  }

}
