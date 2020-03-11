import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';


const routes: Routes = [
  {
    path: 'user',
    loadChildren: () => import('./layout/user/user.module').then(mod => mod.UserModule)
  },
  {
    path: 'admin',
    loadChildren: () => import('./layout/admin/admin.module').then(mod => mod.AdminModule)
  },
  {
    path: '',
    loadChildren: () => import('./layout/angel/angel.module').then(mod => mod.AngelModule)
  },
  {
    path: 'index',
    loadChildren: () => import('./layout/index/index.module').then(mod => mod.IndexModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
