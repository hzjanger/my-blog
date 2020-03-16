import {ModuleWithProviders, NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ConfirmDialogComponent} from './component/confirm-dialog/confirm-dialog.component';
import {DialogLayoutComponent} from "./component/dialog-layout/dialog.layout.component";
import {MaterialModule} from "../@material/material.module";
import { HeaderComponent } from './component/header/header.component';
import {RouterModule} from "@angular/router";
import {ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    DialogLayoutComponent,
    ConfirmDialogComponent,
    HeaderComponent
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
    HeaderComponent
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
