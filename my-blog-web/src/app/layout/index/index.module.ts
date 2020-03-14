import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {IndexRoutingModule} from './index-routing.module';
import {IndexComponent} from './index.component';
import {IndexContentComponent} from "./index-content/index-content.component";
import {MaterialModule} from "../../@material/material.module";


@NgModule({
  declarations: [
    IndexComponent,
    IndexContentComponent
  ],
  imports: [
    CommonModule,
    IndexRoutingModule,
    MaterialModule,

  ]
})
export class IndexModule {
}
