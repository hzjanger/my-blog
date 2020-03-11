import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {IndexRoutingModule} from './index-routing.module';
import {IndexComponent} from './index.component';
import {MatToolbarModule} from "@angular/material/toolbar";
import {IndexContentComponent} from "./index-content/index-content.component";
import {MatIconModule} from "@angular/material/icon";
import {MatMenuModule} from "@angular/material/menu";


@NgModule({
  declarations: [
    IndexComponent,
    IndexContentComponent
  ],
  imports: [
    CommonModule,
    IndexRoutingModule,
    MatToolbarModule,
    MatIconModule,
    MatMenuModule
  ]
})
export class IndexModule {
}
