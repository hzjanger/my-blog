import {ModuleWithProviders, NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ConfirmDialogComponent} from './component/confirm-dialog/confirm-dialog.component';
import {DialogLayoutComponent} from "./component/dialog-layout/dialog.layout.component";
import {MaterialModule} from "../@material/material.module";
import {HeaderComponent} from './component/header/header.component';
import {RouterModule} from "@angular/router";
import {ReactiveFormsModule} from "@angular/forms";
import {AdminSubContentComponent} from './component/admin-sub-content/admin-sub-content.component';
import {DrawerComponent} from './component/drawer/drawer.component';
import {SidenavUserInfoComponent} from "./component/sidenav-user-info/sidenav-user-info.component";
import {SidenavMenuItemComponent} from "./component/sidenav-menu-item/sidenav-menu-item.component";
import {SidenavMenuComponent} from "./component/sidenav-menu/sidenav-menu.component";


@NgModule({
  declarations: [
    DialogLayoutComponent,
    ConfirmDialogComponent,
    HeaderComponent,
    AdminSubContentComponent,
    DrawerComponent,
    SidenavUserInfoComponent,
    SidenavMenuItemComponent,
    SidenavMenuComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    RouterModule,
    ReactiveFormsModule
  ],
  exports: [
    CommonModule,
    DialogLayoutComponent,
    ConfirmDialogComponent,
    HeaderComponent,
    AdminSubContentComponent,
    DrawerComponent
  ],
  entryComponents: [
    ConfirmDialogComponent
  ]
})
export class ThemeModule {

  static forRoot(): ModuleWithProviders {
    return <ModuleWithProviders>{
      ngModule: ThemeModule,
      providers: []
    }
  }
}
