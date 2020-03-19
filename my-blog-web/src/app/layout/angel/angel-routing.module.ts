import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {IndexComponent} from "./index/index.component";


const routes: Routes = [
  {path: '', component: IndexComponent},
  {
    path: 'article/:userId',
    loadChildren: () => import('../index/index.module').then(mod => mod.IndexModule)
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AngelRoutingModule {
}
