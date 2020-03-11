import {Component, OnInit, ViewChild} from '@angular/core';
import {MatDrawer} from "@angular/material/sidenav";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {

  @ViewChild('drawer', {static: false})
  drawer: MatDrawer;

  constructor() { }

  ngOnInit() {
  }

  /**
   * 关闭侧边栏
   */
  close() {
    this.drawer.close().then(r => r);
  }

  /**
   * 打开侧边栏
   */
  open() {
    this.drawer.open().then(r => r);
  }

  /**
   * 切换侧边栏
   * 开启切换为关闭
   * 关闭切换为开启
   */
  toggle() {
    this.drawer.toggle().then(r => r);
  }

}
