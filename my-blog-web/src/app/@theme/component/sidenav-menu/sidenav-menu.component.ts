import {Component, OnInit} from '@angular/core';
import {SidenavMenu} from "../../../model/sidenav-menu";
import {SidenavService} from "../../../@core/interface/sidenav.service";

@Component({
  selector: 'app-sidenav-menu',
  templateUrl: './sidenav-menu.component.html',
  styleUrls: ['./sidenav-menu.component.scss']
})
export class SidenavMenuComponent implements OnInit {

  sidenavMenu: SidenavMenu[];

  constructor(private sidenavService: SidenavService) {
  }

  ngOnInit() {
    this.getSidenav();
  }

  /**
   * 获取侧边栏数据
   */
  getSidenav() {
    this.sidenavService.getSidenav().subscribe(data => {
      this.sidenavMenu = data;
    })
  }

}
