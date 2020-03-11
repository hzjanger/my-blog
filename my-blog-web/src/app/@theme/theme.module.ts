import {ModuleWithProviders, NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ConfirmDialogComponent} from './component/confirm-dialog/confirm-dialog.component';
import {DialogLayoutComponent} from "./component/dialog-layout/dialog.layout.component";
import {MaterialModule} from "../@material/material.module";


@NgModule({
  declarations: [
    DialogLayoutComponent,
    ConfirmDialogComponent
  ],
  imports: [
    CommonModule,
    MaterialModule
  ],
  exports: [
    CommonModule,
    DialogLayoutComponent,
    ConfirmDialogComponent
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
