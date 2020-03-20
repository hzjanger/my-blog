import {Component, OnInit, ViewChild} from '@angular/core';
import {DrawerContainerComponent} from "../../@theme/component/drawer-container/drawer-container.component";
import {SidenavService} from "../../@core/interface/sidenav.service";
import {SidenavMenu} from "../../model/sidenav-menu";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {

  @ViewChild('drawerContainerComponent', {static: false})
  drawerContainerComponent: DrawerContainerComponent;

  sidenavMenus: SidenavMenu[];

  constructor(private sidenavService: SidenavService) {
  }

  ngOnInit() {
    this.getSidenav();
  }

  menuClick() {
    this.drawerContainerComponent.toggle();
  }

  getSidenav() {
    this.sidenavService.getSidenav().subscribe(data => {
      this.sidenavMenus = data;
    })
  }

}
