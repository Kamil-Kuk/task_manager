import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TaskListComponent} from "./component/task-list/task-list.component";
import {TaskFormComponent} from "./component/task-form/task-form.component";

const routes: Routes = [
  { path: 'tasks', component: TaskListComponent },
  { path: 'addtask', component: TaskFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
