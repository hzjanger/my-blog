import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {ArticleRoutingModule} from './article-routing.module';
import {ArticleComponent} from './article.component';
import {MarkdownToHTMLDirective} from "../../directive/markdown-to-html.directive";


@NgModule({
  declarations: [
    ArticleComponent,
    MarkdownToHTMLDirective
  ],
  imports: [
    CommonModule,
    ArticleRoutingModule
  ]
})
export class ArticleModule {
}
