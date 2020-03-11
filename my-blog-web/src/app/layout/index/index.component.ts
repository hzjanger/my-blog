import {Component, OnInit} from '@angular/core';
import {AuthorService} from "../../@core/interface/author.service";

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.scss']
})
export class IndexComponent implements OnInit {

  constructor(private authorService: AuthorService) {
  }

  ngOnInit() {
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
    console.log('退出登录');
    this.authorService.quit();
  }

}
