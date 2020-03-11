import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {BlogLabelRoutingModule} from './blog-label-routing.module';
import {BlogLabelComponent} from './blog-label.component';
import {MaterialModule} from "../../../@material/material.module";


@NgModule({
  declarations: [
    BlogLabelComponent
  ],
  imports: [
    CommonModule,
    BlogLabelRoutingModule,
    MaterialModule
  ]
})
export class BlogLabelModule {
}
