import {Component, OnInit, ViewChild} from '@angular/core';
import {MatDrawer} from "@angular/material/sidenav";

@Component({
  selector: 'app-drawer',
  templateUrl: './drawer.component.html',
  styleUrls: ['./drawer.component.scss']
})
export class DrawerComponent implements OnInit {

  @ViewChild("drawer", {static: false})
  drawer: MatDrawer;

  constructor() {
  }

  ngOnInit() {
  }

  /**
   * 切换此抽屉,如果是开启那么变为关闭,如果是关闭,那么变为开启
   */
  toggle() {
    this.drawer.toggle().then(r => r);
  }

}
