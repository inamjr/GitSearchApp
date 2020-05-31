import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ItemsComponent } from './items/items.component';
import { DbinfoComponent } from './dbinfo/dbinfo.component';

const routes: Routes = [
  { path: 'items', component: ItemsComponent },
  { path: 'dbinfo', component: DbinfoComponent },
  { path: '**', component: DbinfoComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
