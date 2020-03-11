import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AngelRoutingModule } from './angel-routing.module';
import { IndexComponent } from './index/index.component';


@NgModule({
  declarations: [IndexComponent],
  imports: [
    CommonModule,
    AngelRoutingModule
  ]
})
export class AngelModule { }
