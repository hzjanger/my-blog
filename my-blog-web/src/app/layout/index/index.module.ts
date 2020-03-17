import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {IndexRoutingModule} from './index-routing.module';
import {IndexComponent} from './index.component';
import {IndexContentComponent} from "./index-content/index-content.component";
import {MaterialModule} from "../../@material/material.module";
import {ThemeModule} from "../../@theme/theme.module";
import {NgxEchartsModule} from "ngx-echarts";


@NgModule({
  declarations: [
    IndexComponent,
    IndexContentComponent
  ],
  imports: [
    CommonModule,
    IndexRoutingModule,
    MaterialModule,
    ThemeModule,
    NgxEchartsModule

  ]
})
export class IndexModule {
}
