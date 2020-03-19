import {Component, OnInit, ViewChild} from '@angular/core';
import {DrawerComponent} from "../../@theme/component/drawer/drawer.component";

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.scss']
})
export class IndexComponent implements OnInit {

  nickName: string;

  @ViewChild("drawerComponent", {static: false})
  drawerComponent: DrawerComponent;

  constructor() {
  }

  ngOnInit() {
  }

  /**
   * 菜单栏点击事件
   */
  menuClick() {
    this.drawerComponent.toggle();
  }

}
