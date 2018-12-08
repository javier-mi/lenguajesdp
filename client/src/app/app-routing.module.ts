import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EquationsListComponent } from './equations-list/equations-list.component';
import { EquationEditComponent } from './equation-edit/equation-edit.component';

const routes: Routes = [
	  { path: '', redirectTo: '/equations-list', pathMatch: 'full' },
	  {
	    path: 'equations-list',
	    component: EquationsListComponent
	  },
	  {
	    path: 'equation-add',
	    component: EquationEditComponent
	  },
	  {
	    path: 'equation-edit/:id',
	    component: EquationEditComponent
	  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
