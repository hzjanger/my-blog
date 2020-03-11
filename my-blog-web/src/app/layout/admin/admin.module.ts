import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {AdminRoutingModule} from './admin-routing.module';
import {IndexHeaderComponent} from './index-header/index-header.component';
import {SidenavMenuComponent} from './sidenav-menu/sidenav-menu.component';
import {SidenavMenuItemComponent} from './sidenav-menu-item/sidenav-menu-item.component';
import {SidenavUserInfoComponent} from './sidenav-user-info/sidenav-user-info.component';
import {ReactiveFormsModule} from "@angular/forms";
import {AdminComponent} from './admin.component';
import {MaterialModule} from "../../@material/material.module";


@NgModule({
  declarations: [
    IndexHeaderComponent,
    SidenavMenuComponent,
    SidenavMenuItemComponent,
    SidenavUserInfoComponent,
    AdminComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    ReactiveFormsModule,
    MaterialModule
  ]
})
export class AdminModule {
}
